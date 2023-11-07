package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.LottoResultStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 발행한 로또 번호의 결과 상태를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1,8,9,10,11,12,1", "1,2,8,9,10,11,2", "1,2,3,8,9,10,3", "1,2,3,4,8,9,4", "1,2,3,4,5,8,5",
            "1,2,3,4,5,7,7", "1,2,3,4,5,6,6"})
    void checkWinningCount(int lotto1, int lotto2, int lotto3, int lotto4, int lotto5, int lotto6, int expectedCount) {
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.of(7, winningNumbers);

        Lotto lotto = new Lotto(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
        LottoResultStatus resultStatus = lotto.getLottoResultStatus(winningNumbers, bonusNumber);
        assertThat(resultStatus).isEqualTo(LottoResultStatus.from(expectedCount));
    }

    @DisplayName("생성된 로또 번호가 오름차순으로 정렬된다.")
    @Test
    void sortLottoNumbers() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        String actual = lotto.getSortedNumbers();
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertThat(actual).isEqualTo(expected);
    }
}