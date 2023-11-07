package lotto.v2.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class LottoViewV2Test {
    private LottoViewV2 lottoView;

    @BeforeEach
    void setUp() {
        lottoView = new LottoViewV2();
    }

    @Test
    @DisplayName("정상적인 금액 입력을 처리하는지 테스트")
    void testParseMoney_ValidInput() throws Exception {
        // given
        String validInput = "1000";
        Method parseMoney = LottoViewV2.class.getDeclaredMethod("parseMoney", String.class);
        parseMoney.setAccessible(true);

        // when
        int result = (int) parseMoney.invoke(lottoView, validInput);

        // then
        Assertions.assertThat(result).isEqualTo(1000);
    }

}