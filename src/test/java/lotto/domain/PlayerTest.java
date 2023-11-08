package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayerTest {
    private Player player;
    private final LottoService lottoService = new LottoService();

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
    void 게임을_시작할때_입력했던_구매_가격을_기준으로_총_수익률을_구한다(Lotto winngingLotto, int bonusNumber, double expectResult) {
        //given
        LotteryNumbers lotteryNumbers = LotteryNumbers.of(winngingLotto, bonusNumber);
        //when
        lottoService.checkWinningResult(player, lotteryNumbers);
        double result = player.findRateOfRevenue();
        //then
        assertThat(result).isEqualTo(expectResult);

    }

    private static Stream<Arguments> 게임을_시작할때_입력했던_구매_가격을_기준으로_총_수익률을_구한다() {
        /*
         *   1등 1번
         * */
        ArrayList<Integer> winningNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        /*
         *   5등 2번
         * */
        ArrayList<Integer> winningNUmbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        /*
         *   2등 1번
         * */
        ArrayList<Integer> winningNUmbers3 = new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 45));
        Lotto winningLotto1 = new Lotto(winningNumbers1);
        Lotto winningLotto2 = new Lotto(winningNUmbers2);
        Lotto winningLotto3 = new Lotto(winningNUmbers3);
        return Stream.of(
                Arguments.of(winningLotto1, 45, 200000000),
                Arguments.of(winningLotto2, 45, 1000),
                Arguments.of(winningLotto3, 18, 3000000)
        );
    }
}
