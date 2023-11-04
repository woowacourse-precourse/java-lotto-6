package lotto.controller;

import lotto.model.Investor;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.Prize;
import lotto.model.Shop;
import lotto.model.dto.LottoResponse;
import lotto.model.judge.BonusNumberJudge;
import lotto.model.judge.GoalNumberJudge;
import lotto.model.judge.LottoJudge;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.askInvestMoney();
        String moneyInput = inputView.readLine();
        Money investMoney = Money.from(moneyInput);
        Investor investor = Investor.createDefault(investMoney);
        Shop lottoShop = Shop.createDefault();
        List<Lotto> lottos = investor.buyLottosFromShop(lottoShop);
        outputView.printBoughtLottoSize(lottos.size());
        List<LottoResponse> lottoResponses = convertLottoResponses(lottos);
        outputView.printEachLottoNumbers(lottoResponses);
        outputView.askGoalNumbers();
        String goalNumbersInput = inputView.readLine();
        outputView.askBonusNumber();
        String bonusNumberInput = inputView.readLine();
        outputView.alertResult();
        LottoJudge goalJudge = GoalNumberJudge.from(goalNumbersInput);
        LottoJudge bonusJudge = BonusNumberJudge.from(bonusNumberInput);
        for (int i = 3; i < 6; i++) {
            List<Lotto> matchLotto = goalJudge.collectLottoWithMatchSize(lottos, i);
            Prize prize = Prize.findByPoint(i * 100);
            investor.addProfitMoney(prize.getMoney() * matchLotto.size());
            outputView.printEachPrize(prize.getCondition(), prize.getMoney(), matchLotto.size());
        }

        List<Lotto> secondMatchLotto = bonusJudge.collectLottoWithMatchSize(lottos, 5);
        List<Lotto> secondResultLotto = goalJudge.collectLottoWithMatchSize(secondMatchLotto, 5);
        Prize secondPrize = Prize.findByPoint(550);
        investor.addProfitMoney(secondPrize.getMoney() * secondResultLotto.size());
        outputView.printEachPrize(secondPrize.getCondition(), secondPrize.getMoney(), secondResultLotto.size());

        List<Lotto> firstLotto = goalJudge.collectLottoWithMatchSize(lottos, 6);
        Prize prize = Prize.findByPoint(600);
        investor.addProfitMoney(prize.getMoney() * firstLotto.size());
        outputView.printEachPrize(prize.getCondition(), prize.getMoney(), firstLotto.size());

        outputView.printProfitRate(investor.calculateProfitRate());
    }

    private List<LottoResponse> convertLottoResponses(final List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> LottoResponse.from(lotto.getNumbers()))
                .toList();
    }
}
