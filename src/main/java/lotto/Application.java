package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        List<Lotto> lottos = lottoManager.buyLotto();
        lottoManager.inputWinningNumbersAndBonusNumber();
        lottoManager.getWinningStatus(lottos);
    }
}
