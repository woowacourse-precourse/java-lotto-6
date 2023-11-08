package lotto.util;

import java.util.Optional;
import lotto.validator.Validator;

public class ErrorMessageSender {
    public static Optional<String> validateAndGetErrorMessage(Validator<String> validator, String input) {
        try {
            validator.validate(input);
            return Optional.empty(); // 에러가 없으면 빈 Optional 반환
        } catch (IllegalArgumentException e) {
            return Optional.of(e.getMessage()); // 에러 메시지를 담은 Optional 반환
        }
    }

}
