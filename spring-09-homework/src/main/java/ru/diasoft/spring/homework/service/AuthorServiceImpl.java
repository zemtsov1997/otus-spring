package ru.diasoft.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.diasoft.spring.homework.entity.Author;
import ru.diasoft.spring.homework.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Long count() {
        return authorRepository.count();
    }

    @Transactional
    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }
}
