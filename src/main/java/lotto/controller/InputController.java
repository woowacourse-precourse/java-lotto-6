package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.service.NumberValidator;
import lotto.view.InputView;

public class InputController {

    private static final String COMMA_DELIMITER = ",";

    private static final String NUMBER = "^[0-9]+$";

    private final NumberValidator numberValidator;

    private final InputView inputView;

    public InputController() {
        numberValidator = new NumberValidator();
        inputView = new InputView();
    }

    public int inputPurchasePrice() {
        boolean isValidInput = false;
        int price = 0;
        while (!isValidInput) {
            inputView.showPurchasePriceMessage();
            try {
                price = convertInputData(Console.readLine());
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    private int convertInputData(String purchasePrice) {
        numberValidator.validatePurchasePriceIsNumber(purchasePrice);
        int price = Integer.parseInt(purchasePrice);
        numberValidator.validatePurchasePriceUnit(price);
        return price;
    }

    public List<Integer> inputLottoNumbers() {
        List<String> winningNumber = Arrays.asList(Console.readLine().split(COMMA_DELIMITER));
        return winningNumber.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public int checkBonusNumber(List<Integer> winningNumbers) {
        boolean isValidInput = false;
        int bonusNumber = 0;
        while (!isValidInput) {
            inputView.showInputBonusNumberMessage();
            try {
                inputBonusNumber(winningNumbers);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        String inputData = Console.readLine();
        numberValidator.validateInputDataIsNumber(inputData);
        int bonusNumber = Integer.parseInt(inputData);
        numberValidator.validateDuplicateNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }
}
