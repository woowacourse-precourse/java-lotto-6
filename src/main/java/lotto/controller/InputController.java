package lotto.controller;

import lotto.view.ConsoleView;
import lotto.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputController {
    private final View view;

    public InputController(View view) {
        this.view = view;
    }

    public int getPurchaseAmount() {
        String input = view.getPurchaseAmount();
        try {
            return validPayment(input);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public List<Integer> getWinningNumber() {
        String input = view.getWinningNumbers();
        try {
            return Arrays.stream(input.split(","))
                    .map((o) -> validNumber(o))
                    .toList();
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getWinningNumber();
        }
    }

    public int getBonusNumber() {
        String input = view.getBonusNumber();
        try {
            return validNumber(input);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getBonusNumber();
        }
    }

    private int validPayment(String input) {
        int payment;

        try {
            payment = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지불 금액은 정수여야 합니다.");
        }

        if (payment <= 0) {
            throw new IllegalArgumentException("지불 금액은 0 보다 커야 합니다.");
        } else if (payment % 1000 != 0) {
            throw new IllegalArgumentException("지불 금액은 1000원 단위여야 합니다.");
        }
        return payment;
    }

    private int validNumber(String inputNumber) {
        int number;

        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }

        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        return number;
    }
}
