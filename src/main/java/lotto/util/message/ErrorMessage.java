package lotto.util.message;

import java.util.function.Consumer;

public enum ErrorMessage {

    HEAD("[ERROR] ", null),
    MONEY_NOT_DIVIDABLE("로또 가격으로 나누어 떨어지지 않는 금액입니다.", System.out::println),
    MONEY_OUT_OF_RANGE("로또 구매금액은 %d 이하의 금액만 입력가능합니다.%n", System.out::printf),
    NON_DIGIT("숫자가 아닙니다.", System.out::println),
    INVALID_FORMAT("유효하지 않은 입력 형식입니다.", System.out::println),
    NUMBER_OUT_OF_RANGE("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.%n", System.out::printf),
    INVALID_NUMBER_COUNT("당첨 숫자는 %d개만 입력가능합니다.%n", System.out::printf),
    DUPLICATE_NUMBER_EXIST("중복된 숫자가 존재합니다.", System.out::println),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 로또번호와 중복되지 않아야합니다.", System.out::println),

    ;

    private final String error;
    private final Consumer<String> print;

    ErrorMessage(String message, Consumer<String> print) {
        this.error = message;
        this.print = print;
    }

    public void printError() {
        print.accept(HEAD.error + error);
    }

    public void printError(int numberInputLimit) {
        print.accept(String.format(HEAD.error + error, numberInputLimit));
    }

    public void printError(int startInclusive, int endInclusive) {
        print.accept(String.format(HEAD.error + error, startInclusive, endInclusive));
    }

}