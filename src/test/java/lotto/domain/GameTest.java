package lotto.domain;

import lotto.controller.Prompt;
import lotto.enums.Ranking;
import lotto.view.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GameTest {
    private static final WinningLotto WINNING_LOTTO = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    private static final Money MONEY = new Money(8_000);
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
    private Message message;
    private Prompt prompt;
    private LottoMachine lottoMachine;
    private Game game;

    @BeforeEach
    void setUp() {
        message = mock(Message.class);
        prompt = mock(Prompt.class);
        lottoMachine = mock(LottoMachine.class);
        game = new Game(message, prompt, lottoMachine);
    }

    @Test
    void run() {
        when(prompt.promptMoney()).thenReturn(MONEY);
        when(lottoMachine.issueLottos(MONEY)).thenReturn(LOTTOS);
        when(prompt.promptWinningLotto()).thenReturn(WINNING_LOTTO);
        when(lottoMachine.rank(any(), any())).thenReturn(LOTTO_RESULT);

        assertThatCode(() -> game.run()).doesNotThrowAnyException();

        verify(prompt, times(1)).promptMoney();
        verify(lottoMachine, times(1)).issueLottos(MONEY);
        verify(prompt, times(1)).promptWinningLotto();
        verify(lottoMachine, times(1)).rank(any(), any());
    }
}