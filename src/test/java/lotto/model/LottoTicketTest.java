package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    List<Lotto> lottos;

    @BeforeEach
    void setInit() {
        lottos = IntStream.range(0, 2)
                .mapToObj(i -> Lotto.from(List.of(1, 2, 3, 4, 5, 6)))
                .collect(Collectors.toList());
    }

    @Test
    void 전달받은_로또_갯수만큼_저장한다() {
        //when
        LottoTicket lottoTicket = new LottoTicket(lottos);
        //then
        assertThat(lottoTicket.getLottos().size()).isEqualTo(2);
    }

    @Test
    void checkRankings_메서드는_당첨_로또와_비교해_등수를_반환한다() {
        //given
        LottoTicket lottoTicket = new LottoTicket(lottos);
        WinLotto winLotto = new WinLotto(Lotto.from(List.of(1, 2, 3, 20, 21, 22)), new LottoNumber(23));
        //when
        List<Ranking> rankings = lottoTicket.checkRankings(winLotto);
        //then
        assertThat(rankings).containsExactly(Ranking.FIFTH, Ranking.FIFTH);
    }

    @Test
    void getLottosNumber_메서드는_각각의_로또_번호들을_반환한다() {
        //given
        LottoTicket lottoTicket = new LottoTicket(lottos);
        //when
        List<List<Integer>> lottosNumber = lottoTicket.getLottosNumber();
        // then
        assertThat(lottosNumber)
                .containsExactly(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6)
                );
    }
}
