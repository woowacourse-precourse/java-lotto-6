package lotto;

import lotto.domain.LottoBonus;
import lotto.domain.LottoMatch;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinning;
import lotto.game.Game;
import lotto.game.result.GameLoopResult;
import lotto.views.LottoBonusInputView;
import lotto.views.LottoMatchResultView;
import lotto.views.LottoPurchaseInputView;
import lotto.views.LottoPurchaseResultView;
import lotto.views.LottoWinningInputView;

public class LottoGame implements Game {

    public LottoPurchase inputPurchase() {
        LottoPurchase purchase = null;
        while (purchase == null) {
            try {
                purchase = new LottoPurchaseInputView().render();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return purchase;
    }

    public LottoWinning inputWinning() {
        LottoWinning winning = null;
        while (winning == null) {
            try {
                winning = new LottoWinningInputView().render();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return winning;
    }

    public LottoBonus inputBonus(LottoWinning winning) {
        LottoBonus bonus = null;
        while (bonus == null) {
            try {
                bonus = new LottoBonusInputView(winning).render();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return bonus;
    }

    @Override
    public GameLoopResult gameLoop() {
        LottoPurchase purchase = inputPurchase();
        new LottoPurchaseResultView(purchase).render();

        LottoWinning winning = inputWinning();
        LottoBonus bonus = inputBonus(winning);

        LottoMatch lottoMatch = new LottoMatch(purchase, winning, bonus);
        new LottoMatchResultView(lottoMatch).render();

        return GameLoopResult.END_GAME;
    }
}
