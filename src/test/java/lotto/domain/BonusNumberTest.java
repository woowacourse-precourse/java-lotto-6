package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호가 숫자형식이 아니면 예외를 발생한다.")
    @Test
    void BonusNumber_숫자형식_예외처리(){
        assertThatThrownBy (() -> new BonusNumber("asv"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("보너스 번호가 여러개이면 예외를 발생한다.")
    @Test
    void BonusNumber_숫자형식_예외처리_여러개(){
        assertThatThrownBy (() -> new BonusNumber("1,2,3"))
                .isInstanceOf(NumberFormatException.class);
    }

        @DisplayName("보너스 번호가 범위보다 작다면 예외를 발생한다.")
    @Test
    void validateRangeLow(){
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 범위보다 크다면 예외를 발생한다.")
    @Test
    void validateRangeHigh(){
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 적정 범위라면 예외를 발생시키지 않는다.")
    @Test
    void validate_유효숫자(){
        assertThatCode(() -> new BonusNumber(1))
                .doesNotThrowAnyException();
    }

}