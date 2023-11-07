package lotto.view;

import static lotto.view.constant.Message.NOTICE_STATS_SUBJECT;

import lotto.exception.LottoException;
import lotto.view.constant.Message;

public class ConsoleOutputView implements OutputView {
    protected ConsoleOutputView() {}

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printDynamicMessage(Message message, Object... args) {
        System.out.printf(message.getMessage(), args);
        printEmptyLine();
    }

    public void printIterableMessage(Iterable<?> iterable) {
        iterable.forEach(System.out::println);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printResult(String message) {
        printMessage(NOTICE_STATS_SUBJECT);
        System.out.print(message);
    }

    public void printErrorMessage(LottoException message) {
        System.out.println(message.getMessage());
    }
}
