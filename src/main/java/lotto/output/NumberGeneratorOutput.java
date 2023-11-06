package lotto.output;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;

import java.util.List;

public class NumberGeneratorOutput {
    public void printLotteryNumbers(NumberGenerator numbers, int numOfLotto) {
        numbers.lottoNumbers(numOfLotto);
        List<Lotto> lotteries = numbers.getLotteries();

        for (Lotto lotto : lotteries) {
            System.out.println(lotto.getNumbers());
        }
    }
}
