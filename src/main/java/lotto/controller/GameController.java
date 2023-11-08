package lotto.controller;

import lotto.domain.*;
import lotto.utils.MessageConstant;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {
    InputView inputView;
    Money money;
    Lottos lottos;
    WinningLotto winningLotto;

    public void play() {
        startGame();
        printResult();
    }

    private void startGame() {
        this.inputView = new InputView();
        inputMoney();
        buyLottos(money);
        setWinningLotto();
    }

    private void inputMoney() {
        try {
            int money = inputView.inputNumber(MessageConstant.INPUT_PURCHASE_AMOUNT);
            this.money = new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            inputMoney();
        }
    }

    private void buyLottos(Money money) {
        try {
            int count = money.getLottoCount();
            this.lottos = new Lottos(count);
            List<Lotto> lottoList = lottos.getLottos();
            OutputView.printLottos(lottoList);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            buyLottos(money);
        }
    }

    public void setWinningLotto() {
        Lotto winningLotto = inputWinningLotto();
        inputBonusNumber(winningLotto);
    }

    private Lotto inputWinningLotto() {
        try {
            List<Integer> numbers = inputView.inputNumbers(MessageConstant.INPUT_WINNING_NUMBERS);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            return inputWinningLotto();
        }
    }

    private void inputBonusNumber(Lotto lotto) {
        try {
            int bonus = inputView.inputNumber(MessageConstant.INPUT_BONUS_NUMBER);
            this.winningLotto = new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            inputBonusNumber(lotto);
        }
    }

    private void printResult() {
        // 메시지 출력
        OutputView.printResultMessage();
        // 등수별 개수 출력
        printRankingCount();
        // 수익률 출력
        printRageOfReturn(money.getMoney());
    }

    public void printRankingCount() {
        Map<Ranking, Integer> rankingCount = setRankingCount();
        rankingCount.entrySet()
                .stream()
                .forEach(entry -> {
                    Ranking ranking = entry.getKey();
                    Integer count = entry.getValue();
                    String message = ranking.getMessage();
                    OutputView.printCount(message, count);
                });
    }

    private Map<Ranking, Integer> setRankingCount() {
        Lotto winnigLotto = winningLotto.getWinningLotto();
        int bonus = winningLotto.getBonus();
        return lottos.countRankings(winnigLotto, bonus);
    }

    public void printRageOfReturn(int money) {
        Result result = new Result(setRankingCount());
        double rateOfReturn = result.getRateOfReturn(money);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
