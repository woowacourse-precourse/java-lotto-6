package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    @DisplayName("숫자와 콤마 구분자로 이루어진 로또 번호를 입력하면 에러가 발생하지 않는다.")
    @Test
    void lottoNumbersParseSuccessTest() {
        InputParser inputParser = new InputParser();
        String numbers = "1,2,3,4,5,6";
        assertThatCode(() -> inputParser.parseLottoNumbers(numbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("숫자와 콤마 구분자로 이루어지지 않은 로또 번호를 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a,s,d,f", "1, 2, 3, 4", "ㄱ,ㄴ,ㄷ,ㄹ", " ", ""})
    void lottoNumbersParseFailTest(String inputNumbers) {
        InputParser inputParser = new InputParser();
        assertThatCode(() -> inputParser.parseLottoNumbers(inputNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자로 변환 가능한 정상적인 로또 구입금액을 입력하면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "1000000"})
    void parsePurchaseAmountSuccessTest(String purchaseAmount) {
        InputParser inputParser = new InputParser();
        assertThatCode(() -> inputParser.parsePurchaseAmount(purchaseAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("숫자로 변환 불가능한 로또 구입금액을 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"asdf", "가나다", "123_456", "1등당첨될만큼주세요!"})
    void parsePurchaseAmountFailTest(String purchaseAmount) {
        InputParser inputParser = new InputParser();
        assertThatCode(() -> inputParser.parsePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("구입금액은 숫자만 입력 가능합니다. 입력값 : %s", purchaseAmount));
    }
}
