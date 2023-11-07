package lotto.controller;

import java.util.HashMap;
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
        this.lottoResult = new LottoResult();
        this.yield = new Yield();
    }

    public void draw() {
        inputPurchaseAmount();
        issueLotto.issue(purchaseLotto.getNumberOfPurchases());
        List<Integer> winningNumbers = inputWinningNumber().getNumbers();
        inputBonusNumber(winningNumbers);

        matchLotto.matchLotto(winningNumbers, bonusNumber.getBonusNumber(), issueLotto.getLottoPurchaseHistory());
        lottoResult.checkResult(matchLotto.getMatchResult());

        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRankings rank : LottoRankings.values()) {
            Integer count = lottoResult.getLottoResult().get(rank);
            if (count != null) {
                System.out.println(String.format(rank.getMessage(),
                        formatWinningAmount(rank.getWinningAmount()),
                        lottoResult.getLottoResult().get(rank)));
                continue;
            }
            System.out.println(String.format(rank.getMessage(), formatWinningAmount(rank.getWinningAmount()), 0));
        }

        checkYield();
    }

    private void checkYield() {
        int totalPrizeMoney = 0;
        for (LottoRankings rank : lottoResult.getLottoResult().keySet()) {
            totalPrizeMoney += rank.getWinningAmount() * lottoResult.getLottoResult().get(rank);
        }
        yield.calculateYield(totalPrizeMoney, purchaseLotto.getPurchaseAmount());
        System.out.println("총 수익률은 " + yield.getYield() + "%입니다.");
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
