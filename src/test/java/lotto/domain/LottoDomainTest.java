package lotto.domain;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.LottoConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoDomainTest {

    LottoDomain lottoDomain = new LottoDomain();

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
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
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
        lottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 10);

        //when
        Map<String, Integer> result = lottoDomain.compareNumbers(lottos, winningNumbers);

        //then
        Assertions.assertThat(result.get(LottoConstants.CORRECT_SIX)).isEqualTo(1);
        Assertions.assertThat(result.get(LottoConstants.CORRECT_FIVE_WITH_BONUS)).isEqualTo(1);

    }

}