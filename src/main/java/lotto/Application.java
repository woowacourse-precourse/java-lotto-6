package lotto;

import lotto.domain.ProfitCalculator;
import lotto.io.ConsoleLottoOutput;
import lotto.io.UserLottoInput;
import lotto.service.PurchaseService;
import lotto.service.generator.RandomLottoGenerator;
import lotto.service.generator.RandomNumbersGenerator;

public class Application {
    public static void main(String[] args) {
        LottoClient lottoClient = new LottoClient(
                new PurchaseService(new RandomLottoGenerator(new RandomNumbersGenerator())),
                new UserLottoInput(),
                new ConsoleLottoOutput(),
                new ProfitCalculator()
        );

        lottoClient.startLottery();
    }
}
