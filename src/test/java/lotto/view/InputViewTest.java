package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import lotto.message.InputExceptionMessage;
import lotto.message.LottoExceptionMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

    private final InputView inputView = new InputView();

    void setInputValues(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void 금액_입력_성공() throws Exception{
        //given
        String input = "8000";
        //when
        setInputValues(input);
        int totalPrice = inputView.receiveTotalPrice();
        //then
        assertThat(totalPrice).isEqualTo(8000);
    }

    @Test
    public void 금액_입력_반복() throws Exception{
        //given
        String input = "abc\n1001\n1000";
        //when
        setInputValues(input);
        int totalPrice = inputView.receiveTotalPrice();
        //then
        assertThat(output()).contains(InputExceptionMessage.INVALID_PRICE_TYPE.getMessage());
        assertThat(output()).contains(InputExceptionMessage.INVALID_PRICE.getMessage());
        assertThat(totalPrice).isEqualTo(1000);
    }

    @Test
    public void 당첨번호_입력_성공() throws Exception{
        //given
        String input = "1,2,3,4,5,6";
        //when
        setInputValues(input);
        Lotto lotto = inputView.receiveLottoWinning();
        //then
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    public void 당첨번호_입력_반복() throws Exception{
        //given
        String input = "123456\n1,2,3,4\n123,234,345,456,567,678\n1,2,3,4,5,5\n1,2,3,4,5,6";
        //when
        setInputValues(input);
        Lotto lotto = inputView.receiveLottoWinning();
        //then
        assertThat(output()).contains(InputExceptionMessage.INVALID_LOTTO_NUMBERS.getMessage());
        assertThat(output()).contains(InputExceptionMessage.INVALID_LOTTO_TYPE.getMessage());
        assertThat(output()).contains(InputExceptionMessage.INVALID_LOTTO_DUPLICATED.getMessage());
        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Override
    protected void runMain() {

    }
}