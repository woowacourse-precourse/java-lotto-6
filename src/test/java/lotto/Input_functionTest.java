package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Input_functionTest {

    @Test
void 금액입력_예외처리테스트() {
    Input_function inputFunction = new Input_function() {
        private boolean isFirstCall = true;

        @Override
        public int inputNumber() {
            if (isFirstCall) {
                isFirstCall = false;
                throw new NumberFormatException();
            } else {
                return 1000; // 유효한 값 반환
            }
        }
    };

    // 첫 번째 호출에서 예외가 발생하고, 두 번째 호출에서 유효한 값이 반환되기를 기대합니다.
    assertDoesNotThrow(() -> assertEquals(1000, inputFunction.getMoney()));
}

    

 
}