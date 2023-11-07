package lotto.controller;

import lotto.logic.Logic;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;

public class InputController {
    private final View view;

    public InputController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public int getPurchaseAmount() {
        String input = view.getPurchaseAmount();
        try {
            return validatePurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinningNumber() {
        String input = view.getWinningNumbers();
        try {
            return parseToWinningNumbers(input).stream()
                    .map((o) -> parseNumber(o))
                    .toList();
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getWinningNumber();
        }
    }

    public int getBonusNumber() {
        String input = view.getBonusNumber();
        try {
            return parseNumber(input);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getBonusNumber();
        }
    }

    private List<String> parseToWinningNumbers(String input) {
        List<String> numbers = Arrays.asList(input.split(","));
        if (numbers.size() != Logic.NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨번호는 6개여야 합니다.");
        }
        for (int idx = 0; idx < numbers.size(); idx++) {
            if (numbers.lastIndexOf(idx) != idx) {
                throw new IllegalArgumentException("당첨번호는 중복될 수 없습니다.");
            }
        }
        return numbers;
    }

    private int validatePurchaseAmount(String inputNumber) {
        int payment = parseNumber(inputNumber);
        if (payment <= 0 || payment % 1000 != 0) {
            throw new IllegalArgumentException("지불 금액은 1000원 단위의 양수여야 합니다.");
        }
        return payment;
    }

    private int parseNumber(String inputNumber) {
        int number = 0;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자만으로 이루어져야 합니다.");
        }
        return validateNumber(number);
    }

    private int validateNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        return number;
    }
}
