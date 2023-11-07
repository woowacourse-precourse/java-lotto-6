package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMoneyTest {

    @DisplayName("구입 금액이 숫자 형식이 아닐 경우 예외가 발생한다.")
    @Test
    void createMoney_숫자형식_아님(){
        assertThatThrownBy(() -> new LottoMoney("test"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구입 금액이 로또 금액과 맞아 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoney_나누어_떨어지지_않는다(){
        assertThatThrownBy(() -> new LottoMoney("83290"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0원일시 예외가 발생한다.")
    @Test
    void createMoneyByZero(){
        assertThatThrownBy(() -> new LottoMoney("83290"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 구입 금액일시 정상적으로 생성된다.")
    @Test
    void createMoney_유효_구입(){
        assertThatCode(() -> new LottoMoney("10000"))
                .doesNotThrowAnyException();
    }


}