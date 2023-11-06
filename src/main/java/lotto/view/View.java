package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.FrontController;

import java.util.HashMap;
import java.util.Map;

import static lotto.enums.ErrorMessage.*;
import static lotto.enums.InputGuideMessage.*;

public class View {
    private final FrontController frontController = new FrontController();
    private final ErrorView errorView = ErrorView.getInstance();

    public void pleaseEnterLottoPaymentMessage() {
        System.out.println(PLEASE_ENTER_LOTTO_PAYMENT_MESSAGE.getMessage());

        boolean validInput = false;
        while (!validInput) {
            try {
                String desiredPurchaseAmount = Console.readLine();

                Map<String, Object> model = new HashMap<>();
                model.put("desiredPurchaseAmount", desiredPurchaseAmount);

                frontController.match("pleaseEnterLottoPaymentMessage", model);

                validInput = true;
            } catch (IllegalArgumentException e) {
                errorView.printErrorPage(INVALID_AMOUNT_ERROR);
            }
        }


    }

    public void pleaseEnterWinningNumbersMessage() {
        System.out.println(PLEASE_ENTER_WINNING_NUMBERS_MESSAGE.getMessage());

        boolean validInput = false;
        while (!validInput) {
            try {
                String lottoWinningNumbers = Console.readLine();

                Map<String, Object> model = new HashMap<>();
                model.put("lottoWinningNumbers", lottoWinningNumbers);

                frontController.match("pleaseEnterWinningNumbersMessage", model);

                validInput = true;
            } catch (IllegalArgumentException e) {
                errorView.printErrorPage(INVALID_WINNING_NUMBERS_ERROR);
            }
        }
    }

    public void pleaseEnterBonusNumberMessage() {
        System.out.println(PLEASE_ENTER_BONUS_NUMBER_MESSAGE.getMessage());

        boolean validInput = false;
        while (!validInput) {
            try {
                String bonusNumber = Console.readLine();

                Map<String, Object> model = new HashMap<>();
                model.put("bonusNumber", bonusNumber);

                frontController.match("pleaseEnterBonusNumberMessage", model);

                validInput = true;
            } catch (IllegalArgumentException e) {
                errorView.printErrorPage(INVALID_BONUS_NUMBER_ERROR);
            }
        }
    }

    public void informPurchasedLottosNumbersMessage() {
        Map<String, Object> model = new HashMap<>();
        String view = frontController.match("informPurchasedLottosNumbersMessage", model);
        System.out.printf(INFORM_PURCHASED_LOTTOS_NUMBERS_MESSAGE.getMessage(), model.get("numberOfLotto"));

        if (view != null) {
            redirect(view);
        }
    }

    public void redirect(String url) {
        Map<String, Object> model = new HashMap<>();
        String view = frontController.match(url, model);
        if (view != null)
            redirect(view);
    }
}