package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //티켓 구매
        String purchaseAmount = SystemIO.requestPurchaseAmount();
        BuyTickets buyTickets = new BuyTickets(purchaseAmount);

        //당첨 번호 입력
        List<Integer> winningNumbers = SystemIO.requestWinningNumber();
        Map<Long, List<Integer>> lotteryNumbers = buyTickets.getLotteryNumbers();
        int bonusNumber = SystemIO.requestBonusNumber();

        //추첨 진행
        Map<WinningRank,Integer> winningRankResult = new HashMap<>();
        for (List<Integer> value : lotteryNumbers.values()) {
            Lotto lotto = new Lotto(value);
            lotto.getWinningRank(winningNumbers, bonusNumber);
        }
    }
}
