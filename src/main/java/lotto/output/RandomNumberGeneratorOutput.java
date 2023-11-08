package lotto.output;

import lotto.domain.Lotto;
import lotto.domain.RandomNumberGenerator;

import java.util.List;

public class RandomNumberGeneratorOutput {
    public void printLotteryNumbers(RandomNumberGenerator numbers, int numOfLotto) {
        numbers.lottoNumbers(numOfLotto);
        List<Lotto> lotteries = numbers.getLotteries();

        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
