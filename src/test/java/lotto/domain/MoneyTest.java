package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("타입 예외처리")
    void validateReGex(){
        String init1 = "f!@#@sdf";
        assertThatThrownBy(() -> new Money(init1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000원 이하 예외처리")
    void validateLessThanDivisionFactor(){
        String init1 = "100";
        assertThatThrownBy(() -> new Money(init1))
            .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("1000으로 나눠지지 않는 예외처리")
    void validateDivision(){
        String init1 = "1001";
        assertThatThrownBy(() -> new Money(init1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}