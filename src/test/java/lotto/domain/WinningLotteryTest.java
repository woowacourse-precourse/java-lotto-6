package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.CustomLotteryRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Unit] WinningLottery에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class WinningLotteryTest {

    @ParameterizedTest
    @MethodSource
    void constructor_null을_입력하면_예외를_발생시킨다(Lotto lotto, BonusNumber number) {
        assertThatThrownBy(() -> new WinningLottery(lotto, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    Stream<Arguments> constructor_null을_입력하면_예외를_발생시킨다() {
        return Stream.of(arguments(new Lotto(List.of(1, 2, 3, 4, 5, 6)), null),
                arguments(null, new BonusNumber(0)));
    }


    @Test
    void getResultFrom_일치하는_것이_없는_두_로또를_비교하면_emptyResults와_같은_값을_반환해야_한다() {
        Lotto lotto = new Lotto(List.of(1,23,4,5,6));
        LotteryRound round = new LotteryRound(1);
        PurchasedLottery lottery = new PurchasedLottery(round,lotto);
        WinningLottery winningLottery = new WinningLottery(new Lotto(List.of(7,8,9,10,11,12)),new BonusNumber(13));

        assertThat(winningLottery.getResultFrom(lottery, List.of(CustomLotteryRanking.values())))
                .isEqualTo(LotteryResults.emptyResults());
    }
}
