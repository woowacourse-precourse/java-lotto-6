package lotto.util.io;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InputUtilsTest {

    @Test
    void 로또_구입_금액_null_입력_에러_처리() {
        try {
            InputUtils.validateInputMoney(null);
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 입력값이 없습니다.", e.getMessage());
        }
    }

    @Test
    void 로또_구입_금액_숫자_이외_에러_처리() {
        try {
            InputUtils.validateInputMoney("hello");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 숫자를 입력해야 합니다.", e.getMessage());
        }
    }

    @Test
    void 로또_구입_금액_1000_단위_아닐_시_에러_처리(){
        try {
            InputUtils.validateInputMoney("1001");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 1,000단위의 값을 입력해야 합니다.", e.getMessage());
        }
    }
}
