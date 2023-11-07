package lotto.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.fixture.LottoFixture.lottoFixture;
import static lotto.fixture.LottoFixture.lottoNumberFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.dto.WinningLotto;
import lotto.dto.WinningResult;
import lotto.enums.Prize;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    void 로또의_개수를_반환한다() {
        // given
        int lottoCount = 10;
        LottoTicket lottoTicket = IntStream.range(0, lottoCount)
                .mapToObj(i -> lottoFixture())
                .collect(collectingAndThen(toList(), LottoTicket::new));

        // when
        int result = lottoTicket.count();

        // then
        assertThat(result).isEqualTo(lottoCount);
    }

    @Test
    void 당첨_로또와_일치된_결과에_따라_당첨_결과를_반환한다() {
        // given
        int bonusNumber = 7;
        LottoNumber 보너스번호 = lottoNumberFixture(bonusNumber);
        Lotto 일등 = lottoFixture(List.of(1, 2, 3, 4, 5, 6));
        Lotto 이등 = lottoFixture(List.of(1, 2, 3, 4, 5, bonusNumber));
        Lotto 삼등 = lottoFixture(List.of(1, 2, 3, 4, 5, 9));
        Lotto 사등 = lottoFixture(List.of(1, 2, 3, 4, 8, 9));
        Lotto 오등 = lottoFixture(List.of(1, 2, 3, 8, 9, 10));

        LottoTicket lottoTicket = new LottoTicket(List.of(
                일등, 이등, 삼등, 삼등, 사등, 사등, 오등, lottoFixture(List.of(1, 8, 9, 10, 11, 12)),
                lottoFixture(List.of(8, 9, 10, 11, 12, 13)), lottoFixture(List.of(9, 10, 11, 12, 13, 14)),
                lottoFixture(List.of(10, 11, 12, 13, 14, 15)), lottoFixture(List.of(11, 12, 13, 14, 15, 16))
        ));
        WinningLotto winningLotto = new WinningLotto(일등, 보너스번호);

        // when
        WinningResult result = lottoTicket.match(winningLotto);
        Map<Prize, Integer> prizes = result.prizes();

        // then
        assertAll(
                () -> assertThat(prizes.get(Prize.FIRST)).isEqualTo(1),
                () -> assertThat(prizes.get(Prize.SECOND)).isEqualTo(1),
                () -> assertThat(prizes.get(Prize.THIRD)).isEqualTo(2),
                () -> assertThat(prizes.get(Prize.FOURTH)).isEqualTo(2),
                () -> assertThat(prizes.get(Prize.FIFTH)).isEqualTo(1),
                () -> assertThat(prizes.get(Prize.NONE)).isEqualTo(5)
        );
    }
}