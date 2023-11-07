package model;

import java.util.List;
import model.dto.LottoResponse;

public class GameManager {

    private final LottosWithBonus lottos;
    private LottoWithBonus answerLotto;

    private GameManager(final LottosWithBonus lottos) {
        this.lottos = lottos;
    }

    public static GameManager from(final int lottoCount) {
        return new GameManager(LottosWithBonus.createAsManyAsCount(lottoCount));
    }

    public List<LottoResponse> generateLottos() {
        return lottos.getLottos()
            .stream()
            .map(LottoResponse::from)
            .toList();
    }

    public void generateAnswerLotto(final List<Integer> answerNumbers,
        final int answerBonusNumber) {
        answerLotto = new LottoWithBonus(new Lotto(answerNumbers),
            LottoNumber.from(answerBonusNumber));
    }

    public LottoTotalResult calculateResult() {
        List<LottoCompareResult> results = lottos.compareAnswerLotto(answerLotto);
        LottoTotalResult totalResult = LottoTotalResult.createDefault();

        results.forEach(totalResult::reflectCompareResult);

        return totalResult;
    }
}
