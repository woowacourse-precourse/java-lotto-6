package lotto.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoErrorTest {

    @Test
    void testErrorMessages() {
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", LottoError.NUMBER_OUT_OF_RANGE.toString());
        assertEquals("[ERROR] 로또 구매 금액은 1000원 단위의 양수여야 합니다.", LottoError.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND.toString());
        assertEquals("[ERROR] 숫자가 아닌 값이 입력되었습니다.", LottoError.INVALID_NUMBER.toString());
        assertEquals("[ERROR] 당첨 번호는 6개여야 합니다.", LottoError.INVALID_WINNING_NUMBER_COUNT.toString());
        assertEquals("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.", LottoError.DUPLICATE_WINNING_NUMBER.toString());
        assertEquals("[ERROR] 보너스 번호가 당첨 번호와 중복되었습니다.", LottoError.BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER.toString());
        assertEquals("[ERROR] 입력 값이 비어 있거나 null입니다.", LottoError.EMPTY_OR_NULL_INPUT.toString());
    }
}