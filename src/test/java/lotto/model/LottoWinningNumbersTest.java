package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {

    @DisplayName(",로 구분된 6개의 숫자가 정상 저장된다.")
    @Test
    void successCreateLottoWinningNumbers() {
        LottoWinningNumbers winningNumbers =
                new LottoWinningNumbers("1,2,3,4,5,6");

        assertThat(winningNumbers.getLottoNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}