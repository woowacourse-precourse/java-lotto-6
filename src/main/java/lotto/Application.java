package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Statistician;
import lotto.generator.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop(
                new LottoMachine(new LottoNumberGenerator()), new Statistician());
        lottoShop.runLottoGame();
    }
}
