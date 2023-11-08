package lotto.util.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.exception.LottoValidateException;
import lotto.exception.UserAbortException;

public class InputRetryHandler {

    private static final String RETRY_MESSAGE_FORMAT = "%s 다시 입력해주세요.";
    private static final String USER_ABORT_MESSAGE = "콘솔 창을 종료하셨군요! 게임을 종료합니다.";


    private InputRetryHandler() {
    }

    /**
     * 사용자로부터 유효한 입력을 받을 때까지 반복해서 입력을 요청하는 메서드입니다. 입력 값은 주어진 valueSupplier에 의해 제공되며, converter를 통해 변환됩니다. 입력 값이 유효하지 않을 경우
     * (예외가 발생할 경우), 사용자에게 오류 메시지를 출력하고 다시 입력을 요청합니다. 유효한 입력이 제공되면, 변환된 값을 반환합니다.
     *
     * @param valueSupplier 입력 값을 제공하는 Supplier 인터페이스. 사용자로부터 받은 입력 값을 반환합니다.
     * @param converter     입력 값을 변환하는 함수. 이 함수는 입력 값을 유효한 결과 타입으로 변환합니다.
     */
    public static <T, E> E retryUntilValidInput(Supplier<T> valueSupplier, Function<T, E> converter) {
        while (true) {
            try {
                T inputValue = valueSupplier.get();
                return converter.apply(inputValue);
            } catch (NoSuchElementException ignored) {
                //스캐너를 통해 값을 읽을 때 컨트롤 c나 d를 사용해서(윈도우 기준) 콘솔을
                //종료하면 scanner가 읽을 값이 없기 때문에 NoSuchElementException발생
                Console.close();
                throw new UserAbortException(USER_ABORT_MESSAGE);
            } catch (LottoValidateException ex) {
                System.out.printf(RETRY_MESSAGE_FORMAT + System.lineSeparator(), ex.getMessage());
            }

        }
    }

}

