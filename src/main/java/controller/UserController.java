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
        int purchasePrice = 0;
        while (!isValidInput) {
            try {
                inputView.showInputPriceToUser();
                purchasePrice = Integer.parseInt(Console.readLine());
                if (!lottoValidation.validateInputPrice(purchasePrice)){
                    throw new IllegalArgumentException("[ERROR] "+ OutputMessage.OUTPUT_ERROR_PRICE.getMessage());
                }
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchasePrice;
    }
}
