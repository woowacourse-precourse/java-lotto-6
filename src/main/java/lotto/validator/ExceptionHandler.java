package lotto.validator;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Supplier;
import lotto.constant.Message;
import lotto.view.View;

public class ExceptionHandler {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static <T> T handleException(Message message, Supplier<T> supplier) {
        while (true) {
            try {
                printMessage(message.getMessage());
                return supplier.get();
            } catch (NumberFormatException e) {
                View.printMessage(ERROR_MESSAGE + "숫자만 입력가능합니다.");
                readLineWithMessage();
            } catch (Exception e) {
                View.printMessage(ERROR_MESSAGE +"예상치 못한 오류입니다 : "+e.getMessage());
                throw e;
            }
        }
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static String readLineWithMessage() {
        return Console.readLine();
    }
}
