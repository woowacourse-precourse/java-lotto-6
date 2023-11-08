package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(2, 3, 4, 5, 6, 7)),
            new Lotto(List.of(5, 6, 7, 8, 9, 10)),
            new Lotto(List.of(11, 12, 13, 14, 15, 16))
    );
    Winning winning = new Winning("1,2,3,4,5,6");
    Bonus bonus = new Bonus(winning, "7");
    Results result = Results.of(lottos, winning, bonus);

    @DisplayName("당첨 결과 문자열 생성")
    @Test
    void makeResultToStringTest() {
        assertThat(result.makeResultToString()).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개"
        );
    }

    @DisplayName("수익률 문자열 생성")
    @Test
    void makeProfitRateToStringTest() {
        result.makeResultToString();
        assertThat(result.makeProfitRateToString()).contains(
                "총 수익률은 50750000.0%입니다."
        );
    }
}
