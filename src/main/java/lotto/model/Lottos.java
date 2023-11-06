package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.GameConfig;
import lotto.view.OutputView;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.buyLotto(GameConfig.LOTTO_PRICE.getValue());
        generateLottos(count);
    }

    public WinningResult calculateWinningResult(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.calculateLottoRank(winningLotto);
            winningResult.addLottoRank(lottoRank);
        }

        return winningResult;
    }

    public void displayLottos() {
        lottos.forEach(Lotto::displayLottoNumbers);
        OutputView.printNewLine();
    }

    private void generateLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                GameConfig.MIN_LOTTO_NUMBER.getValue(),
                GameConfig.MAX_LOTTO_NUMBER.getValue(),
                GameConfig.WINNING_NUMBERS_COUNT.getValue());
    }
}
