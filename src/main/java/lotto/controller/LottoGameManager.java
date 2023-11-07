package lotto.controller;

import lotto.Utils;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.ProfitCalculator;
import lotto.model.Purchase;
import lotto.view.InterfaceView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.view.InterfaceView.*;


public class LottoGameManager {

    private final UserInputManager userInputManager;
    private List<Lotto> userLottos;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;



    public LottoGameManager(UserInputManager userInputManager) {
        this.userInputManager = userInputManager;
        this.userLottos = new ArrayList<>();
    }

    public void play() {
        priceInputMessage();
        int lottoCount = purchaseLotto();
        InterfaceView.checkMessage(lottoCount);
        createLotto(lottoCount);
        printLotto(userLottos);
        winningNumberInputMessage();
        setWinningLotto();
        bonusNumberInputMessage();
        this.bonusNumber = bonusNumber();
        checkResult();
        printResult(matchCounts);
        ProfitCalculator profitCalculator = new ProfitCalculator(Purchase.getPurchasePrice(), matchCounts);
        BigDecimal profitRate = profitCalculator.calculateProfit();
        printProfitRate(profitRate);
    }



    private int purchaseLotto() {
        String purchasePriceInput = userInputManager.getPurchasePriceInput();
        Purchase purchase = new Purchase(purchasePriceInput);
        return purchase.getLottoCount();
    }

    private BonusNumber bonusNumber() {
        String bonusNumberInput = userInputManager.getBonusNumberInput();
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInput);

        return bonusNumber;
    }



    private void createLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            userLottos.add(Lotto.makeLotto());
        }
    }


    private List<Integer> matchCounts = new ArrayList<>(Collections.nCopies(5, 0));

    private void checkResult() {
        for (Lotto userLotto : userLottos) {
            int prizeRank = userLotto.checkWinning(winningLotto, bonusNumber.getBonusNumber());
            if (prizeRank > 0) {
                // 등수에 해당하는 인덱스 위치의 값을 증가
                // 1등이면 인덱스 4, 2등이면 인덱스 3, 3등이면 인덱스 2, 4등이면 인덱스 1, 5등이면 인덱스 0
                matchCounts.set(5 - prizeRank, matchCounts.get(5 - prizeRank) + 1);
            }
        }
    }




    private void setWinningLotto() {
        String winningNumbersInput = userInputManager.getWinningNumbersInput();
        List<Integer> winningNumbers = Utils.convertStringToListOfIntegers(winningNumbersInput);
        this.winningLotto = new Lotto(winningNumbers);
    }
}