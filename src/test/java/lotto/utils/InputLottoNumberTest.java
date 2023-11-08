package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputLottoNumberTest {


    @DisplayName("빈 칸이 입력으로 들어왔을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {""})
    void 입력값_빈칸인_경우(String input) {
        assertThatThrownBy(() -> Validator.checkNullValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력된 값이 없습니다 확인해주세요");
    }

    @DisplayName("보너스 번호가 형식에 올바르지 않게 들어왔을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,false,4,5"})
    void 보너스번호_입력형태_잘못된_경우(String input) {
        assertThatThrownBy(() -> Validator.checkBonusNumberForm(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 형식에 올바르게 입력되지 않았습니다.");
    }

    @Test
    void 보너스번호_당첨번호_포함된_경우(String input) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 55);
        Integer bonusNumber = Integer.parseInt("1");
        assertThatThrownBy(() -> Validator.checkBonusNumber(winningNumbers,bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 중복된 번호가 존재합니다.");
    }

    @DisplayName("당첨 번호가 형식에 올바르지 않게 들어왔을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,false,4,5"})
    void 당첨번호_입력형태_잘못된_경우(String input) {
        assertThatThrownBy(() -> Validator.checkWinningNumberForm(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력 형식에 올바르게 입력되지 않았습니다.");
    }

    @Test
    void 당첨번호_범위_내_포함되지_않는_경우() {
        List<Integer> invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 55);
        assertThatThrownBy(() -> Validator.checkWinningNumber(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 각 로또 번호는 1과 45 사이의 값이어야 합니다.");
    }

    @Test
    void 당첨번호_6개_이하인_아닌경우() {
        List<Integer> invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validator.checkWinningNumber(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 개수가 6개가 아닙니다.");
    }

    @Test
    void 당첨번호_6개_초과인_아닌경우() {
        List<Integer> invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5,6,7);
        assertThatThrownBy(() -> Validator.checkWinningNumber(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호 개수가 6개가 아닙니다.");
    }

    @Test
    void 당첨번호_중복된_숫자가_있는경우() {
        List<Integer> invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 6,6);
        assertThatThrownBy(() -> Validator.checkWinningNumber(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호에 중복된 번호가 존재합니다.");
    }


}
