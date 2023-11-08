package lotto.model;

import lotto.constant.LotteryRank;
import lotto.utils.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @DisplayName("로또 게임 이용자의 당첨 내역 테스트")
    @ParameterizedTest
    @MethodSource("generateLotto")
    void winningDetailTest(Lotto winningLotto, int bonusNumber, List<Lotto> lottos, int amount, WinningDetails expected) {
        // given
        LottoMachine lottoMachine = new LottoMachine(winningLotto, bonusNumber);
        Player player = new Player(new Capital(amount));
        player.setLotto(lottos);

        // when
        WinningDetails result = player.getWinningDetails(lottoMachine);

        // then
        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        7,
                        List.of(
                                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                                new Lotto(List.of(1, 2, 3, 8, 9, 10))
                        ),
                        5000,
                        new WinningDetails(
                                Map.ofEntries(
                                        new AbstractMap.SimpleEntry<>(LotteryRank.FIRST_PRIZE, 1),
                                        new AbstractMap.SimpleEntry<>(LotteryRank.SECOND_PRIZE, 1),
                                        new AbstractMap.SimpleEntry<>(LotteryRank.THIRD_PRIZE, 1),
                                        new AbstractMap.SimpleEntry<>(LotteryRank.FOURTH_PRIZE, 1),
                                        new AbstractMap.SimpleEntry<>(LotteryRank.FIFTH_PRIZE, 1)
                                ),
                                406311F
                        )


                )
        );
    }


}