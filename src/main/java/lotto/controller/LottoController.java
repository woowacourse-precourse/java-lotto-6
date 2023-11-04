package lotto.controller;

import lotto.Lotto;
import lotto.common.Message;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public int getPurchaseAmount() {
        int result = 0;

        outputView.printMessage(Message.PURCHASE);
        while (result == 0) {
            result = purchaseSequence();
        }
        return result;
    }

    public List<Integer> getLottoNumber() {
        List<Integer> result = new ArrayList<>();

        outputView.printMessage(Message.LOTTO_NUMBER);
        while (result.isEmpty()) {
            result = lottoSequence();
        }
        return result;
    }

    public int getBonusNumber(Lotto lotto) {
        int result = 0;

        outputView.printMessage(Message.BONUS_NUMBER);
        while (result == 0) {
            result = bonusSequence(lotto);
        }
        return result;
    }

    public void printPurchaseResult(List<Lotto> lotties) {
        outputView.printMessage(Message.COMPLETE_PURCHASE, lotties.size());
        for (Lotto lotto : lotties) {
            outputView.printLotto(lotto);
        }
    }

    public void printResult(List<Integer> status) {
        outputView.printResult(status);
    }

    private int purchaseSequence() {
        try {
            return inputView.getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(Message.ERROR_PURCHASE_AMOUNT);
        }
        return 0;
    }

    private List<Integer> lottoSequence() {
        try {
            return inputView.getLottoNumber();
        } catch (IllegalArgumentException e) {
            outputView.printMessage(Message.ERROR_LOTTO_NUMBER);
        }
        return new ArrayList<>();
    }

    private int bonusSequence(Lotto lotto) {
        try {
            return checkDuplicate(lotto);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(Message.ERROR_BONUS_NUMBER);
        }
        return 0;
    }

    private int checkDuplicate(Lotto lotto) {
        int bonus = inputView.getBonusNumber();
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException();
        }
        return bonus;
    }

}
