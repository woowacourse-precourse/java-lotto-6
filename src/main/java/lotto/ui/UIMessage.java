package lotto.ui;

import java.util.function.Consumer;
import java.util.function.Function;

public enum UIMessage {
    INSERT_PAYMENT_PRICE("구입금액을 입력해 주세요."),

    PAYMENT_PRICE_MUST_BE_INTEGER("구입금액은 정수만 가능합니다."),
    INSERT_ANSWER_NUMBER("당첨 번호를 입력해 주세요."),
    INSERT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BONUS_NUMBER_MUST_BE_INTEGER("보너스 번호는 숫자만 가능합니다.");
    private final String message;

    UIMessage(String message) {
        this.message = message;
    }

    public void accept(Consumer<String> consumer) {
        consumer.accept(message);
    }

    public <R> R apply(Function<String, R> function) {
        return function.apply(message);
    }

}
