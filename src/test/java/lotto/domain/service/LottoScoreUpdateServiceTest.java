package lotto.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;
import lotto.domain.util.referee.ILottoReferee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LottoScoreUpdateServiceTest {
    private LottoScoreUpdateService lottoScoreUpdateService;

    @Mock
    private WinningLotto mockWinningLotto;

    @Mock
    private ILottoReferee mockLottoReferee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lottoScoreUpdateService = new LottoScoreUpdateService(mockLottoReferee);
    }

    @DisplayName("1등과 2등이 결과를 리턴한다.")
    @Test
    void updateScoresTest() {
        // given
        Lotto mockLottoFirst = mock(Lotto.class);
        Lotto mockLottoSecond = mock(Lotto.class);

        when(mockLottoReferee.determineRank(mockLottoFirst, mockWinningLotto)).thenReturn(ScoreConfig.FIRST);
        when(mockLottoReferee.determineRank(mockLottoSecond, mockWinningLotto)).thenReturn(ScoreConfig.SECOND);

        List<Lotto> lottos = Arrays.asList(mockLottoFirst, mockLottoSecond);

        // when
        List<ScoreConfig> scores = lottoScoreUpdateService.update(lottos, mockWinningLotto);

        // then
        assertThat(scores).containsExactly(ScoreConfig.FIRST, ScoreConfig.SECOND);
    }
}