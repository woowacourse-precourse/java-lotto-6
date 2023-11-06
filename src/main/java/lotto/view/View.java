package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.FrontController;
import lotto.enums.GuideMessage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.enums.ErrorMessage.*;
import static lotto.enums.GuideMessage.*;

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
        List<String> messages = (List<String>) model.get("messages");

        if (view != null)
            redirect(view);

        if (messages != null)
            printMessage(messages);
    }

    public void redirect(String url) {
        Map<String, Object> model = new HashMap<>();
        String view = frontController.match(url, model);
        List<String> messages = (List<String>) model.get("messages");

        if (view != null)
            redirect(view);

        if (messages != null)
            printMessage(messages);
    }

    private void printMessage(List<String> messages) {
        for (String message : messages)
            System.out.println(message);
    }
}