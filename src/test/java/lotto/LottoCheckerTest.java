package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCheckerTest {

    private static final List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    private static final Lotto lotto = new Lotto(lottoNumbers);

    @DisplayName("보너스가 기존 번호와 중복되면 예외가 발생한다.")
    @Test
    void createLottoCheckerByDuplicatedNumber() {
        assertThatThrownBy(() -> new LottoChecker(lotto, lottoNumbers.get(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스가 가능한 최솟값보다 작으면 예외가 발생한다.")
    @Test
    void createLottoCheckerByBonusNumberLessThanMinimumValue() {
        assertThatThrownBy(() -> new LottoChecker(lotto, LottoEnum.NUMBER_MIN.getValue() - 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스가 가능한 최댓값보다 크면 예외가 발생한다.")
    @Test
    void createLottoCheckerByBonusNumberGreaterThanMaximumValue() {
        assertThatThrownBy(() -> new LottoChecker(lotto, LottoEnum.NUMBER_MAX.getValue() + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
