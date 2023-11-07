package lotto.global;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ErrorMessageTest {
    @Test
    @DisplayName("에러 메시지를 검증한다.")
    void testErrorMessage() {
        // given&when&then
        assertEquals("입력값은 자연수여야 합니다.", ErrorMessage.INVALID_NATURAL_NUMBER_ERROR.getMessage());
        assertEquals("유효하지 않는 로또 번호입니다.", ErrorMessage.INVALID_LOTTO_NUMBER_ERROR.getMessage());
        assertEquals("유효하지 않는 로또 번호 개수입니다.", ErrorMessage.INVALID_LOTTO_SIZE_ERROR.getMessage());
        assertEquals(LottoInformation.LOTTO_PRICE_UNIT + "원 단위로 입력해야 합니다.",
                ErrorMessage.INVALID_PRICE_UNIT_ERROR.getMessage());
        assertEquals("보너스 볼은 당첨 번호와 중복될 수 없습니다.", ErrorMessage.BONUS_BALL_INCLUDE_ERROR.getMessage());
        assertEquals("로또 번호가 중복됩니다.", ErrorMessage.NUMBER_DUPLICATED_ERROR.getMessage());
    }
}