package lotto.core;

import java.text.DecimalFormat;
import java.util.ArrayList;
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
    private int amount;
    private List<Integer> rankCounts;
    private int earning;

    public void init() {
        this.lottoGame = new LottoGame();
        purchasePreprocessor = new PurchasePreprocessor();
        winningNumsPreprocessor = new WinningNumsPreprocessor();
        bonusNumPreprocessor = new BonusNumPreprocessor();
        amount = 0;
        rankCounts = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        earning = 0;
    }

    public void runGame() {
        init();
        purchaseLotto();
        drawWinningNumbers();
        drawBonusNumber();
        checkWinningResult();
        reportWinningResult();
        reportEarningsRate();
    }

    public void purchaseLotto() {
        amount = purchasePreprocessor.process("구입금액을 입력해 주세요.");
        int numOfPurchase = calcNumOfPurchase(amount);
        System.out.println("\n" + numOfPurchase + "개를 구매했습니다.");
        lottoGame.setNumOfLotto(numOfPurchase);
        System.out.println(lottoGame.issueLottos());
    }

    private int calcNumOfPurchase(int amount) {
        return amount / LottoConst.UNIT;
    }

    public void drawWinningNumbers() {
        List<Integer> winningNumbers = winningNumsPreprocessor.process("\n당첨 번호를 입력해 주세요.");
        lottoGame.setWinningNumbers(winningNumbers);
        bonusNumPreprocessor.setWinningNumbers(winningNumbers);
    }

    public void drawBonusNumber() {
        Integer bonusNum = bonusNumPreprocessor.process("\n보너스 번호를 입력해주세요.");
        lottoGame.setBonusNumber(bonusNum);
    }

    private void checkWinningResult() {
        List<Rank> winningResults = lottoGame.findWinningResults();
        for (Rank winningResult : winningResults) {
            earning += winningResult.getPrizeMoney();
            rankCounts.set(winningResult.ordinal(), rankCounts.get(0) + 1);
        }
    }

    private void reportWinningResult() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = Rank.values().length-1; i >= 0; i--) {
            String matchOfNumResult = makeMatchOtNumsResult(Rank.values()[i]);
            printMatchOtNumsResult(matchOfNumResult);
        }
    }

    private void reportEarningsRate() {
        System.out.println("총 수익률은 " + String.format("%.1f", (double) earning / amount * 100) + "%입니다.");
    }

    private void printMatchOtNumsResult(String matchOfNumResult) {
        System.out.println(matchOfNumResult);
    }

    private String makeMatchOtNumsResult(Rank rank) {
        String matchOfNumResult = rank.toString();
        matchOfNumResult += " ("
                + new DecimalFormat("###,###").format(rank.getPrizeMoney())
                + "원) - " + rankCounts.get(rank.ordinal()) + "개";
        return matchOfNumResult;
    }
}
