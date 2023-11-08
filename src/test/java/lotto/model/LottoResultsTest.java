package lotto.model;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoResults;
import lotto.model.lotto.LottoWinRequirements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultsTest {
    private LottoResults lottoResults;
    private PaperBag paperBag;

    @BeforeEach
    void setUp() {
        LottoWinRequirements requirements = LottoWinRequirements.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                7
        );
        lottoResults = LottoResults.of(requirements);
        paperBag = PaperBag.of(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치, 2000000000원 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개-보너스볼 일치, 30000000원 당첨
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)) // 4개 일치 50000원 당첨
        ));
    }

    @DisplayName("로또 결과를 계산할 수 있다.")
    @Test
    void calculateResult() {
        lottoResults.calculateResult(paperBag);
        assertThat(lottoResults.getTotalWinAmount()).isEqualTo(2030050000);
    }

    @DisplayName("로또 결과를 문자열로 변환할 수 있다.")
    @Test
    void resultToString() {
        lottoResults.calculateResult(paperBag);
        String resultString = lottoResults.resultToString();

        // Check if the result string is in the expected format
        assertThat(resultString).isEqualTo(
                "3개 일치 (5,000원) - 0개\n" +
                        "4개 일치 (50,000원) - 1개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                        "6개 일치 (2,000,000,000원) - 1개\n"
        );
    }

}
