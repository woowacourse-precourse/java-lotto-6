package lotto.exceptionhandler;

import java.util.LinkedList;
import java.util.List;
import lotto.exception.exceptionhandler.ExceptionHandler;
import lotto.exception.exceptionhandler.RetryExceptionHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryExceptionHandlerTest {

    ExceptionHandler handler = new RetryExceptionHandler();

    @Test
    @DisplayName("예외가 발생하면 해당 예외를 출력하고 다시 실행한다.")
    public void retry_Test() {
        //given
        List<String> numberString = new LinkedList<>(List.of("abc", "1"));

        //when
        int a = handler.getResult(() -> {
            String str = numberString.remove(0);
            return Integer.parseInt(str);
        });

        //then
        Assertions.assertThat(a).isEqualTo(1);
    }
}