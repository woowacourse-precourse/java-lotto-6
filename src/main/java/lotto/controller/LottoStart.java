package lotto.controller;

import static lotto.view.PrintPurchaseAmount.printPurchaseAmount;
import static lotto.view.PrintPurchaseLotto.printLotto;
import static lotto.view.PrintStatistics.printStatistics;

import java.util.List;
import lotto.model.CreateLotto;
import lotto.model.GroupLotto;
import lotto.model.LottoResult;
import lotto.model.PurchaseAmountLotto;
import lotto.model.Statistics;
import lotto.model.WinningLottoNumbers;

public class LottoStart {
    public void run() {
        PurchaseAmountLotto purchaseAmountLotto = getAmountLotto();
        printPurchaseAmount(purchaseAmountLotto);
        GroupLotto lottos = getLottos(purchaseAmountLotto);
        printLotto(lottos);
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();
        LottoResult result = new LottoResult();
        lottoResult(result, winningLottoNumbers, lottos);
        Statistics statistics = new Statistics(purchaseAmountLotto, result);
        printStatistics(result, statistics);
    }

    private PurchaseAmountLotto getAmountLotto() {
        InputPurchaseMoney inputPurchaseMoney = new InputPurchaseMoney();
        Integer money = inputPurchaseMoney.getMoney();
        return new PurchaseAmountLotto(money);
    }

    private GroupLotto getLottos(PurchaseAmountLotto purchaseAmountLotto) {
        CreateLotto createLotto = new CreateLotto();
        return new GroupLotto(createLotto.createLottos(purchaseAmountLotto.getPurchaseLotto()));
    }

    private WinningLottoNumbers getWinningLottoNumbers() {
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();
        List<Integer> winningNumbers = inputWinningNumbers.getWinningNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber(winningNumbers);
        int bonusNumber = inputBonusNumber.getBonusNumber();
        return new WinningLottoNumbers(winningNumbers, bonusNumber);
    }

    private void lottoResult(LottoResult result, WinningLottoNumbers winningLottoNumbers, GroupLotto groupLotto) {
        result.resultLogic(winningLottoNumbers, groupLotto);
    }

    private Statistics getRate(PurchaseAmountLotto purchaseAmountLotto, LottoResult result) {
        return new Statistics(purchaseAmountLotto, result);
    }
}
