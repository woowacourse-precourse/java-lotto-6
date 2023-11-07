package lotto.domain.service;

import static lotto.domain.StaticsEnum.MATCHED_FIVE;
import static lotto.domain.StaticsEnum.MATCHED_FIVE_WITH_BONUS;
import static lotto.domain.StaticsEnum.MATCHED_FOUR;
import static lotto.domain.StaticsEnum.MATCHED_SIX;
import static lotto.domain.StaticsEnum.MATCHED_THREE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.StaticsEnum;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.ResultTable;
import lotto.domain.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    private LottoService lottoService;
    private WinningLotto winningLotto;
    private BonusNumber bonusNumber;
    private Map<StaticsEnum, ResultTable> statistics;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        bonusNumber = new BonusNumber(10);
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), bonusNumber);
        statistics = new HashMap<lotto.domain.StaticsEnum, ResultTable>();
        statistics.put(MATCHED_THREE, new ResultTable(MATCHED_THREE));
        statistics.put(MATCHED_FOUR, new ResultTable(MATCHED_FOUR));
        statistics.put(MATCHED_FIVE, new ResultTable(MATCHED_FIVE));
        statistics.put(MATCHED_FIVE_WITH_BONUS, new ResultTable(MATCHED_FIVE_WITH_BONUS));
        statistics.put(MATCHED_SIX, new ResultTable(MATCHED_SIX));
    }

    @DisplayName("로또를 구매한다.")
    @ParameterizedTest(name = "로또 {0}개를 구매한다.")
    @ValueSource(ints = {1, 10, 3, 4, 6})
    void buyLotto(int lottoCount) {
        // when
        List<Lotto> lottoList = lottoService.makeLottoList(lottoCount);

        // then
        assertEquals(lottoCount, lottoList.size());
    }

    @DisplayName("당첨번호와 로또를 비교하여 결과를 생성한다.")
    @Test
    void createResult() {
        // given
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 14, 25, 36)),
                new Lotto(Arrays.asList(4, 5, 6, 14, 25, 36)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 25, 36)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 36)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))
        );

        // when
        lottoService.updateWinningStatistics(lottoList, winningLotto, statistics);

        // then
        assertThat(statistics.get(MATCHED_THREE).getCount()).isEqualTo(2);
        assertThat(statistics.get(MATCHED_FOUR).getCount()).isEqualTo(1);
        assertThat(statistics.get(MATCHED_FIVE).getCount()).isEqualTo(1);
        assertThat(statistics.get(MATCHED_FIVE_WITH_BONUS).getCount()).isEqualTo(1);
        assertThat(statistics.get(MATCHED_SIX).getCount()).isEqualTo(1);
    }
}