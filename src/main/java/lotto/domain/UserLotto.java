package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private static final String PURCHASE_PRICE_ERROR_MESSAGE = "[ERROR] 구입 금액은 " + LottoInfo.LOTTO_PRICE+ "원 단위로 입력해야 합니다.";
    private final List<Lotto> lottos = new ArrayList<>();
    private final int purchasePrice;
    private final int lottoCount;
    private final NumberGenerator numberGenerator = NumberGenerator.getInstance();

    public UserLotto(int purchasePrice) {
        validate(purchasePrice);
        this.purchasePrice = purchasePrice;
        this.lottoCount = purchasePrice / LottoInfo.LOTTO_PRICE;
        generateLottos(lottoCount);
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % LottoInfo.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_PRICE_ERROR_MESSAGE);
        }
    }

    private void generateLottos(int lottoCount) {
        while (lottos.size() < lottoCount) {
            lottos.add(new Lotto(numberGenerator.generateRandomNumbers()));
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
