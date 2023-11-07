package lotto.controller;


import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest extends NsTest {
    private final NumberValidator numberValidator = NumberValidator.getInstance();

    @DisplayName("문자열 입력이 공백이다.")
    @Test
    void validateStringFormat() {
        assertThatThrownBy(() -> numberValidator.validateBlankInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력은 공백이어선 안됩니다. 다시 입력하세요.");
    }

    @DisplayName("문자열 입력의 시작과 끝이 쉼표이다.")
    @Test
    void validateStringFormat1() {
        numberValidator.validateWinningNumbers(",1,2,3,4,5,");

        assertThat(output()).contains("[ERROR] 입력의 시작과 끝은 쉼표가 될 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("문자열 입력의 시작과 끝이 쉼표이다.")
    @Test
    void validateStringFormat2() {
        numberValidator.validateWinningNumbers("1,2,3,4,,5,6");

        assertThat(output()).contains("[ERROR] 쉼표는 연속될 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("문자열 입력이 숫자가 아닌 다른 문자가 포함되어 있다. (쉼표 제외)")
    @Test
    void validateStringFormat3() {
        numberValidator.validateWinningNumbers("1,2,3,4,a,6");

        assertThat(output()).contains("[ERROR] 입력은 숫자이어야 합니다. 다시 입력하세요.");
    }

    @DisplayName("당첨 번호 입력이 6개가 아니다.")
    @Test
    void validateNumbersSize() {
        numberValidator.validateWinningNumbers("1,2,3,4,5");

        assertThat(output()).contains("[ERROR] 당첨 번호의 개수는 6개이어야 합니다. 다시 입력하세요.");
    }

    @DisplayName("당첨 번호의 범위가 1~45가 아니다.")
    @Test
    void validateNumbersBoundary() {
        numberValidator.validateWinningNumbers("1,2,3,4,5,46");

        assertThat(output()).contains("[ERROR] 당첨 번호는 1~45 사이의 숫자입니다. 다시 입력하세요.");
    }

    @DisplayName("당첨 번호가 중복된다")
    @Test
    void validateDuplicateNumber() {
        numberValidator.validateWinningNumbers("1,2,3,4,5,5");

        assertThat(output()).contains("[ERROR] 당첨 번호는 중복될 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("보너스 번호가 숫자가 아니다.")
    @Test
    void validateNumberFormat() {
        numberValidator.validateWinningNumbers("a");

        assertThat(output()).contains("[ERROR] 입력은 숫자이어야 합니다. 다시 입력하세요.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된다.")
    @Test
    void validateDuplicateBonusNumber() {
        numberValidator.validateWinningBonusNumber(List.of(1,2,3,4,5,6), "6");

        assertThat(output()).contains("[ERROR] 당첨 번호는 중복될 수 없습니다. 다시 입력하세요.");
    }

    @DisplayName("보너스 번호가 1~45사이의 숫자가 아니다.")
    @Test
    void validateNumberBoundary() {
        numberValidator.validateWinningBonusNumber(List.of(1,2,3,4,5,6), "47");

        assertThat(output()).contains("[ERROR] 당첨 번호는 1~45 사이의 숫자입니다. 다시 입력하세요.");
    }

    @Override
    protected void runMain() {
    }
}