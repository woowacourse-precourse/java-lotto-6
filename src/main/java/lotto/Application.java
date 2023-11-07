package lotto;

import lotto.lottoGame.LottoComparator;
import lotto.lottoGame.LottoGame;
import lotto.lottoGame.LottoInputGenerator;
import lotto.lottoGame.LottoRandomGenerator;
import lotto.lottoGame.ResultCalculrator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoRandomGenerator lottoRandomGenerator = new LottoRandomGenerator();
        LottoInputGenerator lottoInputGenerator = new LottoInputGenerator();
        LottoComparator lottoComparator = new LottoComparator();
        ResultCalculrator resultCalculrator = new ResultCalculrator();

        LottoGame lottoGame = new LottoGame(lottoRandomGenerator, lottoInputGenerator, lottoComparator,
            resultCalculrator);

        lottoGame.run();
    }
}
