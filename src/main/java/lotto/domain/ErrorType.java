package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public enum ErrorType {
    NOT_A_NUMBER("(은)는 숫자여야 합니다.", input -> {
        try {
            Arrays.stream(input.split(","))
                    .forEach(Integer::parseInt);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }),
    NOT_IN_THOUSANDS("(은)는 1000원 단위여야 합니다.", input -> {
        int money = Integer.parseInt(input) % 1_000;
        return money != 0;
    }),
    OUT_OF_RANGE("(은)는 1부터 45 사이의 수여야 합니다.", input ->
            Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .noneMatch(number -> 0 < number && number <= 45)
    ),
    LENGTH_NOT_MATCH("(은)는 6자리여야 합니다.", input -> input.split(",").length == 6),
    DUPLICATED_NUMBER("(은)는 중복된 수입니다.", input -> {
        Set<Integer> isDuplicated = new HashSet<>();

        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .anyMatch(isDuplicated::add);
    }),

    NOT_AN_ERROR("정상", null);

    private final String errorMsg;
    private Predicate<String> isError;


    ErrorType(String errorMsg, Predicate<String> isError) {
        this.errorMsg = errorMsg;
        this.isError = isError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
