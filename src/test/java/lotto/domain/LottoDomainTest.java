package lotto.domain;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.LottoConstants;
import lotto.view.OutputView;
import lotto.view.viewArgument.LottoPrizeMoney;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LottoDomainTest {
    OutputView outputView = new OutputView();
    LottoPrizeMoney lottoPrizeMoney;

    LottoDomain lottoDomain = new LottoDomain(outputView);

    @Test
    void createLottosTest() {
        //given
        int purchaseCount = 3;

        //when
        Lottos lottos = lottoDomain.createLottos(purchaseCount);

        //then
        Assertions.assertThat(lottos.getLottosSize()).isEqualTo(3);

    }

    @Test
    void createWinningNumbersTest() {
        //given
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        //when
        WinningNumbers winningNumbers1 = lottoDomain.createWinningNumbers(winningNumber, bonusNumber);
        WinningNumbers winningNumbers2 = new WinningNumbers(winningNumber, bonusNumber);

        //then
        Assertions.assertThat(winningNumbers1).usingRecursiveComparison().isEqualTo(winningNumbers2);
    }

    @Test
    void compareNumbersTest() {
        //given
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottos.addLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10))));

        WinningNumbers winningNumbers = new WinningNumbers(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 10);

        //when
        Map<String, Integer> result = lottoDomain.compareNumbers(lottos, winningNumbers);

        //then
        Assertions.assertThat(result.get(LottoConstants.CORRECT_SIX)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoConstants.CORRECT_FIVE_WITH_BONUS)).isEqualTo(1);

    }

    @Test
    void printLottoStatsTest() {
        //given
        Map<String, Integer> lottoResult = new HashMap<>();
        lottoResult.put(LottoConstants.CORRECT_TREE, 1);
        int purchaseAmount = 10;

        //when
        double earningRatio = lottoDomain.printLottoStats(lottoResult, purchaseAmount);

        //then
        Assertions.assertThat(earningRatio).isEqualTo(50.0f);
    }

}