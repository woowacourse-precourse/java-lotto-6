package lotto.controller;

import lotto.constants.message.PurchasedMessage;
import lotto.model.Lotto;
import lotto.model.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPurchaseController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoShop lottoShop = new LottoShop();

    public void purchase(){
        int userPayment = getUserPayment();
        List<Lotto> purchasedLotto = purchaseLotto(userPayment);
        purchasedLotto.forEach(this::printPurchasedLotto);
    }

    private int getUserPayment() {
        try {
            outputView.requestPayment();
            String userInput = inputView.getUserInput();
            validateInt(userInput);
            return Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getUserPayment();
        }
    }

    private List<Lotto> purchaseLotto(int payment) {
        try {
            return lottoShop.sell(payment);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return purchaseLotto(payment);
        }
    }

    private void printPurchasedLotto(Lotto purchasedLotto) {
        String formattedLotto = purchasedLotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(PurchasedMessage.PURCHASED_LOTTO_DELIMITER));
        outputView.printFormattedLotto(formattedLotto);
    }

    private void validateInt(String userInput) throws IllegalArgumentException {
        try {
            Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
