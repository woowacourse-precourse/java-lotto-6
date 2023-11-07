package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @DisplayName("산 로또의 개수는 구입 금액에서 1000을 나눈 몫이여야 한다.")
    @Test
    void generateRandomLottoNumbers() {
        //given
        final long money1 = 3000L;
        final long oneThousand = 1000L;
        LottoService lottoService = new LottoService();

        //when
        long result1 = lottoService.generateRandomLottoNumbers(money1 / oneThousand).size();

        //then
        org.assertj.core.api.Assertions.assertThat(result1).isEqualTo(money1 / oneThousand);

    }

    @Test
    void countMatchingWinningNumbers() {
    }

    @Test
    void countMatchingBonusNumbers() {
    }

    @Test
    void generateResultScoreBoard() {
    }

    @Test
    void getResultScoreBoard() {
    }

    @Test
    void calculateLottoScore() {
    }
}