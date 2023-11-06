package lotto.view;

=import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
=import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest {

    InputView inputView = new InputView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("구입 금액을 성공적으로 입력받는다.")
    void readMoney() {
       System.setIn(createInput("10000"));
       assertThat(inputView.readMoney()).isEqualTo(10000);
    }

    @Test
    @DisplayName("구입 금액을 숫자가 아닌 문자로 입력하면 예외가 발생한다.")
    void readMoneyByNotNumber() {
        System.setIn(createInput("10000j"));
        assertThatThrownBy(() -> inputView.readMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액을 음수로 입력하면 예외가 발생한다.")
    void readMoneyByNegativeNumber() {
        System.setIn(createInput("-10000"));
        assertThatThrownBy(() -> inputView.readMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호를 성공적으로 입력받는다.")
    void readLottoNumbers() {
        System.setIn(createInput("1,2,3,4,5,6"));
        assertThat(inputView.readLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호를 숫자가 아닌 문자로 입력하면 예외가 발생한다.")
    void readLottoNumbersByNotNumber() {
        System.setIn(createInput("1,2,3,4,5,6j"));
        assertThatThrownBy(() -> inputView.readLottoNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 쉼표가 아닌 punctuation을 입력하면 예외가 발생한다.")
    void readLottoNumbersByLessThanSix() {
        System.setIn(createInput("1,2,3.4,5"));
        assertThatThrownBy(() -> inputView.readLottoNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자에 숫자가 아닌 문자로 입력하면 예외가 발생한다.")
    void readBonusNumberByNotNumber() {
        System.setIn(createInput("1j"));
        assertThatThrownBy(() -> inputView.readBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자에 음수를 입력하면 예외가 발생한다.")
    void readBonusNumberByNegativeNumber() {
        System.setIn(createInput("-1"));
        assertThatThrownBy(() -> inputView.readBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자를 성공적으로 입력 받는다.")
    void readBonusNumber() {
        System.setIn(createInput("1"));
        assertThat(inputView.readBonusNumber()).isEqualTo(1);
    }

    InputStream createInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

}
