package ru.diasoft.spring.homework.service;

import ru.diasoft.spring.homework.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Long count();
    Comment save(Comment comment);
    Comment update(Comment comment);
    void deleteById(Long id);
    List<Comment> findAll();
    Optional<Comment> findById(Long id);
}
