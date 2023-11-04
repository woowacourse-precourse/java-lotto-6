package lotto.view;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @Test
    void 로또_구입_성공() {
        String input = "1000";
        int result = 1000;

        assertThat(inputValidator.checkPurchaseAmount(input))
                .isEqualTo(result);
    }

    @Test
    void 로또_구입_실패_0원() {
        String input = "0";

        assertThatThrownBy(() -> inputValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_실패_음수() {
        String input = "-1000";

        assertThatThrownBy(() -> inputValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_실패_무입력() {
        String input = "";

        assertThatThrownBy(() -> inputValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_실패_입력범위초과() {
        String input = String.format("%f", Double.MAX_VALUE);

        assertThatThrownBy(() -> inputValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_성공() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = List.of(1,2,3,4,5,6);

        assertThat(inputValidator.checkLottoNumber(input))
                .containsAll(result);
    }

    @Test
    void 로또_번호_입력_실패_개수부족() {
        String input = "1,2,3,4,5";

        assertThatThrownBy(() -> inputValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_개수초과() {
        String input = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> inputValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_잘못된구분점() {
        String input = "1,2,3,4,5,,,45";

        assertThatThrownBy(() -> inputValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_숫자아님() {
        String input = "1,2,3,4,5,yujin";

        assertThatThrownBy(() -> inputValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_범위미만() {
        String input = "1,2,3,4,5,0";

        assertThatThrownBy(() -> inputValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_범위초과() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> inputValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}