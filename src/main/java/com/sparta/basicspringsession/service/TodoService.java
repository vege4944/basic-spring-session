package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.request.TodoSaveRequestDto;
import com.sparta.basicspringsession.dto.request.TodoUpdateRequestDto;
import com.sparta.basicspringsession.dto.response.TodoDetailResponseDto;
import com.sparta.basicspringsession.dto.response.TodoSaveResponseDto;
import com.sparta.basicspringsession.dto.response.TodoUpdateResponseDto;
import com.sparta.basicspringsession.entity.Todo;
import com.sparta.basicspringsession.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
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

    public TodoDetailResponseDto getTodo(Long todoId) { //1단계 단건조회
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("Todo not found."));
        return new TodoDetailResponseDto(//여기서 리턴해줄꺼는 todo가 아니라 tododetailresponsedto 이니까 todo를 tododetailresponsedto로 convert해줘야함
                todo.getId(),
                todo.getTitle(),
                todo.getContents(),
                todo.getUsername()
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
