package lotto.dto;

import lotto.Validator;

import java.util.Arrays;
import java.util.List;

public record RequestDto(
        String requestString
) {
    public static RequestDto of(String requestString) {
        return new RequestDto(requestString);
    }
    public int toMoney() {
        Validator.canNumber(requestString);
        int money = Integer.parseInt(requestString);
        Validator.validateMoney(money);
        return money;
    }
    public List<Integer> toList() {
        Validator.canList(requestString);
        return Arrays.stream(requestString.split(","))
                .map(Integer::parseInt)
                .toList();
    }
    public int toBonusNumber() {
        Validator.canNumber(requestString);
        return Integer.parseInt(requestString);
    }
}
