package lotto.controller;

import lotto.configuration.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class MoneyControllerTest {

    MoneyController moneyController;

    private static final int ERROR_INPUT = Constants.Rule.PRICE + 1;

    @BeforeEach
    void setUp() {
        moneyController = new MoneyController();
    }

    @Test
    @DisplayName("로또 가격으로 나누어 떨어지지 않으면 에러가 발생한다.")
    public void createMoneyByNotMultipleOfPrice() {
        //when & then
        assertThatThrownBy(() -> moneyController.create(ERROR_INPUT))
                .isInstanceOf(IllegalArgumentException.class);
    }
}