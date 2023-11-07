package lotto.controller;
import lotto.Utils;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Purchase;

import java.util.ArrayList;
import java.util.List;

public class LottoGameManager {

    private final UserInputManager userInputManager;
    private List<Lotto> userLottos;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

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

    private void setWinningLotto() {
        String winningNumbersInput = userInputManager.getWinningNumbersInput();
        List<Integer> winningNumbers = Utils.convertStringToListOfIntegers(winningNumbersInput);
        this.winningLotto = new Lotto(winningNumbers);
    }

    private BonusNumber bonusNumber() {
        String bonusNumberInput = userInputManager.getBonusNumberInput();
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInput);

        return bonusNumber;
    }

    public void play() {
        String purchasePriceInput = userInputManager.getPurchasePriceInput();
        Purchase purchase = new Purchase(purchasePriceInput);
        int lottoCount = purchase.getLottoCount();
        createLotto(lottoCount);
        printLotto();
        setWinningLotto();
        System.out.println("보너스 넘버를 입력하세요");
        this.bonusNumber = bonusNumber();
    }
}