package lotto.view;

import static lotto.constant.LottoConstants.LOTTO_NUMBER_FORMAT;
import static lotto.message.InputErrorMessage.INVALID_INPUT_FORMAT;
import static lotto.message.InputErrorMessage.INVALID_INPUT_LOTTO_NUMBERS_COUNT;
import static lotto.message.InputErrorMessage.INVALID_INPUT_LOTTO_RANGE;
import static lotto.message.InputErrorMessage.INVALID_INPUT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.TreeSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest{
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void after() {
        Console.close();
    }

    protected final String output() {
        return captor.toString().trim();
    }
    @DisplayName("구입 금액에서 숫자가 아닌 다른 값을 입력하면 예외를 발생시킨다.")
    @Test
    void requestLottoPurchaseAmountByNotNumber() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "test";
            systemIn(inputValue);
            inputView.requestLottoPurchaseAmount();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format(INVALID_INPUT_FORMAT, LOTTO_NUMBER_FORMAT));
    }

    @DisplayName("구입 금액에서 1,000 단위가 아닌 값을 입력하면 예외를 발생시킨다.")
    @Test
    void requestLottoPurchaseAmountByNotInvalidUnit() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "1234123141";
            systemIn(inputValue);
            inputView.requestLottoPurchaseAmount();;
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(INVALID_INPUT_UNIT);
    }
    
    @DisplayName("로또 번호를 6개를 입력하지 않으면 예외를 발생시킨다.")
    @Test
    void requestLottoNumbersByNotEnoughSize() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "1,2,3,4,5";
            systemIn(inputValue);
            inputView.requestLottoNumber();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(INVALID_INPUT_LOTTO_NUMBERS_COUNT);
    }

    @DisplayName("로또 번호는 숫자와 , 외 문자를 입력하면 예외를 발생시킨다.")
    @Test
    void requestLottoNumbersByInvalidFormat() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "1,ad,dfd,4,5,6";
            systemIn(inputValue);
            inputView.requestLottoNumber();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format(INVALID_INPUT_FORMAT, LOTTO_NUMBER_FORMAT));
    }

    @DisplayName("로또 번호는 45 이하 값을 입력해야 된다.")
    @Test
    void requestLottoNumbersByOverMax() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "1,2,3,4,5,46";
            systemIn(inputValue);
            inputView.requestLottoNumber();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(INVALID_INPUT_LOTTO_RANGE);
    }

    @DisplayName("로또 번호는 1이상 값을 입력해야 된다.")
    @Test
    void requestLottoNumbersByUnderMin() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "0,2,3,4,5,45";
            systemIn(inputValue);
            inputView.requestLottoNumber();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(INVALID_INPUT_LOTTO_RANGE);
    }

    @DisplayName("로또 번호는 6개 값을 입력한다.")
    @Test
    void requestLottoNumbers() {
        InputView inputView = new InputView();
        String inputValue = "1,4,12,20,38,41";
        systemIn(inputValue);
        TreeSet<Integer> lottoNumbers = inputView.requestLottoNumber();
        assertThat(lottoNumbers).contains(1,4,12,20,38,41);
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("보너스 숫자는 1이상 숫자를 입려해야 한다.")
    @Test
    void requestLottoBonusByUnderMin() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "0";
            systemIn(inputValue);
            inputView.requestBonusNumber();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(INVALID_INPUT_LOTTO_RANGE);
    }

    @DisplayName("보너스 숫자는 45이하 숫자를 입려해야 한다.")
    @Test
    void requestLottoBonusByOverMax() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "46";
            systemIn(inputValue);
            inputView.requestBonusNumber();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(INVALID_INPUT_LOTTO_RANGE);
    }

    @DisplayName("보너스 숫자는 숫자만 입력해야 한다.")
    @Test
    void requestLottoBonusByInvalidFormat() {
        assertThatThrownBy(() -> {
            InputView inputView = new InputView();
            String inputValue = "test";
            systemIn(inputValue);
            inputView.requestBonusNumber();
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(String.format(INVALID_INPUT_FORMAT, LOTTO_NUMBER_FORMAT));
    }

    private void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private void systemOut() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }
}