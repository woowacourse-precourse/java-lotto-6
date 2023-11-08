package lotto.domain.util;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.util.LottoParser.*;
import static lotto.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoParserTest {

    @DisplayName("입력 금액 로또 개수 변환 성공 테스트")
    @ParameterizedTest
    @CsvSource({"1000, 1000", "8000, 8000"})
    void parseMoneyToLottoCountSuccessTest(String input, int expected) {
        int count = LottoParser.parseMoney(input);
        assertThat(count).isEqualTo(expected);
    }

    @DisplayName("입력 금액 금액 부족 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "0", "-1000" })
    void parseMoneyToLottoCountFailTest1(String input) {
        assertThatThrownBy(()->parseMoney(input))
                .hasMessageContaining(LOTTO_MONEY_INPUT_SMALL_ERROR.getMessage());
    }

    @DisplayName("입력 금액 금액 나누어 떨어지지 않을때 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "4124", "81231" })
    void parseMoneyToLottoCountFailTest2(String input) {
        assertThatThrownBy(()->parseMoney(input))
                .hasMessageContaining(LOTTO_MONEY_INPUT_ERROR.getMessage());
    }

    @DisplayName("당첨 번호 입력 변환 성공 테스트")
    @Test
    void parseWinningNumbersSuccessTest() {
        String inputWinningNumbers = "1,2,3,4,5,45";
        List<Integer> winningNumbers = parseWinningNumbers(inputWinningNumbers);
        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 45));
    }

    @DisplayName("당첨 번호 입력 개수 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,6,7", "1,2,3,4,5" })
    void parseWinningNumbersFailTest1(String input) {
        assertThatThrownBy(()->parseWinningNumbers(input))
                .hasMessageContaining(LOTTO_NUMBER_COUNT_ERROR.getMessage());
    }

    @DisplayName("당첨 번호 입력 형식 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,6,", "1,2,3,4,5.12" })
    void parseWinningNumbersFailTest2(String input) {
        assertThatThrownBy(()->parseWinningNumbers(input))
                .hasMessageContaining(LOTTO_NUMBER_FORMAT_ERROR.getMessage());
    }

    @DisplayName("당첨 번호 중복 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,5", "1,1,1,1,1,1" })
    void parseWinningNumbersFailTest3(String input) {
        assertThatThrownBy(()->parseWinningNumbers(input))
                .hasMessageContaining(LOTTO_NUMBER_DUPLICATED_ERROR.getMessage());
    }

    @DisplayName("당첨 번호 범위 초과 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,46", "0,1,2,3,4,5" })
    void parseWinningNumbersFailTest4(String input) {
        assertThatThrownBy(()->parseWinningNumbers(input))
                .hasMessageContaining(LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호 입력 성공 테스트")
    @ParameterizedTest
    @CsvSource({"1, 1", "8, 8", "45, 45"})
    void parseBonusNumberSuccessTest(String input, int expected) {
        assertThat(parseBonusNumber(input)).isEqualTo(expected);
    }

    @DisplayName("보너스 번호 입력 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46", "3123"})
    void parseBonusNumberFailTest(String input) {
        assertThatThrownBy(()->parseBonusNumber(input))
                .hasMessageContaining(LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }
}
// Nested 로 계층 나누기
