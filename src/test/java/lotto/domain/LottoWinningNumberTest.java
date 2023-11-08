package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class LottoWinningNumberTest {
    private LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    void setUp() {
        lottoWinningNumber = new LottoWinningNumber();
    }

    @Test
    @DisplayName("입력받은 리스트와 같은 값을 반환")
    void shouldSetAndGetWinningNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoWinningNumber.getWinningSixNumbersInfo(winningNumbers);
        assertThat(lottoWinningNumber.getWinningNums()).isEqualTo(winningNumbers);
    }

    @Test
    @DisplayName("입력받은 보너스 번호와 같은 값을 반환")
    void shouldSetAndGetBonusNumber() {
        int bonusNumber = 7;
        lottoWinningNumber.getWinningBonusNumbersInfo(bonusNumber);
        assertThat(lottoWinningNumber.getBonusNum()).isEqualTo(bonusNumber);
    }
}