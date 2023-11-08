package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //구매 금액 입력
        BuyTickets buyTickets = new BuyTickets();
        Map<Integer, List<Integer>> lotteryNumbers = buyTickets.getLotteryNumbers();
        //당첨 번호 입력
        List<Integer> winningNumbers = SystemIO.requestWinningNumber();
        int bonusNumber = SystemIO.requestBonusNumber();
        //추첨 진행
        Calculations calculations = new Calculations();
        for (List<Integer> value : lotteryNumbers.values()) {
            Lotto lotto = new Lotto(value);
            calculations.tallyWinnings(lotto.getWinningRank(winningNumbers, bonusNumber));
        }
        SystemIO.showResult(calculations.getWinningTally(), calculations.getWinningAmount(), buyTickets.getPurchaseAmount());
    }
}
