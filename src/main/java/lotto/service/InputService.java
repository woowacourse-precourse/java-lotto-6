package lotto.service;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.Message.ERROR_BONUS_DUPLICATE;
import static lotto.constant.Message.ERROR_INPUT_NOT_NUMBER;
import static lotto.constant.Message.ERROR_MONEY_REMAINDER;
import static lotto.constant.Message.ERROR_NUMBER_RANGE;
import static lotto.constant.Message.INPUT_ANSWER;
import static lotto.constant.Message.INPUT_BONUS;
import static lotto.constant.Message.INPUT_MONEY;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoUtil;

public class InputService {

private String read(String notice) {
    System.out.println(notice);
    return Console.readLine();
}

public int readMoney() {
    String input = "";
    do {
        try {
            input = read(INPUT_MONEY.getMsg());
            return validatedMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
}

private int validatedMoney(String input) {
    int money = validatedNumber(input);
    if (money % LOTTO_PRICE.getValue() != 0) {
        throw new IllegalArgumentException(String.format(ERROR_MONEY_REMAINDER.getMsg(), "구입금액"));
    }
    return money;
}

public Lotto readAnswer() {
    String input = "";
    do {
        try {
            input = read(INPUT_ANSWER.getMsg());
            return validatedAnswer(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
}

public Lotto validatedAnswer(String input) {
    String[] tokens = input.split(",");
    List<Integer> answer = new ArrayList<>();
    for (String token: tokens) {
        int number = validatedNumber(token.trim());
        answer.add(number);
    }
    return new Lotto(answer);
}

public int readBonus(Lotto answer) {
    String input = "";
    do {
        try {
            input = read(INPUT_BONUS.getMsg());
            return validatedBonus(input, answer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    } while (true);
}

private int validatedBonus(String input, Lotto answer) {
    int bonus = validatedNumber(input);
    if (!LottoUtil.isNumberInRange(bonus)) {
        throw new IllegalArgumentException(ERROR_NUMBER_RANGE.getMsg());
    }
    if (answer.has(bonus)) {
        throw new IllegalArgumentException(ERROR_BONUS_DUPLICATE.getMsg());
    }
    return bonus;
}

private int validatedNumber(String s) {
    try {
        return Integer.parseInt(s);
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException(ERROR_INPUT_NOT_NUMBER.getMsg());
    }
}
}
