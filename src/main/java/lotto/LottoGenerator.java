package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static Lotto generateLotto() {
        RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
        return new Lotto(randomNumbersGenerator.generateLottoNumbers());
    }

    public static List<Lotto> getSeveralLotteries(int countLotto) {
        List<Lotto> Lotteries = new ArrayList<>();

        for (int i = 0; i < countLotto; i++) {
            Lotteries.add(generateLotto());
        }
        return Lotteries;
    }
}
