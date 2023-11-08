package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoValidationTest {

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createValueByNotNumber() {
        String input = "three";

        assertThatThrownBy(() -> LottoValidation.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 숫자여야 합니다.");
    }

    @DisplayName("구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void createValueByUnderThousand() {
        int input = 900;

        assertThatThrownBy(() -> LottoValidation.validateOverStandardUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 최소 1000원입니다.");
    }

    @DisplayName("구입 금액이 1000원으로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createValueByInDivisible() {
        int input = 4400;

        assertThatThrownBy(() -> LottoValidation.validateIsStandardUnit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
    }

    @DisplayName("로또 번호가 1~45사이가 아니면 예외가 발생한다.")
    @Test
    void createLottoNumberByOutOfRange() {
        int number = 46;

        assertThatThrownBy(() -> LottoValidation.validateInRange(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 6개보다 많으면 예외가 발생한다.")
    @Test
    void createLottoByMore() {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int count = lotto.size();

        assertThatThrownBy(() -> LottoValidation.validateIsCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 개수는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByLess() {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int count = lotto.size();

        assertThatThrownBy(() -> LottoValidation.validateIsCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 개수는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 2));

        assertThatThrownBy(() -> LottoValidation.validateIsDuplicated(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoByDuplicateWithBonusNumber() {
        List<Integer> lotto = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThatThrownBy(() -> LottoValidation.validateIsDuplicatedWiningAndBonusNumber(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복을 허용하지 않습니다.");
    }
}
