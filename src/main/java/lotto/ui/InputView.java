package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.util.ErrorMessages;

public class InputView {

    private final OutputView outputView = new OutputView();

    public int inputMoney() {
        outputView.enterYourAmount();
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        if (!isParseable(money)) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MONEY_FORMAT_ERROR.getMessage());
        }
    }

    private boolean isParseable(String money) {
        for (char digit : money.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }

    public int inputBonusNumber() {
        outputView.enterYourBonusNumber();
        int money = Integer.parseInt(Console.readLine());
        System.out.println();
        return money;
    }

    public List<Integer> inputNumbers() {
        String s = Console.readLine();
        return Arrays.stream(s.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
