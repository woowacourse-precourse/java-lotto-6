package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.IssueLotto;
import lotto.model.Lotto;
import lotto.model.LottoRankings;
import lotto.model.LottoResult;
import lotto.model.MatchLotto;
import lotto.model.PurchaseLotto;
import lotto.model.Yield;
import lotto.view.InputView;

public class DrawController {

    private final PurchaseLotto purchaseLotto;
    private final IssueLotto issueLotto;
    private final BonusNumber bonusNumber;
    private final MatchLotto matchLotto;
    private final LottoResult lottoResult;
    private final Yield yield;

    public DrawController() {
        this.purchaseLotto = new PurchaseLotto();
        this.issueLotto = new IssueLotto();
        this.bonusNumber = new BonusNumber();
        this.matchLotto = new MatchLotto();
        this.lottoResult = new LottoResult(0);
        this.yield = new Yield();
    }

    public void draw() {
        inputPurchaseAmount();

        issueLotto.issue(purchaseLotto.getNumberOfPurchases());

        List<Integer> winningNumbers = inputWinningNumber().getNumbers();

        inputBonusNumber(winningNumbers);

        matchLotto.matchLotto(winningNumbers,
                bonusNumber.getBonusNumber(), issueLotto.getLottoPurchaseHistory());
        lottoResult.checkResult(matchLotto.getWinningMatchResult(), matchLotto.getBonusMatchResult());

        checkRank();

        yield.calculateYield(lottoResult.getTotalPrizeMoney(), purchaseLotto.getPurchaseAmount());
        System.out.println("총 수익률은 " + yield.getYield() + "%입니다.");
    }

    private void checkRank() {
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
    }

    private void inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            bonusNumber.inputBonusNumber(InputView.input(), winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber.inputBonusNumber(InputView.input(), winningNumbers);
        }
    }

    private Lotto inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            return Lotto.createWinningNumbers(InputView.input());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Lotto.createWinningNumbers(InputView.input());
        }
    }

    private void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            purchaseLotto.purchase(InputView.input());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            purchaseLotto.purchase(InputView.input());
        }
    }

    private static String formatWinningAmount(int amount) {
        return String.valueOf(amount).replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
    }
}
