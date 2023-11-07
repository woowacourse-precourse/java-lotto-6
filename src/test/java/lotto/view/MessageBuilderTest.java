package lotto.view;

import lotto.domain.*;
import lotto.enums.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageBuilderTest {
    private static final int SCALE = 1;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private Player player;
    private LottoResult lottoResult;
    private MessageBuilder messageBuilder;

    @BeforeEach
    void setUp() {
        player = mock(Player.class);
        lottoResult = mock(LottoResult.class);
        messageBuilder = new MessageBuilder();
    }

    @Test
    void build_로또발행() {
        String expected = "8개를 구매했습니다." + System.lineSeparator()
                + "[8, 21, 23, 41, 42, 43]" + System.lineSeparator()
                + "[3, 5, 11, 16, 32, 38]" + System.lineSeparator()
                + "[7, 11, 16, 35, 36, 44]" + System.lineSeparator()
                + "[1, 8, 11, 31, 41, 42]" + System.lineSeparator()
                + "[13, 14, 16, 38, 42, 45]" + System.lineSeparator()
                + "[7, 11, 30, 40, 42, 43]" + System.lineSeparator()
                + "[2, 13, 22, 32, 38, 45]" + System.lineSeparator()
                + "[1, 3, 5, 14, 22, 45]" + System.lineSeparator();

        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));

        List<Lotto> lottoList = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8);
        Lottos lottos = new Lottos(lottoList);

        when(player.getLottos()).thenReturn(lottos);

        assertThat(messageBuilder.build(player)).isEqualTo(expected);
        verify(player, times(1)).getLottos();
    }

    @Test
    void build_당첨통계() {
        String expected = "당첨 통계" + System.lineSeparator()
                + "---" + System.lineSeparator()
                + "3개 일치 (5,000원) - 1개" + System.lineSeparator()
                + "4개 일치 (50,000원) - 0개" + System.lineSeparator()
                + "5개 일치 (1,500,000원) - 0개" + System.lineSeparator()
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개" + System.lineSeparator()
                + "6개 일치 (2,000,000,000원) - 0개" + System.lineSeparator()
                + "총 수익률은 62.5%입니다.";

        Money money = new Money(8000);

        Map<Ranking, Integer> rankingCounts = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(key -> rankingCounts.put(key, 0));
        rankingCounts.put(Ranking.FIFTH, 1);

        when(player.getMoney()).thenReturn(money);
        when(lottoResult.getRankingCounts()).thenReturn(rankingCounts);
        when(lottoResult.calculatePrizeRate(money, SCALE, ROUNDING_MODE)).thenReturn(BigDecimal.valueOf(62.5));

        assertThat(messageBuilder.build(player, lottoResult)).isEqualTo(expected);
        verify(lottoResult, times(1)).getRankingCounts();
        verify(player, times(1)).getMoney();
        verify(lottoResult, times(1)).calculatePrizeRate(money, SCALE, ROUNDING_MODE);
    }
}