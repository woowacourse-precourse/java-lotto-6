package lotto.v3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EnumMap;
import java.util.Map;

import lotto.v3.model.LottoRank;

class LottoResultViewTest {

    @Test
    @DisplayName("주어진 매치 카운트가 있을 때, displayResults가 호출되면, 올바른 통계를 출력한다")
    void givenMatchCounts_whenDisplayResultsIsCalled_thenItPrintsCorrectStatistics() {
        // Given
        Map<LottoRank, Integer> matchCounts = new EnumMap<>(LottoRank.class);
        matchCounts.put(LottoRank.FIRST, 0);
        matchCounts.put(LottoRank.SECOND, 0);
        matchCounts.put(LottoRank.THIRD, 0);
        matchCounts.put(LottoRank.FOURTH, 0);
        matchCounts.put(LottoRank.FIFTH, 1);

        LottoResultView lottoResultView = new LottoResultView();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        lottoResultView.displayResults(matchCounts);

        // Then
        String expectedOutput =
                "당첨 통계\n" +
                        "---\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "3개 일치 (5,000원) - 1개\n";

        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        // Restore system output
        System.setOut(System.out);
    }
}

