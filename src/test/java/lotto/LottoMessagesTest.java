package lotto;

import lotto.messages.ErrorMessages;
import lotto.messages.LottoInputMessages;
import lotto.messages.LottoResultMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMessagesTest {

    public static class TestHelper {
        public static void assertMessageEquals(LottoResultMessages message, Object expectedValue, String expectedMessage) {
            String actualMessage = String.format(message.getMessage(), expectedValue);
            assertThat(actualMessage).isEqualTo(expectedMessage);
        }
    }

    @Test
    @DisplayName("입력 메시지 테스트")
    void testGetLottoInputMessage() {
        assertThat(LottoInputMessages.INPUT_USER_LOTTO_PURCHASE.getMessage()).isEqualTo("구입금액을 입력해 주세요.");
        assertThat(LottoInputMessages.INPUT_USER_WINNING_NUMBERS.getMessage()).isEqualTo("당첨 번호를 입력해 주세요.");
        assertThat(LottoInputMessages.INPUT_USER_BONUS_NUMBER_MESSAGE.getMessage()).isEqualTo("보너스 번호를 입력해 주세요.");
    }

    @Test
    @DisplayName("결과 메시지 테스트")
    void testGetLottoResultMessage() {
        assertThat(LottoResultMessages.RESULT_MESSAGE_HEADER.getMessage()).isEqualTo("당첨 통계");
        assertThat(LottoResultMessages.RESULT_MESSAGE_SEPARATOR.getMessage()).isEqualTo("---");

        TestHelper.assertMessageEquals(LottoResultMessages.RESULT_MESSAGE_3_MATCH, 1, "3개 일치 (5,000원) - 1개");
        TestHelper.assertMessageEquals(LottoResultMessages.RESULT_MESSAGE_4_MATCH, 0, "4개 일치 (50,000원) - 0개");
        TestHelper.assertMessageEquals(LottoResultMessages.RESULT_MESSAGE_5_MATCH, 1, "5개 일치 (1,500,000원) - 1개");
        TestHelper.assertMessageEquals(LottoResultMessages.RESULT_MESSAGE_5_BONUS_MATCH, 0, "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        TestHelper.assertMessageEquals(LottoResultMessages.RESULT_MESSAGE_6_MATCH, 1, "6개 일치 (2,000,000,000원) - 1개");
        TestHelper.assertMessageEquals(LottoResultMessages.RESULT_MESSAGE_TOTAL_INCOME, 62.5, "총 수익률은 62.5%입니다.");
    }

    @Test
    @DisplayName("에러 메시지 테스트")
    void testGetErrorMessage() {
        assertThat(ErrorMessages.LOTTO_PURCHASE_FORMAT_ERROR.getMessage()).isEqualTo("[ERROR] 1,000원 단위로 떨어지는 입력 해야 합니다. 다시 입력해 주세요.");
        assertThat(ErrorMessages.LOTTO_PURCHASE_MIN_ERROR.getMessage()).isEqualTo("[ERROR] 1,000원 이상 입력해야 합니다. 다시 입력해 주세요.");
        assertThat(ErrorMessages.WINNING_NUMBERS_COUNT_ERROR.getMessage()).isEqualTo("[ERROR] 6개의 숫자가 입력되어야 합니다. 다시 입력해 주세요.");
        assertThat(ErrorMessages.NUMBERS_OUT_OF_RANGE.getMessage()).isEqualTo("[ERROR] 1 - 45 사이의 수만 입력해야 합니다. 다시 입력해 주세요.");
        assertThat(ErrorMessages.NON_NUMERIC_INPUT.getMessage()).isEqualTo("[ERROR] 숫자 이외의 메시지가 포함되어 있습니다. 다시 입력해 주세요.");
        assertThat(ErrorMessages.DUPLICATE_VALUE_FOUND.getMessage()).isEqualTo("[ERROR] 중복된 값이 있습니다. 다시 입력해 주세요.");
    }
}