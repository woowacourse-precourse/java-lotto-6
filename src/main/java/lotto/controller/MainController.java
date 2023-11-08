package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.model.Money.MONEY_UNIT;

public class MainController {

    private InputView inputview;
    private OutputView outputView;
    private static Win win;

    public MainController(){
        this.inputview = new InputView();
        this.outputView = new OutputView();
    }
    public void start(){
        Money money = inputview.inputMoneyInfo();
        Lottos lottos = inputview.LottoListInfo(money);
        Lotto lotto = inputview.answerLottoInfo();
        BonusNumber bonusNumber = inputview.bonusNumberInfo(lotto.getNumbers());

        win = new Win(lotto,bonusNumber.getNumber());

        lottoResult(lottos.getLottoList(), win, money.getPlayCount());

    }

    private void lottoResult(List<Lotto> lottoList, Win win, int amount) {
        Map<Reward, Integer> result = setResult();
        Reward reward;

        OutputView.printRewardResult();
        for (int i = 0; i < lottoList.size(); i++) {
            reward = win.result(lottoList.get(i));
            result.put(reward, result.get(reward) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }
    private void printResult(Map<Reward, Integer> result) {
        for (int i = Reward.values().length - 1; i >= 0; i--) {
            Reward.values()[i].printMessage(result.get(Reward.values()[i]));
        }
    }

    private void printEarningRate(Map<Reward, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Reward rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getAwardMoney()) / (lottoAmount * MONEY_UNIT) * (result.get(
                            rank)) * (100));

        }
        OutputView.printRevenueResult(EarningRate);
    }

    private Map<Reward, Integer> setResult() {
        Map<Reward, Integer> result = new LinkedHashMap<>();

        for (Reward rank : Reward.values()) {
            result.put(rank, 0);
        }
        return result;
    }


}
