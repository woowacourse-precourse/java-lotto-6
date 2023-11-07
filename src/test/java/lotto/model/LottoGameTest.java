package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(1000);
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
    void calculationResult() {
    }

    @Test
    void calculationRateOfReturn() {
    }

    @Test
    void updateMatch() {
    }

    @Test
    void updateBonusCount() {
    }

    @Test
    void updateMatchCount() {
    }

    @Test
    void countMatch() {
    }

    @Test
    void validate() {
    }
}