package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningAnalyzerTest {
    @Test
    @DisplayName("구매 로또와 당첨 로또를 비교한 결과를 반환한다.")
    void test() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        AnswerLottos answerLottos = new AnswerLottos(new Lotto(List.of(1, 2, 3, 4, 8, 9)), new BonusBall(7));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto));

        WinningAnalyzer winningAnalyzer = new WinningAnalyzer(answerLottos);

        // when
        Map<Prize, Integer> compareResults = winningAnalyzer.compare(lottoTicket);

        // then
        assertAll(
                () -> assertEquals(0, compareResults.get(Prize.NONE)),
                () -> assertEquals(0, compareResults.get(Prize.FIRST)),
                () -> assertEquals(0, compareResults.get(Prize.SECOND)),
                () -> assertEquals(0, compareResults.get(Prize.THIRD)),
                () -> assertEquals(1, compareResults.get(Prize.FOURTH)),
                () -> assertEquals(0, compareResults.get(Prize.FIFTH))
        );
    }
}
