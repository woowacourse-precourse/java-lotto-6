package lotto.v2.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

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

    @Test
    @DisplayName("잘못된 금액 입력시 예외를 발생시키는지 테스트")
    void testParseMoney_InvalidInput() {
        // given
        String invalidInput = "invalid input";

        Assertions.assertThatThrownBy(() -> {
                    // when
                    Method parseMoney = LottoViewV2.class.getDeclaredMethod("parseMoney", String.class);
                    parseMoney.setAccessible(true);
                    parseMoney.invoke(lottoView, invalidInput);
                })
                // then
                .isInstanceOf(InvocationTargetException.class)
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .hasCause(new IllegalArgumentException("[ERROR] 구입 금액으로 숫자를 입력해야 합니다."));
    }

    @Test
    @DisplayName("정상적인 당첨 번호 입력을 처리하는지 테스트")
    void testParseWinningNumbers_ValidInput() throws Exception {
        // given
        String validInput = "1, 2, 3, 4, 5, 6";
        Method parseWinningNumbers = LottoViewV2.class.getDeclaredMethod("parseWinningNumbers", String.class);
        parseWinningNumbers.setAccessible(true);

        // when
        List<Integer> result = (List<Integer>) parseWinningNumbers.invoke(lottoView, validInput);

        // then
        Assertions.assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

}