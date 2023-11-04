package lotto.common;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {
    private LottoValidator lottoValidator = new LottoValidator();

    @Test
    void 로또_구입_성공() {
        String input = "1000";
        int result = 1000;

        assertThat(lottoValidator.checkPurchaseAmount(input))
                .isEqualTo(result);
    }

    @Test
    void 로또_구입_실패_0원() {
        String input = "0";

        assertThatThrownBy(() -> lottoValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_실패_음수() {
        String input = "-1000";

        assertThatThrownBy(() -> lottoValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_실패_무입력() {
        String input = "";

        assertThatThrownBy(() -> lottoValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_구입_실패_입력범위초과() {
        String input = String.format("%f", Double.MAX_VALUE);

        assertThatThrownBy(() -> lottoValidator.checkPurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_성공() {
        String input = "1,2,3,4,5,6";
        List<Integer> result = List.of(1,2,3,4,5,6);

        assertThat(lottoValidator.checkLottoNumber(input))
                .containsAll(result);
    }

    @Test
    void 로또_번호_입력_실패_개수부족() {
        String input = "1,2,3,4,5";

        assertThatThrownBy(() -> lottoValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_개수초과() {
        String input = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> lottoValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_잘못된구분점() {
        String input = "1,2,3,4,5,,,45";

        assertThatThrownBy(() -> lottoValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_숫자아님() {
        String input = "1,2,3,4,5,yujin";

        assertThatThrownBy(() -> lottoValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_범위미만() {
        String input = "1,2,3,4,5,0";

        assertThatThrownBy(() -> lottoValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_입력_실패_범위초과() {
        String input = "1,2,3,4,5,46";

        assertThatThrownBy(() -> lottoValidator.checkLottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}