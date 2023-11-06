package lotto.domain.userLotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private final List<Lotto> lottos = new ArrayList<>();
    private final PurchasePrice purchasePrice;
    private final LottoAmount lottoAmount;
    private final NumberGenerator numberGenerator = NumberGenerator.getInstance();

    public UserLotto(int purchasePrice) {
        this.purchasePrice = new PurchasePrice(purchasePrice);
        this.lottoAmount = new LottoAmount(purchasePrice);
        generateLottos();
    }

    private void generateLottos() {
        while (lottos.size() < lottoAmount.getLottoAmount()) {
            lottos.add(new Lotto(numberGenerator.generateRandomNumbers()));
        }
    }

    public WinningResult calculateWinningResult(AnswerLotto answerLotto) {
        List<Ranking> rankingResult = lottos.stream()
                .map(lotto -> answerLotto.calculateWinningResult(lotto))
                .toList();
        return new WinningResult(rankingResult, purchasePrice.getPurchasePrice());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
