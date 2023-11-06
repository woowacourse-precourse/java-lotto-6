package lotto;

import java.util.ArrayList;
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
        Lotto lotto = new Lotto(winningNumbers);
        lotto.matchUserNumberWithWinningNumbers(winningNumbers, bonusNumber);

        /**
         * BuyTickets 클래스의 getLotteryNumbers를 main메서드 영역으로 받음
         * -> Lotto에서 당첨번호 받기
         * -> Lotto에서 matchUserNumberWithWinningNumbers를 통해 당첨결과 확인 및 집계
         */


    }
}
