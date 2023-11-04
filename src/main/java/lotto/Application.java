package lotto;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.LottoPurchase;
import lotto.service.RandomNumberGenerator;
import lotto.service.WinningNumberInput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoPurchase lottoPurchase = new LottoPurchase();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        WinningNumberInput winningNumberInput = new WinningNumberInput();

        int userPurchase = lottoPurchase.inputLottoPurchase();
        System.out.printf("\n%d개를 구매하셨습니다.\n", userPurchase);

        List<Lotto> lottos = randomNumberGenerator.generateRandomNumber(userPurchase);
        Map<Lotto, Integer> winningLotto = winningNumberInput.inputWinningNumbers();

    }
}
