package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberValidatorTest {
    @DisplayName("입력한 당첨 로또 번호가 공백일 경우 예외를 발생시킨다.")
    @Test
    void validateLottoByBlankInput(){
        List<Integer> LottoNumber = List.of();
        assertThatThrownBy(() -> LottoNumberValidator.validate_MIN_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 로또 번호가 7개 이상인 경우 예외를 발생시킨다.")
    @Test
    void validateLottoByOverSize(){
        List<Integer> LottoNumber = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(() -> LottoNumberValidator.validate_MIN_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 당첨 로또 번호가 5개 이하인 경우 예외를 발생시킨다.")
    @Test
    void validateLottoByUnderSize(){
        List<Integer> LottoNumber = List.of(1,2,3,4,5);
        assertThatThrownBy(() -> LottoNumberValidator.validate_MIN_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 당첨 로또 번호가 중복된 숫자 경우 예외를 발생시킨다.")
    @Test
    void validateLottoByDuplication(){
        List<Integer> LottoNumber = List.of(1,2,3,4,5,5);
        assertThatThrownBy(() -> LottoNumberValidator.validate_MIN_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 로또 번호(보너스 번호 포함)가 공백일 경우 예외를 발생시킨다.")
    @Test
    void validateWinningLottoByBlank(){
        List<Integer> LottoNumber = List.of();
        assertThatThrownBy(() -> LottoNumberValidator.validate_MAX_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 당첨 로또 번호(보너스 번호 포함)가 8개 이상인 경우 예외를 발생시킨다.")
    @Test
    void validateWinningLottoByOverSize(){
        List<Integer> LottoNumber = List.of(1,2,3,4,5,6,7,8);
        assertThatThrownBy(() -> LottoNumberValidator.validate_MAX_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 당첨 로또 번호(보너스 번호 포함)가 6개 이하인 경우 예외를 발생시킨다.")
    @Test
    void validateWinningLottoByUnderSize(){
        List<Integer> LottoNumber = List.of(1,2,3,4,5,6);
        assertThatThrownBy(() -> LottoNumberValidator.validate_MAX_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 당첨 로또 번호(보너스 번호 포함)가 중복된 숫자가 있는 경우 예외를 발생시킨다.")
    @Test
    void validateWinningLottoByDuplication(){
        List<Integer> LottoNumber = List.of(1,2,3,4,5,6,6);
        assertThatThrownBy(() -> LottoNumberValidator.validate_MAX_SIZE(LottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
