package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.validation.NumberCheckValidator.*;
import static org.assertj.core.api.Assertions.*;

class NumberCheckValidatorTest {

    @Test
    @DisplayName(value = "정상처리")
    void 정상처리() {
        List<Integer> winningNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(winningNumbers::add);
        validateWinningNumber(winningNumbers); //실패할 경우 예외 발생
    }

    @Test
    @DisplayName("중복되는 수가 있을 경우 예외")
    void 중복_예외() {
        List<Integer> winningNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(winningNumbers::add);
        winningNumbers.add(5);

        assertThatThrownBy(() -> validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복되지 않는 숫자를 골라주세요");
    }

    @Test
    @DisplayName("입력받은 로또번호 개수가 6 미만 6 초과")
    void 리스트_사이즈_예외() {
        List<Integer> winningNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 4).forEach(winningNumbers::add);
        assertThatThrownBy(() -> validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 골라주세요");

        winningNumbers.add(5);
        winningNumbers.add(6);
        winningNumbers.add(7);

        assertThatThrownBy(() -> validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 골라주세요");
    }

    @Test
    @DisplayName("입력받은 로또번호가 1미만 45 초과")
    void 범위_초과_예외() {
        List<Integer> winningNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(winningNumbers::add);
        winningNumbers.add(0);

        assertThatThrownBy(() -> validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 ~ 45 사이의 숫자를 골라주세요");

        winningNumbers.remove(5);
        winningNumbers.add(46);

        assertThatThrownBy(() -> validateWinningNumber(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 ~ 45 사이의 숫자를 골라주세요");
    }

    @Test
    @DisplayName("보너스 번호 정상 처리")
    void 보너스_정상_처리() {
        List<Integer> winningNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(winningNumbers::add);

        int bonusNum = 7;

        validateBonusNumber(winningNumbers, bonusNum); // 실패할 경우 예외 발생
    }

    @Test
    @DisplayName("보너스 번호가 로또번호와 중복 예외")
    void 보너스_중복_예외() {
        List<Integer> winningNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(winningNumbers::add);

        int bonusNum = 6;

        assertThatThrownBy(() -> validateBonusNumber(winningNumbers, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호와 중복 될 수 없습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1미만 45 초과 예외")
    void 보너스_범위_초과_예외() {
        List<Integer> winningNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(winningNumbers::add);

        int bonusNum1 = 46;

        assertThatThrownBy(() -> validateBonusNumber(winningNumbers, bonusNum1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 ~ 45 사이 숫자를 골라 주세요");


        int bonusNum2 = 0;

        assertThatThrownBy(() -> validateBonusNumber(winningNumbers, bonusNum2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 ~ 45 사이 숫자를 골라 주세요");
    }
}