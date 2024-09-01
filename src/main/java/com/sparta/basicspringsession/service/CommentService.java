package com.sparta.basicspringsession.service;

import com.sparta.basicspringsession.dto.commentRequest.CommentSaveRequestDto;
import com.sparta.basicspringsession.dto.commentRequest.CommentUpdateRequestDto;
import com.sparta.basicspringsession.dto.commentResponse.CommentDetailResponseDto;
import com.sparta.basicspringsession.dto.commentResponse.CommentSaveResponseDto;
import com.sparta.basicspringsession.dto.commentResponse.CommentUpdateResponseDto;
import com.sparta.basicspringsession.entity.Comment;
import com.sparta.basicspringsession.entity.Todo;
import com.sparta.basicspringsession.repository.CommentRepository;
import com.sparta.basicspringsession.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("Todo not found."));

        Comment newComment = new Comment(
                commentSaveRequestDto.getContents(),
                commentSaveRequestDto.getUsername(),
                todo
        );

        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(
                savedComment.getId(),
                savedComment.getContents(),
                savedComment.getUsername()
        );
    }

    public List<CommentDetailResponseDto> getComments(Long todoId) {
        List<Comment> commentList = commentRepository.findByTodoId(todoId);

        List<CommentDetailResponseDto> dtoList = new ArrayList<>(); // 리턴을 List<commentdetailresponsedto>를 해줘야 하는데 List<Comment>니까 형변환을 해줘야함
        for (Comment comment : commentList) { //향상된 for 문
            CommentDetailResponseDto dto = new CommentDetailResponseDto( // comment를 List<CommentDetailResponseDto> 에 넣어줘야해서 바꿔줘야함
                    comment.getId(),
                    comment.getContents(),
                    comment.getUsername()
            );
            dtoList.add(dto);
        }
        return dtoList;

    }

    public CommentDetailResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("Comment not found."));

        return new CommentDetailResponseDto(
                comment.getId(),
                comment.getContents(),
                comment.getUsername()
        );
    }

    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new NullPointerException("Comment not found."));

        comment.update(commentUpdateRequestDto.getContents());

        return new CommentUpdateResponseDto(
                comment.getId(),
                comment.getContents()
        );
    }

    @Transactional
    public void deleteComment(Long commentId) {
        if (!commentRepository.existsById(commentId)){  // JPA 에서는 findBYId로 하지말고 존재하는지만 체크하기 // 없으면 삭제하면 안되니까 ! 앞에 붙여주기
            throw new NullPointerException("Comment not found.");
        }
        commentRepository.deleteById(commentId);
    }
}
