package lotto.core;

import camp.nextstep.edu.missionutils.Console;
import lotto.preprocessor.PurchasePreprocessor;
import lotto.preprocessor.WinningNumsPreprocessor;
import lotto.util.ExceptionHandler;
import lotto.util.LottoConst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LottoGameController {

    private LottoGame lottoGame;
    private PurchasePreprocessor purchasePreprocessor;
    private WinningNumsPreprocessor winningNumsPreprocessor;

    public void init() {
        purchasePreprocessor = new PurchasePreprocessor();
        winningNumsPreprocessor = new WinningNumsPreprocessor();
    }

    public void runGame() {
        init();
        purchaseLotto();
        drawWinningNumbers();
    }

    public void purchaseLotto() {
        int numOfPurchase = calcNumOfPurchase();
        System.out.println(numOfPurchase + "개를 구매했습니다.");
        this.lottoGame = new LottoGame(numOfPurchase);
        System.out.println(lottoGame.issueLottos());
    }

    private int calcNumOfPurchase() {
        int amount = purchasePreprocessor.process("구입금액을 입력해 주세요.");
        int numOfPurchase = amount / LottoConst.UNIT;
        return numOfPurchase;
    }

    public void drawWinningNumbers() {
        List<Integer> winningNumbers = winningNumsPreprocessor.process("당첨 번호를 입력해 주세요.");
        this.lottoGame.setWinningNumbers(winningNumbers);
    }
}
