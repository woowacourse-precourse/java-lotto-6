package lotto;

import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class InputTest {



    @DisplayName("테스트 사용자 입력을 위한 함수")
    InputStream makeInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
}
