package lotto;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.service.LottoPurchase;
import lotto.service.LottoStatistics;
import lotto.service.RandomNumberGenerator;
import lotto.service.WinningNumberInput;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoPurchase lottoPurchase = new LottoPurchase();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        LottoStatistics lottoStatistics = new LottoStatistics();

        int userPurchase = lottoPurchase.inputLottoPurchase();
        System.out.printf("\n%d개를 구매했습니다.\n", userPurchase);

        List<Lotto> lottos = randomNumberGenerator.generateRandomNumber(userPurchase);
        Map<Lotto, Integer> winningLotto = winningNumberInput.inputWinningNumbers();
        System.out.println("\n당첨 통계\n---");
        String winRate = lottoStatistics.calculateWinRate(userPurchase, lottos, winningLotto);
        System.out.println("총 수익률은 "+winRate+"%입니다.");

    }
}
