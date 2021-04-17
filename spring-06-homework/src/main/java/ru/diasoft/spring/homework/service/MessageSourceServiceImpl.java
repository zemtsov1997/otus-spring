package ru.diasoft.spring.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.diasoft.spring.homework.config.AppConfig;
import ru.diasoft.spring.homework.config.QuestionProperties;

@Service
@RequiredArgsConstructor
public class MessageSourceServiceImpl implements MessageSourceService{

    private final QuestionProperties questionProperties;
    private final MessageSource messageSource;

    @Override
    public String getMessage(String prop) {
        return this.getMessage(prop, new Object() {});
    }

    @Override
    public String getMessage(String prop, Object... objects) {
        return messageSource.getMessage(prop, objects, questionProperties.getLocale());
    }

}
