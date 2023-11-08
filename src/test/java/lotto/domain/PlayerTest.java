package lotto.domain;

import lotto.domain.exception.LottoExceptionList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @ParameterizedTest
    @DisplayName("금액이 숫자 형태가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1000j", "1q2w3e4r"})
    void givenNotNumberAmount_thenFail(final String money){
        Assertions.assertThatThrownBy(() -> new Player(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoExceptionList.NUMBERS_NOT_PURE_ERROR.getMessage());
    }

    @ParameterizedTest
    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"1400", "51239", "123"})
    void givenAmountNotDividedBy1000_thenFail(final String money){
        Assertions.assertThatThrownBy(() -> new Player(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoExceptionList.NUMBERS_NOT_DIVIDED_ERROR.getMessage());
    }

    @ParameterizedTest
    @DisplayName("금액이 0이하면 예외가 발생한다.")
    @ValueSource(strings = {"0"})
    void givenAmountLessThanZero_thenFail(final String money){
        Assertions.assertThatThrownBy(() -> new Player(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoExceptionList.NUMBERS_NOT_POSITIVE_ERROR.getMessage());
    }
}