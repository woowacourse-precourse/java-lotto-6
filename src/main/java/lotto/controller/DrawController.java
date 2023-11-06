package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.IssueLotto;
import lotto.model.LottoRankings;
import lotto.model.LottoResult;
import lotto.model.MatchLotto;
import lotto.model.PurchaseLotto;
import lotto.model.WinningNumber;
import lotto.model.Yield;
import lotto.view.InputView;

public class DrawController {

    private final PurchaseLotto purchaseLotto;
    private final IssueLotto issueLotto;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;
    private final MatchLotto matchLotto;
    private final LottoResult lottoResult;
    private final Yield yield;

    public DrawController() {
        this.purchaseLotto = new PurchaseLotto();
        this.issueLotto = new IssueLotto();
        this.winningNumber = new WinningNumber();
        this.bonusNumber = new BonusNumber();
        this.matchLotto = new MatchLotto();
        this.lottoResult = new LottoResult(0);
        this.yield = new Yield();
    }

    public void draw() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseLotto.purchase(InputView.input());

        issueLotto.issue(purchaseLotto.getNumberOfPurchases());

        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumber.inputWinningNumber(InputView.input());

        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber.inputBonusNumber(InputView.input(), winningNumber.getWinningNumbers());
        matchLotto.matchLotto(winningNumber.getWinningNumbers(),
                bonusNumber.getBonusNumber(), issueLotto.getLottoPurchaseHistory());
        lottoResult.checkResult(matchLotto.getWinningMatchResult(), matchLotto.getBonusMatchResult());

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(String.format(LottoRankings.FIRST.getMessage(),
                formatWinningAmount(LottoRankings.FIRST.getWinningAmount()),
                lottoResult.getFirst()));
        System.out.println(String.format(LottoRankings.SECOND.getMessage(),
                formatWinningAmount(LottoRankings.SECOND.getWinningAmount()),
                lottoResult.getSecond()));
        System.out.println(String.format(LottoRankings.THIRD.getMessage(),
                formatWinningAmount(LottoRankings.THIRD.getWinningAmount()),
                lottoResult.getThird()));
        System.out.println(String.format(LottoRankings.FOURTH.getMessage(),
                formatWinningAmount(LottoRankings.FOURTH.getWinningAmount()),
                lottoResult.getFourth()));
        System.out.println(String.format(LottoRankings.FIFTH.getMessage(),
                formatWinningAmount(LottoRankings.FIFTH.getWinningAmount()),
                lottoResult.getFifth()));

        yield.calculateYield(lottoResult.getTotalPrizeMoney(), purchaseLotto.getPurchaseAmount());
        System.out.println("총 수익률은 " + yield.getYield() + "%입니다.");
    }

    private static String formatWinningAmount(int amount) {
        return String.valueOf(amount).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    }
}
