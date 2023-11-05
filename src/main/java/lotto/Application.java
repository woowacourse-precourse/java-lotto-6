package lotto;

import lotto.lotto.LottoNumberGenerator;
import lotto.lotto.LottoSimulator;
import lotto.lotto.RandomLottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        LottoSimulator lottoSimulator = new LottoSimulator(lottoNumberGenerator);
        lottoSimulator.start();
    }
}
