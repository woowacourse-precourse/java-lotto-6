package lotto.validator;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoValidatorTest {
    private static WinningLottoValidator winningLottoValidator = new WinningLottoValidator();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 보너스_넘버_범위_에외_테스트(int bonusNum) {
        assertThatThrownBy(() -> winningLottoValidator.checkRange(bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    }

    @DisplayName("당첨 번호에 보너스 넘버가 중복되어 들어 있는지 확인")
    @Test
    void 보너스_넘버_중복_에외_테스트() {
        int bonusNum = 3;
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);
        assertThatThrownBy(() -> winningLottoValidator.checkDuplicateWinningNumbers(lotto, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("[ERROR] 보너스 번호가 당첨 번호와 겹칩니다.");

    }

    @DisplayName("당첨 번호에 보너스 넘버가 중복되지 않아 통과하는 테스트")
    @Test
    void 보너스_넘버_중복_테스트() {
        int bonusNum = 7;
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);
        assertThatCode(() -> winningLottoValidator.checkDuplicateWinningNumbers(lotto, bonusNum))
                .doesNotThrowAnyException();

    }
}
