package lotto;

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
        System.out.println(GameMessage.OUT_REQUEST_MONEY_MESSAGE);
        Money count = new Money(Integer.parseInt(Input.consoleLine()));
        count.checkmoney();
        System.out.println();
        return count;
    }

    private List<Lotto> generateUserLotto(Money count){
        count.printCount();
        List<Lotto> lottos =  Lottos.generateLotto(count);
        System.out.println();
        return lottos;
    }

    private WinningLotto generateWinningLottto(){
        Output.consoleLine(GameMessage.OUT_REQUEST_WINNING_LOTTO_MESSAGE);
        List<Integer> winningNumbers = splitNumber(Input.consoleLine());

        Output.consoleLine(GameMessage.OUT_REQUEST_BONUS_NUMBER_MESSAGE);
        int bonusNumbers = Integer.parseInt(Input.consoleLine());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumbers);

        return winningLotto;
    }

    private List<Integer> splitNumber(String str){
        System.out.println();
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void printResult(Map<Integer, Integer> resultLottos, Money money) {
        long profitPercentage = calculateResult(resultLottos, money);
        OutputResult.printAllReultMessge(resultLottos, profitPercentage);
        }

    private long calculateResult(Map<Integer, Integer> resultLottos, Money money){
        return money.calculateProfit(resultLottos);
    }

}
