package ru.diasoft.integration;

import org.junit.Test;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.GenericMessage;
import ru.diasoft.integration.domain.Oil;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MessagesTest {
    @Test
    public void testCreateSimpleGenericMessage() {
        // TODO: Создайте сообщение с payload-ом "Hello" с помощью конструктора
        Message<String> message = new GenericMessage<String>("Hello");

        assertNotNull(message);
        assertEquals(GenericMessage.class, message.getClass());
        assertNotNull(message.getPayload());
        assertEquals("Hello", message.getPayload());
    }

    @Test
    public void testCreateGenericMessage() {
        // TODO: Создайте сообщение с пользователем с помощью конструктора
        Message<Oil> message = new GenericMessage<Oil>(new Oil("russia", "paraffin", BigDecimal.valueOf(66.00)));

        assertNotNull(message);
        assertEquals(GenericMessage.class, message.getClass());
        assertNotNull(message.getPayload());
        assertEquals(new Oil("russia", "paraffin", BigDecimal.valueOf(66.00)), message.getPayload());
    }

    @Test
    public void testGenericMessageWithHeaders() {
        // TODO: Создайте сообщение с payload-ом "Hello" и header-ом "to":"World"
        Map<String, Object> headers = Collections.singletonMap("to", "World");
        Message<String> message = new GenericMessage<>("Hello", headers);

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testGenericMessageWithMessageHeaders() {
        // TODO: Создайте сообщение с payload-ом "Hello" и header-ом "to":"World"
        MessageHeaders headers = new MessageHeaders(Collections.singletonMap("to", "World"));
        Message<String> message = new GenericMessage<>("Hello", headers);

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testErrorMessage() {
        // TODO: Создайте сообщение об ошибки с объектом NullPointerException внутри
        Message errorMessage = new ErrorMessage(new NullPointerException());

        assertNotNull(errorMessage);
        assertEquals(ErrorMessage.class, errorMessage.getClass());
        assertEquals(NullPointerException.class, errorMessage.getPayload().getClass());
    }

    @Test
    public void testMessageBuilder() {
        // TODO: Создайте сообщение с payload-ом "Hello" и header-ом "to":"World" с помощью MessageBuilder
        Message message = MessageBuilder.withPayload("Hello")
                .setHeader("to", "World")
                .build();

        assertNotNull(message);
        assertEquals("Hello", message.getPayload());
        assertEquals("World", message.getHeaders().get("to", String.class));
    }

    @Test
    public void testBuildFromMessage() {
        Message<Oil> original = MessageBuilder
                .withPayload(new Oil("russia", "paraffin", BigDecimal.valueOf(66.00)))
                .setHeader("processor", "userService")
                .build();

        // TODO: Создайте новое сообщение с теми же payload и header-ами c помощью MessageBuilder
        Message<Oil> newMessage = MessageBuilder.fromMessage(original).build();

        assertNotNull(newMessage);
        assertEquals(original.getPayload(), newMessage.getPayload());
        assertEquals(original.getHeaders().get("processor"), newMessage.getHeaders().get("processor"));
    }
}
