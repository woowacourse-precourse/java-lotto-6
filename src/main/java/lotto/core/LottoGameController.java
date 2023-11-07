package lotto.core;

import java.util.List;

import lotto.preprocessor.BonusNumPreprocessor;
import lotto.preprocessor.PurchasePreprocessor;
import lotto.preprocessor.WinningNumsPreprocessor;
import lotto.util.LottoConst;
import lotto.util.Rank;

public class LottoGameController {

    private LottoGame lottoGame;
    private PurchasePreprocessor purchasePreprocessor;
    private WinningNumsPreprocessor winningNumsPreprocessor;
    private BonusNumPreprocessor bonusNumPreprocessor;

    public void init() {
        this.lottoGame = new LottoGame();
        purchasePreprocessor = new PurchasePreprocessor();
        winningNumsPreprocessor = new WinningNumsPreprocessor();
        bonusNumPreprocessor = new BonusNumPreprocessor();
    }

    public void runGame() {
        init();
        purchaseLotto();
        drawWinningNumbers();
        drawBonusNumber();
        reportWinningResult();
    }

    public void purchaseLotto() {
        int amount = purchasePreprocessor.process("구입금액을 입력해 주세요.");
        int numOfPurchase = calcNumOfPurchase(amount);
        System.out.println(numOfPurchase + "개를 구매했습니다.");
        lottoGame.setNumOfLotto(numOfPurchase);
        System.out.println(lottoGame.issueLottos());
    }

    private int calcNumOfPurchase(int amount) {
        return amount / LottoConst.UNIT;
    }

    public void drawWinningNumbers() {
        List<Integer> winningNumbers = winningNumsPreprocessor.process("당첨 번호를 입력해 주세요.");
        lottoGame.setWinningNumbers(winningNumbers);
        bonusNumPreprocessor.setWinningNumbers(winningNumbers);
    }

    public void drawBonusNumber() {
        Integer bonusNum = bonusNumPreprocessor.process("보너스 번호를 입력해주세요.");
        lottoGame.setBonusNumber(bonusNum);
    }

    private void reportWinningResult() {
        List<Rank> winningResults = lottoGame.findWinningResults();
        System.out.println("winningResults = " + winningResults);
    }
}
