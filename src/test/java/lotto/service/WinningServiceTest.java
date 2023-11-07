package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.Lottos;
import lotto.model.WinningNumber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class WinningServiceTest {

    private WinningService winningService;
    private Lottos lottos;
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        winningService = new WinningService();
        lottos = new Lottos();
        lottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.addLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.addLotto(new Lotto(Arrays.asList(3, 4, 5, 6, 8, 9)));
        lottos.addLotto(new Lotto(Arrays.asList(9, 10, 11, 12, 13, 14)));
        winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6)
                                                .stream()
                                                .collect(Collectors.toSet()), 7);
    }

    @Test
    void testCheckWinningAllMatched() {
        Map<Lotto, LottoPrize> results = winningService.checkWinning(lottos, winningNumber);
        assertThat(LottoPrize.FIRST_PRIZE).isEqualTo(results.get(lottos.getLottos().get(0)));
    }

    @Test
    void testCheckWinningSomeMatched() {
        Map<Lotto, LottoPrize> results = winningService.checkWinning(lottos, winningNumber);
        assertThat(LottoPrize.SECOND_PRIZE).isEqualTo(results.get(lottos.getLottos().get(1)));
    }

    @Test
    void testCheckWinningNoneMatched() {
        Map<Lotto, LottoPrize> results = winningService.checkWinning(lottos, winningNumber);
        assertThat(results.get(lottos.getLottos().get(3))).isEqualTo(null);
    }
}
