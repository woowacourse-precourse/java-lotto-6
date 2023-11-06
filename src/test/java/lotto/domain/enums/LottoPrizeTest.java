package lotto.domain;

import lotto.domain.enums.LottoPrize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPrizeTest {
    @DisplayName("로또 등수 카운트 검증")
    @Test
    void 로또_등수_카운트() {
        List<Lotto> autoLottoTickets = new ArrayList<>();
        autoLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        autoLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        autoLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        autoLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 10)));
        autoLottoTickets.add(new Lotto(List.of(1, 2, 3, 4, 12, 13)));

        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningLotto);
        List<LottoPrize> allLottoPrizes = winningLotto.getAllLottoPrizes(autoLottoTickets, bonusNumber);

        Map<LottoPrize, Integer> lottoPrizeResults = LottoPrize.lottoPrizeCount(allLottoPrizes);
        List<LottoPrize> ranks = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST);
        List<Integer> rankCounts = new ArrayList<>();
        for (LottoPrize rank : ranks) {
            rankCounts.add(lottoPrizeResults.get(rank));
        }

        Assertions.assertThat(rankCounts).isEqualTo(List.of(0, 1, 1, 2, 1));
    }

}
