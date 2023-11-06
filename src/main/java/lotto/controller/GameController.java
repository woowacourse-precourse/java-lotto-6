package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.GradeConstant;
import lotto.model.Bonus;
import lotto.model.GameResult;
import lotto.model.Lotto;
import lotto.model.PlayerLottos;
import lotto.model.Purchase;
import lotto.model.Referee;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    public void start() {
        Purchase purchase = createPurchase();
        printLottoAmount(purchase);
        PlayerLottos playerLottos = new PlayerLottos(purchase.getLottoAmount());
        printPlayerLottosInfo(playerLottos);

        Lotto winningLotto = createWinningLotto();
        Bonus bonus = createBonus(winningLotto);

        Referee referee = new Referee(playerLottos.getLottos(), winningLotto, bonus.number());
        GameResult gameResult = new GameResult(referee.getGrades(), purchase.getPurchaseMoney());

        printLottoGradeResult(gameResult.getGrades());
        printProfitRate(gameResult.getProfitRate());
    }

    private void printLottoAmount(Purchase purchase) {
        int lottoAmount = purchase.getLottoAmount();
        OutputView.printLottoAmount(lottoAmount);
    }

    private void printPlayerLottosInfo(PlayerLottos playerLottos) {
        List<Lotto> lottos = playerLottos.getLottos();
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(OutputView::printLottoNumbers);
    }

    private Purchase createPurchase() {
        while (true) {
            try {
                int purchaseMoney = getPurchaseMoney();
                return new Purchase(purchaseMoney);
            } catch (IllegalArgumentException e) {
                InputView.printInputErrorMessage(e);
            }
        }
    }

    private int getPurchaseMoney() {
        return InputView.getPurchaseMoney();
    }

    private Lotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> numbers = getWinningLottoNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                InputView.printInputErrorMessage(e);
            }
        }
    }

    private List<Integer> getWinningLottoNumbers() {
        return InputView.getWinningLottoNumbers();
    }

    private Bonus createBonus(Lotto lotto) {
        while (true) {
            try {
                int bonusNumber = getBonusNumber();
                return new Bonus(bonusNumber, lotto);
            } catch (IllegalArgumentException e) {
                InputView.printInputErrorMessage(e);
            }
        }
    }

    private int getBonusNumber() {
        return InputView.getBonusNumber();
    }

    private void printLottoGradeResult(Map<GradeConstant, Integer> gradeResult) {
        OutputView.printLottoGradeResult(gradeResult);
    }

    private void printProfitRate(double profitRate) {
        OutputView.printProfitRate(profitRate);
    }
}