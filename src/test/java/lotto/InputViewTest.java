package lotto;

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


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    void setInputValues(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @AfterEach
    void closeInputStream(){
        Console.close();
    }

    @DisplayName("로또 번호의 입력이 공백이 입력되면 예외가 발생한다.")
    @Test
    void readBuyAmount_Space_ExceptionThrown() {
        setInputValues("\n");
        assertThatThrownBy(() -> InputView.readBuyAmount()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 입력에 문자가 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"ABC","HELLO","####","!@#"})
    void readBuyAmount_NotInteger_ExceptionThrown(String input){
        setInputValues(input);
        assertThatThrownBy(()->InputView.readBuyAmount()).isInstanceOf(IllegalArgumentException.class);
    }




}
