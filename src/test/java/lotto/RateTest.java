package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RateTest {
    private WinningNumber winningNumber;
    private Lottos lottos;

    @BeforeEach
    void setup() {
        winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("로또 1장을 구입했을 때 1등일 경우")
    @Test
    void calculateRateWithValidData() {
        // given
        Money money = new Money(1000); // 1,000원으로 로또 1장 구입
        lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)) // 당첨 6개 = 1등
        ));
        RankResult rankResult = new RankResult();
        rankResult.calcRankResult(winningNumber, lottos);

        // when
        Rate rate = new Rate(money, rankResult);

        // then
        assertThat(rate.getRate()).isEqualTo(2.0E8);
    }

    @DisplayName("로또 2장을 구입했을 때 각각 4등, 5등일 경우")
    @Test
    void calculateRateWithFourthAndFifth() {
        // given
        Money money = new Money(2000); // 2,000원으로 로또 2장 구입
        lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)), // 당첨 4개 = 4등
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)) // 당첨 3개 = 5등
        ));
        RankResult rankResult = new RankResult();
        rankResult.calcRankResult(winningNumber, lottos);

        // when
        Rate rate = new Rate(money, rankResult);

        // then
        assertThat(rate.getRate()).isEqualTo(2750);
    }
}
