package lotto.exceptions;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import lotto.constant.Message;
import lotto.view.View;

public class ExceptionHandler {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static <T> T handleException(Message message, Supplier<T> supplier) {
        while (true) {
            try {
                if (message != Message.NULL) {
                    printMessage(message.getMessage());
                }
                return supplier.get();
            } catch (NumberFormatException e) {
                View.printMessage(ERROR_MESSAGE + "숫자만 입력가능합니다.");
                readLineWithMessage();
            } catch (IllegalArgumentException e) {
                View.printMessage(ERROR_MESSAGE + "입력 형식 또는 값이 잘못되었습니다.");
                readLineWithMessage();
            } catch (NoSuchElementException e) {
                View.printMessage(ERROR_MESSAGE + "객체를 찾을 수 없습니다.");
                readLineWithMessage();
            } catch (Exception e) {
                View.printMessage(ERROR_MESSAGE + "예상치 못한 오류입니다 : " + e.getMessage());
                readLineWithMessage();
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
