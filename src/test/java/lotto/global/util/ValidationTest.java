package lotto.global.util;

import lotto.domain.lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        validation = new Validation();
    }

    @DisplayName("빈 값을 입력하면 예외가 발생한다.")
    @Test
    void inputEmptyValue() {
        assertThatThrownBy(() -> validation.oneWordAndOver(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 한 글자 이상 입력해 주세요.");
    }

    @DisplayName("입력값이 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void inputNotMultipleOf1000() {
        assertThatThrownBy(() -> validation.multipleOfThousand(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 1,000원 단위로 입력해 주세요.");
    }

    @DisplayName("입력값이 음수면 예외가 발생한다.")
    @Test
    void inputNegative() {
        assertThatThrownBy(() -> validation.multipleOfThousand(-2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매금액은 1,000원 단위로 입력해 주세요.");
    }

    @DisplayName("구매금액이 100,000원을 초과하면 예외가 발생한다.")
    @Test
    void buyOver100000() {
        assertThatThrownBy(() -> validation.hundredThousandOrUnder(110000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 10만원 이하로 구입할 수 있습니다.");
    }

    @DisplayName("1~45 사이의 수가 아니면 예외가 발생한다.")
    @Test
    void inputNumberOutOfRange() {
        assertThatThrownBy(() -> validation.isInRangeOf1To45(50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력된 숫자가 6개를 초과하면 예외가 발생한다.")
    @Test
    void inputMoreThanSixNumbers() {
        assertThatThrownBy(() -> validation.isSixNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자만 입력해 주세요.");
    }

    @DisplayName("입력된 숫자가 6개 미만이면 예외가 발생한다.")
    @Test
    void inputLessThanSixNumbers() {
        assertThatThrownBy(() -> validation.isSixNumbers(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 6개의 숫자만 입력해 주세요.");
    }

    @DisplayName("입력된 숫자에 중복값이 있으면 예외가 발생한다.")
    @Test
    void inputDuplicateNumbers() {
        assertThatThrownBy(() -> validation.hasDuplicateNumbers(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복이 없어야 합니다.");
    }

    @DisplayName("리스트 내에 특정 숫자가 있으면 예외가 발생한다.")
    @Test
    void pickExistNumberInList() {
        assertThatThrownBy(() -> validation.hasSameNumberInList(1, Arrays.asList(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}