package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    void compareLottoNumberTest() {
        int result = lottoResult.compareLottoNumber(List.of(1, 2, 3, 4, 5, 6, 7), List.of(1, 2, 3, 7, 8, 9));
        assertThat(result).isEqualTo(3);
    }

    @Test
    void compareBonusNumberTest() {
        boolean result = lottoResult.compareBonusNumber(List.of(1, 2, 3, 4, 5, 6, 7), List.of(1, 2, 5, 6, 7, 8));
        assertThat(result).isEqualTo(true);
    }

    @Test
    void compareBonusNumberTest2() {
        boolean result = lottoResult.compareBonusNumber(List.of(1, 2, 3, 4, 5, 6, 7), List.of(1, 2, 4, 5, 6, 8));
        assertThat(result).isEqualTo(false);
    }

    @Test
    void getLottoRankTest() {
        lottoResult.getLottoRank(3, false);
        lottoResult.getLottoRank(5, true);
        lottoResult.getLottoRank(5, false);
        lottoResult.getLottoRank(4, true);
        lottoResult.getLottoRank(2, true);
        lottoResult.getLottoRank(6, true);

        assertThat(lottoResult.first).isEqualTo(1);
        assertThat(lottoResult.second).isEqualTo(1);
        assertThat(lottoResult.third).isEqualTo(1);
        assertThat(lottoResult.fourth).isEqualTo(1);
        assertThat(lottoResult.fifth).isEqualTo(1);
    }

    @Test
    void compareLottoTicketTest() {
        lottoResult.compareLottoTicket(List.of(2, 3, 4, 5, 6, 7, 8), List.of(1, 2, 4, 5, 6, 8));
        int result = lottoResult.fourth;
        assertThat(result).isEqualTo(1);
    }

    @Test
    void compareAllLottoTicketTest() {
        LottoTicket lottoTicket1 = new LottoTicket(List.of(3, 4, 5, 6, 7, 8));
        LottoTicket lottoTicket2 = new LottoTicket(List.of(4, 5, 6, 7, 8, 9));

        lottoResult.compareAllLottoTicket(List.of(1, 2, 3, 4, 5, 6, 7), List.of(lottoTicket1, lottoTicket2));
        assertThat(lottoResult.fourth).isEqualTo(1);
        assertThat(lottoResult.fifth).isEqualTo(1);
    }

    @Test
    void getPrizeTest() {
        lottoResult.second = 1;
        lottoResult.fourth = 2;
        double result = lottoResult.getPrize();
        assertThat(result).isEqualTo(30100000);
    }

}