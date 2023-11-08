package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.LottoValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호가 숫자형식이 아니면 예외를 발생한다.")
    @Test
    void validateNumberic(){
        assertThatThrownBy(() -> LottoValidator.validNumberic("a,b,c,d,e,f"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외를 발생한다.")
    @Test
    void validateSize(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복되면 예외를 발생한다.")
    @Test
    void validateDuplicate(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위보다 작다면 예외를 발생한다.")
    @Test
    void validateRangeLow(){
        assertThatThrownBy(() -> new Lotto(List.of(0,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 범위보다 크다면 예외를 발생한다.")
    @Test
    void validateRangeHigh(){
        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}