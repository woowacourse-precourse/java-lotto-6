package controller;

import camp.nextstep.edu.missionutils.Console;
import validation.LottoValidation;
import view.InputView;
import view.OutputMessage;

public class UserController {
    LottoValidation lottoValidation = new LottoValidation();
    InputView inputView = new InputView();

    public int inputPriceHowManyLottos() {
        boolean isValidInput = false;
        String purchasePrice = "";
        while (!isValidInput) {
            try {
                inputView.showInputPriceToUser();
                purchasePrice = Console.readLine();
                if (isInteger(purchasePrice)) {
                    validationInputPrice(purchasePrice);
                }
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(purchasePrice);
    }

    private void validationInputPrice(String purchasePrice) {
        int price = Integer.parseInt(purchasePrice);

        if (!lottoValidation.validateInputPrice(price)) {
            throw new IllegalArgumentException("[ERROR] " + OutputMessage.OUTPUT_ERROR_PRICE_THOUSAND.getMessage());
        } else if (!lottoValidation.isBiggerThanZero(price)) {
            throw new IllegalArgumentException("[ERROR] " + OutputMessage.OUTPUT_ERROR_PRICE_ZERO.getMessage());
        }
    }

    private boolean isInteger(String inputPrice) {
        try {
            Integer.parseInt(inputPrice);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]" + OutputMessage.OUTPUT_ERROR_PRICE_NUMBER.getMessage());
        }
    }
}
