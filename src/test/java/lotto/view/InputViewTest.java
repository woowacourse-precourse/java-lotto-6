package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.exception.InputExceptionMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends IOTest {

    private final InputView inputView = new InputView();

    @Test
    public void 금액_입력_성공() throws Exception {
        //given
        String input = "8000";
        systemIn(input);
        //when
        int totalPrice = inputView.receiveTotalPrice();
        //then
        assertThat(totalPrice).isEqualTo(8000);
    }

    @Test
    public void 금액_입력_반복() throws Exception {
        //given
        String input = "abc\n1001\n1000";
        systemIn(input);
        //when
        int totalPrice = inputView.receiveTotalPrice();
        //then
        assertThat(getOutput()).contains(InputExceptionMessage.INVALID_PRICE_TYPE.getMessage());
        assertThat(getOutput()).contains(InputExceptionMessage.INVALID_PRICE.getMessage());
        assertThat(totalPrice).isEqualTo(1000);
    }

    @DisplayName("정상적인 당첨번호 입력")
    @Test
    public void 당첨번호_입력_성공() throws Exception {
        //given
        String input = "1,2,3,4,5,6";
        systemIn(input);
        //when
        Lotto lotto = inputView.receiveLottoWinning();
        //then
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 당첨번호_입력_반복() throws Exception {
        //given
        String input = "123456\n1,2,3,4\n123,234,345,456,567,678\n1,2,3,4,5,5\n1,2,3,4,5,6";
        systemIn(input);
        //when
        Lotto lotto = inputView.receiveLottoWinning();
        //then
        assertThat(getOutput()).contains(InputExceptionMessage.INVALID_LOTTO_NUMBERS.getMessage());
        assertThat(getOutput()).contains(InputExceptionMessage.INVALID_LOTTO_DUPLICATED.getMessage());
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("정상적인 보너스 번호 입력")
    @Test
    public void 보너스번호_입력() throws Exception {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "7";
        systemIn(input);
        //when
        int bonusNumber = inputView.receiveBonusNumber(lotto);
        //then
        assertThat(bonusNumber).isEqualTo(7);
    }

    @DisplayName("보너스 번호 입력 시 문자, 45이상의 숫자, 로또 번호와 중복된 숫자, 정상적인 값 입력")
    @Test
    public void 보너스번호_입력_반복() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String input = "a\n55\n6\n7";
        systemIn(input);
        //when
        int bonusNumber = inputView.receiveBonusNumber(lotto);
        //then
        assertThat(getOutput()).contains(InputExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
        assertThat(getOutput()).contains(InputExceptionMessage.DUPLICATED_BONUS_NUMBER.getMessage());
        assertThat(bonusNumber).isEqualTo(7);
    }
}