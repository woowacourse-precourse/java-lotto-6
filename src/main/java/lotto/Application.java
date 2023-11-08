package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.BonusDraw;
import domain.LottoDraw;
import domain.MainEvent;
import domain.Purchase;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Purchase purchase = new Purchase();
        LottoDraw lottoDraw = new LottoDraw();
        BonusDraw bonusDraw = new BonusDraw();
        MainEvent mainEvent = new MainEvent();

        try {

            System.out.println("구입금액을 입력해 주세요.");
            String userInput = Console.readLine();

            List<Lotto> lottoList = purchase.printPurchasedList(userInput);

            System.out.println("당첨 번호를 입력해 주세요.");
            String winNumbersInput = Console.readLine();

            List<Integer> winNumbers = lottoDraw.winNumbers(winNumbersInput);

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();

            bonusDraw.bonusDraw(winNumbers, bonusNumberInput);
            int bonusNumber = bonusDraw.bonusNumber(bonusNumberInput);

            mainEvent.printResult(lottoList, winNumbers, bonusNumber);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
