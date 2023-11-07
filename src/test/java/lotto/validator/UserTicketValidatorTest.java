package lotto.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.validator.UserTicketValidator.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTicketValidatorTest {
    @Test
    @DisplayName("티켓 가격이 정수가 아닐 때 예외 발생")
    void validateTicketPriceIntegerTest() {
        String input = "1000j";
        assertThrows(
            IllegalArgumentException.class,
            () -> validateTicketPriceInteger(input)
        );
    }

    @Test
    @DisplayName("티켓 가격이 1000의 배수가 아닐 때 예외 발생")
    void validateTicketRightMultipleTest() {
        String input = "12340";
        assertThrows(
            IllegalArgumentException.class,
            () -> validateTicketPriceIsMultiple(input)
        );
    }

    @Test
    @DisplayName("티켓의 갯수가 0이하가 될때 예외 발생")
    void validateTicketPriceCountTest() {
        String input = "-1000";
        assertThrows(
            IllegalArgumentException.class,
            () -> validateTicketPriceCount(input)
        );
    }
}