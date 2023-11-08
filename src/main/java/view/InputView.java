package view;

import camp.nextstep.edu.missionutils.Console;
import constant.Constants;
import constant.ErrorMessage;
import java.awt.IllegalComponentStateException;
import java.util.List;
import validation.ExceptionHandler;

public class InputView {
    private final ExceptionHandler exceptionHandler;

    public InputView() {
        exceptionHandler = new ExceptionHandler();
    }

    public Integer enterPriceToBuy() {
        while (true) {
            try {
                System.out.println(Constants.ENTER_PRICE_TO_BUY_MESSAGE);
                String priceToBuy = Console.readLine().trim();
                exceptionHandler.validateIfOnlyNumber(priceToBuy);
                int moneyToBuyLotto = Integer.parseInt(priceToBuy);
                exceptionHandler.validateMultipleOfThousand(moneyToBuyLotto);
                return moneyToBuyLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.onlyNumberMessage);
            } catch (IllegalStateException e) {
                System.out.println(ErrorMessage.enterOnlyMultipleOfThounsandMessage);
            }
        }
    }

    public int enterBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        while (true) {
            try {
                return exceptionHandler.validateBonusNumber(winningNumbers);
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.onlyNumberMessage);
            } catch (IllegalStateException e) {
                System.out.println(ErrorMessage.existInWinningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.enterOneToFourtyFiveMessage);
            }
        }
    }


    public List<Integer> enterWinningNumber() {
        System.out.println();
        while (true) {
            try {
                return exceptionHandler.validateWinningNumber();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.enterOneToFourtyFiveMessage);
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.enterOnlyNumberAndComma);
            } catch (IllegalComponentStateException e) {
                System.out.println(ErrorMessage.sameNumberExistMessage);
            } catch (IllegalStateException e) {
                System.out.println(ErrorMessage.enterOnlySixNumbersMessage);
            }
        }
    }
}
