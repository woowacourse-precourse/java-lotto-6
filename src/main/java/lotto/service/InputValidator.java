package lotto.service;

import lotto.model.LottoConstants;
import lotto.model.LottoManager;
import lotto.view.InputView;

import java.util.List;

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
                System.out.println("[ERROR] 정수로 변환이 불가능합니다. 다시 입력해주세요.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage() + " 다시 입력해주세요.");
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
                System.out.println("[ERROR] 정수로 변환이 불가능합니다. 다시 입력해주세요.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage() + " 다시 입력해주세요.");
            }
        }
        return purchaseAmount;
    }

    public void validateLottoPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("로또 구입 금액은 %d원 단위로 입력 받아야합니다.", LottoConstants.LOTTO_PRICE));
        }
    }

    public void validateBonusNumber(LottoManager winningNumbers, InputView inputView) {
        while (true) {
            try {
                int bonusNumber = getBonusNumberFromUser(inputView);
                addBonusNumberToWinningNumbers(winningNumbers, bonusNumber);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 정수로 변환이 불가능합니다. 다시 입력해주세요.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage() + " 다시 입력해주세요.");
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
