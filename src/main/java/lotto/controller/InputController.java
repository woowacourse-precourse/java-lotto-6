package lotto.controller;

import static lotto.util.Validator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class InputController {
    public String getQuantityInput() {
        return checkQuantity(InputView.inputAmount());
    }

    private String checkQuantity(String input) {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(input);
            return purchaseAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getQuantityInput();
        }
    }

    public Lotto getWinningNumbersInput() {
        return checkWinningNumbers(InputView.inputWinningNumbers());
    }

    private Lotto checkWinningNumbers(String input) {
        try {
            List<Integer> numbers = transformInputNumber(input);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbersInput();
        }
    }

    public List<Integer> transformInputNumber(String input) {
        List<String> numbers = convertStringToList(input);
        validateNonNumericNumbers(numbers);
        return convertStringToInt(numbers);
    }

    private List<String> convertStringToList(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private List<Integer> convertStringToInt(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : input) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public int getBonusNumberInput(Lotto lotto) {
        return checkBonusNumber(InputView.inputBonusNumber(), lotto);
    }

    private int checkBonusNumber(String input, Lotto lotto) {
        try {
            BonusNumber bonusNumber = new BonusNumber(input, lotto);
            return Integer.parseInt(bonusNumber.getBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumberInput(lotto);
        }
    }
}
