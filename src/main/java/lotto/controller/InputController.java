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

    public List<Integer> getWinningNumbers() {
        String inputNumbers = view.getWinningNumbers();
        try {
            return parseNumbers(inputNumbers);
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        String input = view.getBonusNumber();
        try {
            int bonusNumber = parseNumber(input);
            isWinningNumber(bonusNumber);
            isDuplicated(winningNumbers, bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            view.printError(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = Arrays.asList(input.split(",")).stream()
                .map((o) -> parseNumber(o))
                .map((o) -> isWinningNumber(o))
                .toList();
        if (numbers.size() != Logic.NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨번호는 6개여야 합니다.");
        }
        isDuplicated(numbers);
        return numbers;
    }

    private int validatePurchaseAmount(String inputNumber) {
        int payment = parseNumber(inputNumber);
        if (payment <= 0 || payment % 1000 != 0) {
            throw new IllegalArgumentException("지불 금액은 1000원 단위의 양수여야 합니다.");
        }
        return payment;
    }

    private int isWinningNumber(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
        return number;
    }

    private int parseNumber(String inputNumber) {
        int number;
        try {
            number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력은 숫자만으로 이루어져야 합니다.");
        }
        return number;
    }

    private void isDuplicated(List<Integer> numbers) {
        for (int idx = 0; idx < numbers.size(); idx++) {
            int number = numbers.get(idx);
            if (numbers.lastIndexOf(number) != idx) {
                throw new IllegalArgumentException("당첨번호는 중복될 수 없습니다.");
            }
        }
    }

    private void isDuplicated(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("이미 존재하는 번호 입니다.");
        }
    }
}
