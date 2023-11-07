package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultsTest {
    private LuckyNumbers luckyNumbers;

    @BeforeEach
    void setup() {
        luckyNumbers = new LuckyNumbers(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(7));
    }

    @Test
    @DisplayName("상금합 구하기")
     void calculate() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));    //1등
        Lotto lotto2 = new Lotto(List.of(7, 8, 3, 4, 5, 6));    //4등
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto1,lotto2));

        // when
        WinningResults winningResult = new WinningResults(lottoTicket,luckyNumbers);

        // then
        long expect = Rank.FIRST.getAmount() + Rank.FOURTH.getAmount();
        assertThat(winningResult.calculatePrizeSum()).isEqualTo(expect);
    }
}