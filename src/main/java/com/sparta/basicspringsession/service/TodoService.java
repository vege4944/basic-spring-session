package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.todoRequest.TodoSaveRequestDto;
import com.sparta.basicspringsession.dto.todoRequest.TodoUpdateRequestDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoDetailResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoSaveResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoSimpleResponseDto;
import com.sparta.basicspringsession.dto.todoResponse.TodoUpdateResponseDto;
import com.sparta.basicspringsession.entity.Todo;
import com.sparta.basicspringsession.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //readonly 라서 savedtodo가 동작하지 않기 때문에 좀 더 안전한 코딩 가능
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) { //1단계 저장
        Todo newTodo = new Todo(// 투두 클릭해서 가보면 id는 db에서 자동 생성해주니까 나머지만 불러오고 entity에 생성자도 만들어주기
                todoSaveRequestDto.getTitle(),
                todoSaveRequestDto.getContents(),
                todoSaveRequestDto.getUsername()
        );
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(
                savedTodo.getId(),
                savedTodo.getTitle(),
                savedTodo.getContents(),
                savedTodo.getUsername()
        );
    }

    public Page<TodoDetailResponseDto> getTodos(int page, int size) { //3단계 pageable을 호출해야되서 써주기
        Pageable pageable = PageRequest.of(page - 1, size); //내부적으로 1페이지가 아니라 0페이지부터니까 -1

        Page<Todo> todos = todoRepository.findAllByOrderByModifiedAtDesc(pageable); //findAllByOrderByModifiedAtDesc option enter 눌러서 todoRepository에 만들어주기

        return todos.map(todo -> new TodoDetailResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getUsername(),
                todo.getComments().size(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        )); //todos에는 fpr문이 없어서 map으로 씀 -> map 이 new TodoSimpleResponseDto 이 타입으로 리턴해줌 // map 이 todo에 하나하나 가서 하나하나 new TodoSimpleResponseDto 로 만들어서 반환을 해줌
    }

    public TodoDetailResponseDto getTodo(Long todoId) { //1단계 단건조회
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("Todo not found."));
        return new TodoDetailResponseDto(//여기서 리턴해줄꺼는 todo가 아니라 tododetailresponsedto 이니까 todo를 tododetailresponsedto로 convert해줘야함
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getUsername(),
                todo.getComments().size(),
                todo.getCreatedAt(),
                todo.getModifiedAt()
        );
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) { //1단계 수정
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("Todo not found."));

        todo.update(
                todoUpdateRequestDto.getTitle(),
                todoUpdateRequestDto.getContents()
        );
        return new TodoUpdateResponseDto(todo.getId()); //todo로 리턴할거 아니고 todoupdateresponsedto로 하는거니까 생성해주고 이 생성자가 id만 필요하니까 todo에 .getID
    }

}
