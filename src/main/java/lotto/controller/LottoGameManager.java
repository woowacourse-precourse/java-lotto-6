package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Purchase;

import java.util.ArrayList;
import java.util.List;

public class LottoGameManager {

    private final UserInputManager userInputManager;
    private List<Lotto> userLottos;

    public LottoGameManager(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
        this.userLottos = new ArrayList<>();
    }

    private void createLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            userLottos.add(Lotto.makeLotto());
        }
    }
    private void printLotto() {
        userLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void play() {
        String purchasePriceInput = userInputManager.getPurchasePriceInput();
        Purchase purchase = new Purchase(purchasePriceInput);
        int lottoCount = purchase.getLottoCount();
        createLotto(lottoCount);
        printLotto();
    }
}