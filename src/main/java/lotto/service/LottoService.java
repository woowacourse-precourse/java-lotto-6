package lotto.service;

import java.util.ArrayList;
import lotto.model.InputValidation;
import lotto.model.Lotto;
import lotto.model.RandomNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {
    private static final int DIVIDED_AMOUNT = 1000;
    private int lottoCount;
    private ArrayList<Lotto> lottos;

    public void createLottoCount() {
        while (true) {
            try {
                lottoCount = checkLottoCount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int checkLottoCount() {
        int validAmount = checkPurchaseAmount();
        return calculateLottoCount(validAmount);
    }

    public int checkPurchaseAmount() {
        String amount = InputView.purchaseAmount();
        return checkNumber(amount);
    }

    public int checkNumber(String amount) {
        InputValidation.validateNumber(amount);
        return Integer.parseInt(amount);
    }

    public int calculateLottoCount(int validAmount) {
        InputValidation.validatePurchaseAmount(validAmount);
        return validAmount / DIVIDED_AMOUNT;
    }

    public void play() {
        OutputView.printLottoCount(lottoCount);
        createLottos();
    }

    public void createLottos() {
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumber.make()));
        }
        printLottoNumbers();
    }

    public void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
