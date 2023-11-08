package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    private final int LOTTO_PRICE = 1000;
    private List<List<Integer>> lottos = new ArrayList<>();
    private List<Integer> numbers;
    private CheckLotto checkLotto = new CheckLotto();
    private Map<String, Integer> ranking;
    private Lotto lotto;
    private int bonusNumber;
    private long money;

    public void start() {
        money = getMoney();
        OutputView.printLottoNumber(money);

        generateLotto(money);
        System.out.println();
        getWinningNumbers();
        System.out.println();
        getBonusNumber();
        System.out.println();
        calculateRanking();
        System.out.println();

        showWinningStatistic();
        System.out.println();
        result();
    }

    private long getMoney() {
        try{
            LottoNumber lottoNumber = new LottoNumber(InputView.inputMoney());
            return lottoNumber.getLottoNumber();
        } catch (IllegalArgumentException e) {
            return getMoney();
        }
    }

    private void generateLotto(long money) {
        long count = money;
        while (count > 0) {
            BuyLottos buyLottos = new BuyLottos();
            lottos.add(buyLottos.butLottos());
            count--;
        }
        for (List<Integer> lotto: lottos) {
            System.out.println(lotto);
        }
    }

    private void getWinningNumbers() {
        try {
            lotto = new Lotto(InputView.inputWinningNumbers());
            numbers = lotto.getLotto();
        } catch (IllegalArgumentException e) {
            getWinningNumbers();
        }
    }

    private void getBonusNumber() {
        try {
            bonusNumber = lotto.bonusNumber(InputView.inputBonusNumber());
        } catch (IllegalArgumentException e) {
            getBonusNumber();
        }
    }

    private void calculateRanking() {
        ranking = checkLotto.checkNumber(lottos, numbers, bonusNumber);
    }

    private void showWinningStatistic() {
        OutputView.printStatisics();
        for (WinningResult winningResult: WinningResult.values()) {
            if (winningResult.getCorrectNumberCount() != 0) {
                System.out.println(winningResult.getMessage() + " - " + ranking.get(winningResult.name()) + "개");
            }
        }
    }

    private void result() {
        double sum = 0;
        for (WinningResult winningResult: WinningResult.values()) {
            sum += (long) ranking.get(winningResult.name()) * winningResult.getWinningMoney();
        }

        double outputResult = (sum * 100) / (money * LOTTO_PRICE);
        double roundOutputResult = Math.round(outputResult * 10.0) / 10.0;

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 " + decimalFormat.format(roundOutputResult) + "%입니다.");
    }
}
