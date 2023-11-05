package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private static final String PURCHASE_PRICE_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    private final List<Lotto> lottos = new ArrayList<>();
    private final int purchasePrice;
    private final int lottoCount;

    public UserLotto(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
        this.lottoCount = purchasePrice / 1000;
        generateLottos(lottoCount);
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ERROR_MESSAGE);
        }
    }

    private void generateLottos(int lottoCount) {
        while (lottos.size() < lottoCount) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningResult calculateWinningResult(AnswerLotto answerLotto) {
        List<Ranking> rankingResult = lottos.stream()
                .map(lotto -> answerLotto.calculateWinningResult(lotto))
                .toList();
        return new WinningResult(rankingResult, purchasePrice);
    }
}
