package lotto.controller;
import lotto.Utils;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Purchase;

import java.util.ArrayList;
import java.util.Collections;
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

    private List<Integer> matchCounts = new ArrayList<>(Collections.nCopies(5, 0));

    private void checkResult() {
        for (Lotto userLotto : userLottos) {
            int prizeRank = userLotto.checkWinning(winningLotto, bonusNumber.getBonusNumber());
            if (prizeRank > 0) {
                matchCounts.set(5 - prizeRank, matchCounts.get(5 - prizeRank) + 1);
            }
        }
    }

    private void printResult() {
        System.out.println("당첨 내역");
        System.out.println("3개 일치 (5,000원) - " + matchCounts.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts.get(4) + "개");
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
        checkResult();
        printResult();
    }
}