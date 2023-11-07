package lotto.domain;

import lotto.enums.Ranking;
import lotto.utils.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class LottoMachineTest {
    private static final int LOTTO_PRICE = 1_000, BONUS_NUMBER = 7;
    private static final Lotto WINNING_LOTTO = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private static final Lottos LOTTOS = new Lottos(List.of(
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45))
    ));
    private static final LottoResult LOTTO_RESULT;

    static {
        Map<Ranking, Integer> rankingCounts = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> rankingCounts.put(key, 0));
        rankingCounts.put(Ranking.BLANK, 7);
        rankingCounts.put(Ranking.FIFTH, 1);
        LOTTO_RESULT = new LottoResult(rankingCounts);
    }

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void getLottoPrice() {
        assertThat(LottoMachine.getLottoPrice()).isEqualTo(LOTTO_PRICE);
    }

    @Test
    void issueLottos() {
        try (MockedStatic<RandomGenerator> randomGeneratorMockedStatic = mockStatic(RandomGenerator.class)) {
            Money money = mock(Money.class);
            when(money.getAmount()).thenReturn(8_000);

            when(RandomGenerator.generate())
                    .thenReturn(List.of(8, 21, 23, 41, 42, 43))
                    .thenReturn(List.of(3, 5, 11, 16, 32, 38))
                    .thenReturn(List.of(7, 11, 16, 35, 36, 44))
                    .thenReturn(List.of(1, 8, 11, 31, 41, 42))
                    .thenReturn(List.of(13, 14, 16, 38, 42, 45))
                    .thenReturn(List.of(7, 11, 30, 40, 42, 43))
                    .thenReturn(List.of(2, 13, 22, 32, 38, 45))
                    .thenReturn(List.of(1, 3, 5, 14, 22, 45));

            Lottos lottos = lottoMachine.issueLottos(money);

            Iterator<Lotto> lottosIterator = lottos.iterator();
            Iterator<Lotto> LOTTOSIterator = LOTTOS.iterator();
            while (lottosIterator.hasNext() && LOTTOSIterator.hasNext()) {
                assertThat(lottosIterator.next().getNumbers())
                        .isEqualTo(LOTTOSIterator.next().getNumbers());
            }

            verify(money, times(1)).getAmount();
            randomGeneratorMockedStatic.verify(RandomGenerator::generate, times(8));
        }
    }

    @Test
    void rank() {
        WinningLotto winningLotto = mock(WinningLotto.class);
        Player player = mock(Player.class);

        when(winningLotto.getLotto()).thenReturn(WINNING_LOTTO);
        when(winningLotto.getBonusNumber()).thenReturn(BONUS_NUMBER);
        when(player.getLottos()).thenReturn(LOTTOS);

        LottoResult lottoResult = lottoMachine.rank(player, winningLotto);
        assertThat(lottoResult.getRankingCounts()).isEqualTo(LOTTO_RESULT.getRankingCounts());
        verify(winningLotto, times(1)).getLotto();
        verify(winningLotto, times(1)).getBonusNumber();
        verify(player, times(1)).getLottos();
    }
}