package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.LotteryNumbers;
import lotto.domain.LotteryResult;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();
    private Player player;

    @BeforeEach
    void setUp() {
        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12));
        ArrayList<Integer> numbers3 = new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18));
        Lotto lotto1 = new Lotto(numbers1);
        Lotto lotto2 = new Lotto(numbers2);
        Lotto lotto3 = new Lotto(numbers3);
        List<Lotto> lottos = new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3));
        player = Player.of(PurchasePrice.from(1000), lottos);
    }

    @ParameterizedTest
    @MethodSource
    void 사용자에게_지정되었던_로또와_당첨_번호_보너스_번호를_비교한다(Lotto winngingLotto, int bonusNumber,
                                            LotteryResult expectResult, int expectCount) {
        //given
        LotteryNumbers lotteryNumbers = LotteryNumbers.of(winngingLotto, bonusNumber);
        //when
        lottoService.checkWinningResult(player, lotteryNumbers);
        Map<LotteryResult, Integer> lotteryResults = player.getLotteryResults();
        Integer resultCount = lotteryResults.get(expectResult);
        //then
        assertThat(resultCount).isEqualTo(expectCount);
    }

    private static Stream<Arguments> 사용자에게_지정되었던_로또와_당첨_번호_보너스_번호를_비교한다() {
        ArrayList<Integer> winningNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ArrayList<Integer> winningNUmbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        ArrayList<Integer> winningNUmbers3 = new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 45));
        Lotto winningLotto1 = new Lotto(winningNumbers1);
        Lotto winningLotto2 = new Lotto(winningNUmbers2);
        Lotto winningLotto3 = new Lotto(winningNUmbers3);
        return Stream.of(
                Arguments.of(winningLotto1, 45, LotteryResult.FIRST, 1),
                Arguments.of(winningLotto2, 45, LotteryResult.FIFTH, 2),
                Arguments.of(winningLotto3, 18, LotteryResult.SECOND, 1)
        );
    }

}
