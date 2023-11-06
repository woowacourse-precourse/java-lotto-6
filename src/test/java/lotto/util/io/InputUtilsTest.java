package lotto.util.io;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
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
    void 로또_구입_금액_숫자_이외_입력_에러_처리() {
        try {
            InputUtils.validateInputMoney("hello");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 숫자를 입력해야 합니다.", e.getMessage());
        }
    }

    @Test
    void 로또_구입_금액_1000_단위_입력_아닐_시_에러_처리(){
        try {
            InputUtils.validateInputMoney("1001");
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 1,000단위의 값을 입력해야 합니다.", e.getMessage());
        }
    }

    @Test
    void 당첨_번호_모두_숫자_입력_아닐_시_에러_처리() {
        try {
            InputUtils.validateInputWinningNumbers(List.of("1", "e", "3", "4", "5", "6"));
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 당첨 번호 모두 숫자를 입력해야 합니다.", e.getMessage());
        }
    }

    @Test
    void 당첨_번호_모두_1부터_45_사이_숫자_입력_아닐_시_에러_처리() {
        try {
            InputUtils.validateInputWinningNumbers(List.of("1", "2", "3", "4", "5", "600"));
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.", e.getMessage());
        }
    }

    @Test
    void 당첨_번호_6개_입력_아닐_시_에러_처리() {
        try {
            InputUtils.validateInputWinningNumbers(List.of("1", "2", "3", "4", "5"));
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 당첨 번호는 6개이어야 합니다.", e.getMessage());
        }
    }

    @Test
    void 당첨_번호_중복된_숫자_입력_시_예외_처리() {
        try {
            InputUtils.validateInputWinningNumbers(List.of("1", "2", "3", "4", "5", "5"));
            fail("테스트에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            assertEquals("[ERROR] 당첨 번호는 중복된 숫자가 없어야 합니다.", e.getMessage());
        }
    }
}
