package lotto;


import lotto.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AnalysisResultTest {
    User user;

    @BeforeEach
    void setUp() {
        user = User.of(List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 6))
                )
        );
    }

    @DisplayName("로또 리스트가 주어졌을 때, 통계 객체가 정상적으로 생성되는지 확인한다.")
    @Test
    void givenLottoList_whenCreateAnalysis_thenSuccess() {
        //given && When
        AnalysisResult analysisResult = AnalysisResult.caculate(user.checkLottosResult(WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7)));
        //Then
        assertThat(analysisResult).isNotNull();
    }


    @DisplayName("로또들의 등수와 1등 번호가 주어졌을 때, 등수들에 대한 통계분석이 진행된다.")
    @Test
    void givenLottoList_whenAnalyze_thenSuccess() {
        //given
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 7);
        AnalysisResult analysisResult = AnalysisResult.caculate(user.checkLottosResult(winningNumbers));
        //When
        Map<LottoResult, Integer> rankingcounter = analysisResult.getRankingcounter();
        //Then
        assertThat(rankingcounter.get(LottoResult.FIRST)).isEqualTo(3);
    }
}
