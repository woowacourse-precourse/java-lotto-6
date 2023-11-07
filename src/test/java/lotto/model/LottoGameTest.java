package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private LottoGame lottoGame;
    private DrawResult drawResult;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(1000);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        lotto = new Lotto(numbers);
        drawResult = new DrawResult(lotto, 7);
    }


    @Test
    @DisplayName("로또 발행 테스트")
    void issuanceLotto() {
        assertEquals(1, lottoGame.issuanceLotto(1000).size());
        assertEquals(10, lottoGame.issuanceLotto(10000).size());
        assertEquals(100, lottoGame.issuanceLotto(100000).size());
    }

    @Test
    @DisplayName("구입 금액 음수 검증 테스트")
    void validateNegative() {
        assertThatThrownBy(() -> lottoGame.validateNegative(-1000)).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 음수를 입력할 수 없습니다. 1,000원 단위로 입력해 주세요.");
    }

    @Test
    @DisplayName("구입 금액 단위 검증 테스트")
    void validateUnit() {
        assertThatThrownBy(() -> lottoGame.validateUnit(1200)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000단위로 입력하세요");
        assertThatThrownBy(() -> lottoGame.validateUnit(500)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000단위로 입력하세요");
    }

    @Test
    @DisplayName("구입 금액 검증 테스트")
    void validate() {
        assertThatThrownBy(() -> lottoGame.validate(1500)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000단위로 입력하세요");
        assertThatThrownBy(() -> lottoGame.validate(-10000)).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR] 음수를 입력할 수 없습니다. 1,000원 단위로 입력해 주세요.");
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호 일치 카운트 테스트")
    void countMatch() {
        assertEquals(6, lottoGame.countMatch(lotto, drawResult));
    }

    @Test
    @DisplayName("당첨된 등수 카운트 업데이트 테스트")
    void updateMatchCount() {
        Map<String, Integer> matchResults = lottoGame.getMatchResults();
        assertEquals(0, matchResults.get("3개 일치"));
        lottoGame.updateMatchCount("3개 일치");
        assertEquals(1, matchResults.get("3개 일치"));
    }

    @Test
    @DisplayName("보너스 번호 카운트 테스트")
    void updateBonusCount() {
        assertEquals(0, lottoGame.getMatchResults().get("5개 일치, 보너스 볼 일치"));
        lottoGame.updateBonusCount(5, lotto, drawResult);
        assertEquals(1, lottoGame.getMatchResults().get("5개 일치, 보너스 볼 일치"));
    }

    @Test
    @DisplayName("당첨 매치 업데이트 테스트")
    void updateMatch() {
        assertEquals(0, lottoGame.getMatchResults().get("3개 일치"));
        assertEquals(0, lottoGame.getMatchResults().get("4개 일치"));
        assertEquals(0, lottoGame.getMatchResults().get("6개 일치"));
        lottoGame.updateMatch(3, lotto, drawResult);
        lottoGame.updateMatch(3, lotto, drawResult);
        lottoGame.updateMatch(4, lotto, drawResult);
        lottoGame.updateMatch(6, lotto, drawResult);
        assertEquals(2, lottoGame.getMatchResults().get("3개 일치"));
        assertEquals(1, lottoGame.getMatchResults().get("4개 일치"));
        assertEquals(1, lottoGame.getMatchResults().get("6개 일치"));
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculationRateOfReturn() {
        lottoGame.updateMatch(3, lotto, drawResult);
        lottoGame.calculationRateOfReturn();
        assertEquals(500.0, lottoGame.getRateOfReturn());
    }

    @Test
    void calculationResult() {
        lottoGame.calculationResult(drawResult);
        Map<String, Integer> matchResult = lottoGame.getMatchResults();
        for (String result : matchResult.keySet()) {
            if (matchResult.get(result) != 0) {
                assertTrue(lottoGame.getRateOfReturn() > 500.0);
            }
        }
    }

}