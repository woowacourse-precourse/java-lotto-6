package lotto.service;

import lotto.model.LottoConstants;
import lotto.model.LottoManager;
import lotto.view.InputView;

import java.util.List;

import static lotto.model.ErrorConstants.*;

public class InputValidator {

    public LottoManager validateWinningNumbers(InputView inputView) {
        LottoManager result;
        List<Integer> winningNumbersFromUser;
        while (true) {
            try {
                winningNumbersFromUser = inputView.getWinningNumbersFromUser();
                result = new LottoManager(winningNumbersFromUser);
                break;
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_EXCEPTION_ERROR);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(String.format(ERROR_MESSAGE,e.getMessage()));
            }
        }
        return result;
    }

    public int validatePurchaseAmount(InputView inputView) {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = inputView.getPurchaseAmountFromUser();
                validateLottoPurchaseAmount(purchaseAmount);
                break;
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_EXCEPTION_ERROR);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(String.format(ERROR_MESSAGE,e.getMessage()));
            }
        }
        return purchaseAmount;
    }

    public void validateLottoPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(LOTTO_MONEY_INPUT_ERROR, LottoConstants.LOTTO_PRICE));
        }
    }

    public void validateBonusNumber(LottoManager winningNumbers, InputView inputView) {
        while (true) {
            try {
                int bonusNumber = getBonusNumberFromUser(inputView);
                addBonusNumberToWinningNumbers(winningNumbers, bonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_EXCEPTION_ERROR);
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println(String.format(ERROR_MESSAGE,e.getMessage()));
            }
        }
    }

    private void addBonusNumberToWinningNumbers(LottoManager winningNumbers, int bonusNumber) {
        winningNumbers.addBonusNumber(bonusNumber);
    }

    private int getBonusNumberFromUser(InputView inputView) {
        return inputView.getBonusNumberFromUser();
    }
}
