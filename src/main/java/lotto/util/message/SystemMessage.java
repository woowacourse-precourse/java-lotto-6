package lotto.util.message;

import java.util.function.Consumer;

public enum SystemMessage {

    INPUT_MONEY("구입금액을 입력해 주세요.", System.out::println),
    LOTTO_PURCHASE("\n%d개를 구매했습니다.%n", System.out::printf),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요.", System.out::println),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.", System.out::println);

    private final String message;
    private final Consumer<String> print;

    SystemMessage(String message, Consumer<String> print) {
        this.message = message;
        this.print = print;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        print.accept(message);
    }


}






