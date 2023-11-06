package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("구입 금액에 숫자 외의 문자가 입력되면 예외를 발생한다.")
    @Test
    void createBonusByNotNumber() {
        assertThatThrownBy(() -> new Money("abc"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000 원 미만이라면 예외를 발생한다.")
    @Test
    void createBonusByOverRange() {
        assertThatThrownBy(() -> new Money("0"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액의 단위가 1,000 원이 아니라면 예외를 발생한다.")
    @Test
    void createBonusByDuplicatedAnswer() {
        assertThatThrownBy(() -> new Money("1111"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}