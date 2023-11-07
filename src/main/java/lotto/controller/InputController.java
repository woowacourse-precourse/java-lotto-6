package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoNumbers;
import lotto.domain.Unit;
import lotto.service.NumberValidator;
import lotto.view.InputView;

public class InputController {

    private static final String COMMA_DELIMITER = ",";

    private final NumberValidator numberValidator;
    private final InputView inputView;

    public InputController(InputView inputView) {
        numberValidator = new NumberValidator();
        this.inputView = inputView;
    }

    public int inputPurchasePrice() {
        int price;
        inputView.showPurchasePriceMessage();
        while (true) {
            try {
                price = convertInputData(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    private int convertInputData(String purchasePrice) {
        numberValidator.validateInputDataIsNumber(purchasePrice);
        int price = Integer.parseInt(purchasePrice);
        numberValidator.validatePurchasePrice(price);
        return price;
    }

    public List<Integer> inputLottoNumbers() {
        String[] inputData = Console.readLine().split(COMMA_DELIMITER);
        numberValidator.validateInputDataLengthIsSix(inputData);
        List<String> winningNumber = Arrays.asList(inputData);
        return winningNumber.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public int checkBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        inputView.showInputBonusNumberMessage();
        while (true) {
            try {
                bonusNumber = inputBonusNumber(winningNumbers);
                break;
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
