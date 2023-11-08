package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.ConsoleOutput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EvaluatorTest {
    @DisplayName("로또 번호 6개 중 보너스 번호와 일치하는 숫자가 있다면 예외가 발생한다.")
    @Test
    void createEvaluatorWithDuplicatedBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 3;
        assertThatThrownBy(() -> new Evaluator(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 비교가 정확히 이루어 지는 가?")
    @Test
    void checkEvaluatorExactlyCompare() {
        // create winning Lotto, bonus number
        Lotto winningLotto = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Integer bonusNumber = 1;

        // create LottoTicket
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < i + 6; j++) {
                list.add(j);
            }
            lottos.add(new Lotto(list));
        }

        LottoTicket lottoTicket = new LottoTicket(lottos);

        // test
        Evaluator evaluator = new Evaluator(winningLotto, bonusNumber);
        evaluator.judgeLottoTicket(lottoTicket);

        Integer totalAmount = evaluator.getResult().getTotalPrizeAmount();
        Integer answer = Arrays.asList(PrizeRankConstants.values())
                .stream()
                .mapToInt(rank -> rank.getEarnings())
                .sum();

        assertThat(totalAmount.equals(answer));
    }

}