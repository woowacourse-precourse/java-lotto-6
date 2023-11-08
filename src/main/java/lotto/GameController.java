package lotto;

import static lotto.view.Output.consoleLine;

import java.util.Arrays;
import java.util.List;


import java.util.Map;
import java.util.stream.Collectors;
import lotto.view.OutputResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.Input;
import lotto.view.Output;
import lotto.Message.GameMessage;

public class GameController {

    public void start() {
        Money count = insertMoney();
        List<Lotto> lottos = generateUserLotto(count);
        WinningLotto winningLotto = generateWinningLottto();
        Map<Integer, Integer> resultLottos = winningLotto.compareLottos(lottos);
        printResult(resultLottos, count);
    }

    private Money insertMoney(){
        consoleLine(GameMessage.OUT_REQUEST_MONEY_MESSAGE);
        Money count = new Money(Integer.parseInt(Input.consoleLine()));
        consoleLine("");
        return count;
    }

    private List<Lotto> generateUserLotto(Money count){
        count.printCount();
        List<Lotto> lottos =  Lottos.generateLotto(count);
        consoleLine("");
        return lottos;
    }

    private WinningLotto generateWinningLottto(){
        consoleLine(GameMessage.OUT_REQUEST_WINNING_LOTTO_MESSAGE);
        List<Integer> winningNumbers = splitNumber(Input.consoleLine());

        consoleLine(GameMessage.OUT_REQUEST_BONUS_NUMBER_MESSAGE);
        int bonusNumbers = Integer.parseInt(Input.consoleLine());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumbers);
        consoleLine("");

        return winningLotto;
    }

    private List<Integer> splitNumber(String str){
        System.out.println();
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void printResult(Map<Integer, Integer> resultLottos, Money money) {
        double profitPercentage = money.calculateProfit(resultLottos);
        OutputResult.printAllReultMessge(resultLottos, profitPercentage);
        }
}
