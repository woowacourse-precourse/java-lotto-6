package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import lotto.MissionLottoRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[Unit] PurchasedLottery에 관한 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class PurchasedLotteryTest {

    @Test
    void createLottery_입력된_라운드와_생성된_객체의_라운드가_같아야_된다() {
        LotteryRound round = new LotteryRound(1);
        PurchasedLottery lottery = PurchasedLottery.createLottery(round, new MissionLottoRandom());

        assertThat(lottery.isEqualRound(round))
                .isTrue();
    }

    @Test
    void constructor_같은_값으로_초기화_된_두_객체는_달라야_된다() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LotteryRound round = new LotteryRound(1);
        PurchasedLottery lottery = new PurchasedLottery(round, lotto);

        assertThat(new PurchasedLottery(round, lotto))
                .isNotSameAs(lotto);
    }
}
