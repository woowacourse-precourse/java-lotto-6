package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

    @DisplayName("당첨된 로또의 순위를 정상적으로 찾는다.")
    @Test
    void findByMatchingCountAndBonusBall() {
        Lotto first = Lotto.of(List.of(3, 4, 5, 6, 7, 8));
        Lotto second = Lotto.of(List.of(3, 4, 5, 6, 7, 13));
        Lotto third = Lotto.of(List.of(3, 4, 5, 6, 7, 42));
        Lotto forth = Lotto.of(List.of(3, 4, 5, 6, 41, 42));
        Lotto fifth = Lotto.of(List.of(3, 4, 5, 41, 42, 43));
        Lotto none = Lotto.of(List.of(31, 32, 33, 34, 35, 36));
        WinningLotto winningLotto = WinningLotto.of(Lotto.of(List.of(3, 4, 5, 6, 7, 8)), BonusBall.valueOf(13));

        LottoPrize firstPrize = LottoPrize.findByMatchingCountAndBonusBall(first, winningLotto);
        assertThat(firstPrize).isEqualTo(LottoPrize.FIRST_PRIZE);

        LottoPrize secondPrize = LottoPrize.findByMatchingCountAndBonusBall(second, winningLotto);
        assertThat(secondPrize).isEqualTo(LottoPrize.SECOND_PRIZE);

        LottoPrize thirdPrize = LottoPrize.findByMatchingCountAndBonusBall(third, winningLotto);
        assertThat(thirdPrize).isEqualTo(LottoPrize.THIRD_PRIZE);

        LottoPrize forthPrize = LottoPrize.findByMatchingCountAndBonusBall(forth, winningLotto);
        assertThat(forthPrize).isEqualTo(LottoPrize.FORTH_PRIZE);

        LottoPrize fifthPrize = LottoPrize.findByMatchingCountAndBonusBall(fifth, winningLotto);
        assertThat(fifthPrize).isEqualTo(LottoPrize.FIFTH_PRIZE);

        LottoPrize noPrize = LottoPrize.findByMatchingCountAndBonusBall(none, winningLotto);
        assertThat(noPrize).isEqualTo(LottoPrize.NONE);
    }

}