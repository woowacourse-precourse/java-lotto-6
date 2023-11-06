package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //티켓 구매
        SystemIO.requestPurchaseAmount();
        String purchaseAmount = readLine();
        BuyTickets buyTickets = new BuyTickets(purchaseAmount);

        //당첨 번호 입력
        SystemIO.requestWinningNumber();
        List<Integer> winningNumbers = SystemIO.readWinningNumbers();
        Map<Long, List<Integer>> lotteryNumbers = buyTickets.getLotteryNumbers();

        Lotto lotto = new Lotto(winningNumbers);
        Map<String, Long> matchResult = lotto.matchUserNumberWithWinningNumbers(lotteryNumbers);

        /**
         * BuyTickets 클래스의 getLotteryNumbers를 main메서드 영역으로 받음
         * -> Lotto에서 당첨번호 받기
         * -> Lotto에서 matchUserNumberWithWinningNumbers를 통해 당첨결과 확인 및 집계
         */


    }
}
