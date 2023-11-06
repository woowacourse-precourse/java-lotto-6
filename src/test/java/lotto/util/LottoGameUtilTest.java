package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoGameUtilTest {

    @Test
    @DisplayName("구입 금액 요청 포맷 검증 성공 케이스")
    void 구매_금액_요청_포맷_검증_성공() {
        assertThatCode(() -> LottoGameUtil.validPurchaseAmountFormat("1000"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구입 금액 요청 포맷 검증 실패 케이스")
    void 구매_금액_요청_포맷_검증_실패() {
        assertThatThrownBy(() -> LottoGameUtil.validPurchaseAmountFormat("1200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구매 금액 변환 성공 케이스")
    void 구매_금액_변환_성공() {
        assertThat(LottoGameUtil.convertPurchaseAmount("1000")).isEqualTo(1);
    }

    @Test
    @DisplayName("구매 금액 변환 실패 케이스")
    void 구매_금액_변환_실패() {
        assertThatThrownBy(() -> LottoGameUtil.convertPurchaseAmount("1200"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}