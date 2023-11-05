package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.util.SortedRandomNumberGenerator;
import lotto.view.InputView;

public class Application {
    LottoGenerator lottoGenerator = new LottoGenerator(new SortedRandomNumberGenerator());
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.play();
    }
}
