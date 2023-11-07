package lotto.domain;

import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

}