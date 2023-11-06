package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("구매 금액에 공백 입력 시 에러를 발생시킨다.")
    void inputMoneyBlankTest() {
        // given
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(" ".getBytes());
        System.setIn(byteArrayInputStream);
        // when & then
        Assertions.assertThatThrownBy( () ->inputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @Test
    @DisplayName("구매 금액에 숫자 이외의 값이 입력될 시 에러를 발생시킨다.")
    void inputMoneyStringTest() {
        // given
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("AB".getBytes());
        System.setIn(byteArrayInputStream);
        // when & then
        Assertions.assertThatThrownBy( () ->inputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @Test
    @DisplayName("보너스 번호에 금액에 공백 입력 시 에러를 발생시킨다.")
    void inputBonusBlankTest() {
        // give
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(" ".getBytes());
        System.setIn(byteArrayInputStream);
        // when & then
        Assertions.assertThatThrownBy( () ->inputView.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @Test
    @DisplayName("보너스 번호에 숫자 이외의 값이 입력될 시 에러를 발생시킨다.")
    void inputBonusStringTest() {
        // given
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("AB".getBytes());
        System.setIn(byteArrayInputStream);
        // when & then
        Assertions.assertThatThrownBy( () ->inputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @Test
    @DisplayName("형식에 맞지않게 입력될 시 에러를 발생시킨다.")
    void inputWinningNumberTest1() {
        // given
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1,2,3,4,5,6,7".getBytes());
        System.setIn(byteArrayInputStream);
        // when & then
        Assertions.assertThatThrownBy( () ->inputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @Test
    @DisplayName("형식에 맞지않게 입력될 시 에러를 발생시킨다.")
    void inputWinningNumberTest2() {
        // given
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1,2,3,4".getBytes());
        System.setIn(byteArrayInputStream);
        // when & then
        Assertions.assertThatThrownBy( () ->inputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

    @Test
    @DisplayName("형식에 맞지않게 입력될 시 에러를 발생시킨다.")
    void inputWinningNumberTest3() {
        // given
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("1,2,3,4,,".getBytes());
        System.setIn(byteArrayInputStream);
        // when & then
        Assertions.assertThatThrownBy( () ->inputView.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
        Console.close();
    }

}