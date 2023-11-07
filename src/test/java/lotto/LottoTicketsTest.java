package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        Lotto oneLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = Lotto.of(List.of(1, 3, 5, 7, 9, 11));
        Lotto anotherLotto = Lotto.of(List.of(11, 12, 13, 14, 15, 16));

        lottoTickets = LottoTickets.of(List.of(oneLotto, otherLotto, anotherLotto));
    }

    @DisplayName("여러 개의 로또로 LottoTickets class 를 만들 수 있다.")
    @Test
    void generateLottoTicketsWithLottos() {
        // given

        // when
        // then
        assertThat(lottoTickets).isNotNull();
    }

    @DisplayName("LottoTickets class 의 사이즈를 알 수 있다.")
    @Test
    void getLottoTicketsSize() {
        // given

        // when
        int size = lottoTickets.size();

        // then
        assertEquals(3, size);
    }

    @DisplayName("LottoTickets 과 winningLotto 를 비교해 결과를 얻을 수 있다.")
    @Test
    void getLottoRanks() {
        // given
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.from(7));

        // when
        List<LottoRank> lottoRanks = lottoTickets.match(winningLotto);

        // then
        assertEquals(LottoRank.FIRST, lottoRanks.get(0));
        assertEquals(LottoRank.FIFTH, lottoRanks.get(1));
        assertEquals(LottoRank.NONE, lottoRanks.get(2));
    }
}