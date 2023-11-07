package lotto.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import lotto.view.InputView;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import camp.nextstep.edu.missionutils.Console;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {


    @AfterEach
    void closeInputStream() {
        Console.close();
    }

    void setInputValues(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }


    @DisplayName("로또 구매 금액의 입력에 공백이 입력되면 예외가 발생한다.")
    @Test
    void readBuyAmount_Space_ExceptionThrow() {
        setInputValues("\n");
        assertThatThrownBy(() -> InputView.readBuyAmount()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액의 입력에 문자가 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"ABC", "HELLO", "####", "!@#"})
    void readBuyAmount_NotInteger_ExceptionThrow(String input) {
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readBuyAmount()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액의 입력이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1200", "1001", "10002"})
    void readBuyAmount_NotDivided_ExecptionThrow(String input) {
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readBuyAmount()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 공백이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = "\n")
    void readWinningNumber_Space_ExceptionThrow(String input) {
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readWinningNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 문자가 아닌 값이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"hello", "jun", "kiki"})
    void readWinningNumber_NotInteger_ExceptionThrow(String input) {
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readWinningNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 6자리가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3", "1,2,3,4,5,6,8,9", "1,2", "1"})
    void readWinningNumber_IsNotSixNumber_ExceptionThrow(String input) {
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readWinningNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복된 입력이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,3,3,3", "3,4,4,5,5,6"})
    void readWinningNumber_IsDuplicateNumber_ExceptionThrow(String input) {
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readWinningNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 1~45를 벗어난 입력이 들어올 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,66,4,5,3", "200,2,1,7,6,5", "3,4,5,500,7,8","-1,-2,-3,-4,-5,-6"})
    void readWinningNumber_IsNotCollectRange_ExceptionThrow(String input) {
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readWinningNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1~45를 벗어난 입력이 들어올 경우 예외가 발생한다.")
    @Test
    void readBonusNumber_IsNotCollectRange_ExceptionThrow() {
        String input = "1000";
        setInputValues(input);
        assertThatThrownBy(() -> InputView.readBonusNumber()).isInstanceOf(IllegalArgumentException.class);
    }


}
