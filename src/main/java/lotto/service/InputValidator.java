package lotto.service;

import lotto.model.LottoManager;
import lotto.view.InputView;

import java.util.List;

public class InputValidator {

    private static final int LOTTO_PRICE = 1000;

    public LottoManager validateWinningNumbers(InputView inputView) {
        LottoManager result;
        List<Integer> winningNumbersFromUser;
        while (true) {
            try {
                winningNumbersFromUser = inputView.getWinningNumbersFromUser();
                result = new LottoManager(winningNumbersFromUser);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 정수로 변환이 불가능합니다. 다시 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage() + " 다시 입력해주세요.");
            }
        }
        return result;
    }

    public int getPurchaseAmount(InputView inputView) {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = inputView.getPurchaseAmountFromUser();
                validatePurchaseAmount(purchaseAmount);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 정수로 변환이 불가능합니다. 다시 입력해주세요.");
            } catch (IllegalStateException | IllegalArgumentException e) {
                System.out.println("[Error] " + e.getMessage() + " 다시 입력해주세요.");
            }
        }
        return purchaseAmount;
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 입력 받아야합니다.");
        }
    }
}
