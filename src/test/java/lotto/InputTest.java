package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class InputTest {
    @DisplayName("구입 금액 입력 받을 때 1000에 떨어지지 않게 받으면 예외 발생")
    @Test
    void purchaseTest(){
        // given
        Input input = new Input();

        // when
        System.setIn(makeInput("2100"));

        // then

    }


    @DisplayName("테스트 사용자 입력을 위한 함수")
    InputStream makeInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
}
