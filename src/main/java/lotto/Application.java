package lotto;

import java.util.List;
import java.util.Map;

import exception.CustomException;
import lotto.domain.Lotto;
import lotto.service.LottoPurchase;
import lotto.service.LottoStatistics;
import lotto.service.RandomNumberGenerator;
import lotto.service.WinningNumberInput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        WinningNumberInput winningNumberInput = new WinningNumberInput();

        int userPurchase;
        while (true) {
            try {
                userPurchase = new LottoPurchase(new LottoPurchase().inputLottoString()).inputLottoPurchase();
                System.out.printf("\n%d개를 구매했습니다.\n", userPurchase);
                break;
            } catch (CustomException customException) {
                System.out.println(customException.getMessage());
            }
        }

        List<Lotto> lottos = new RandomNumberGenerator(userPurchase).generateRandomNumber();
        Map<Lotto, Integer> winningLotto = winningNumberInput.inputWinningNumbers();

        System.out.println("\n당첨 통계\n---");
        new LottoStatistics(userPurchase, lottos, winningLotto).calculateWinRate();

    }
}
