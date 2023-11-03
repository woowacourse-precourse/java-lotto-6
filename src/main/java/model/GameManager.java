package model;

import java.util.List;
import model.dto.LottoResponse;
import model.dto.AnswerBonusNumber;
import model.dto.AnswerLottoNumbers;

public class GameManager {

    private final LottosWithBonus lottos;
    private LottoWithBonus answerLotto;

    private GameManager(final LottosWithBonus lottos) {
        this.lottos = lottos;
    }

    public static GameManager createDefault(final int lottoCount) {
        return new GameManager(LottosWithBonus.createAsManyAsCount(lottoCount));
    }

    public List<LottoResponse> getGeneratedLottos() {
        return lottos.getLottos()
            .stream()
            .map(LottoResponse::from)
            .toList();
    }

    public void generateAnswerLotto(final AnswerLottoNumbers answerNumbers,
        final AnswerBonusNumber answerBonusNumber) {
        answerLotto = new LottoWithBonus(answerNumbers.toLotto(),
            answerBonusNumber.toLottoNumber());
    }

    public LottoTotalResult calculateResult () {
        List<LottoCompareResult> results=lottos.compareAnswerLotto(answerLotto);
        LottoTotalResult totalResult = LottoTotalResult.createDefault();

        results.forEach(totalResult::reflectCompareResult);

        return totalResult;
    }
}
