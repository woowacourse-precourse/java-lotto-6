package lotto.domain;

import java.util.List;
import java.util.StringJoiner;
import lotto.config.Message;

public class LottoResult {

    private final StringJoiner lottoResultMaker = new StringJoiner(Message.NEW_LINE);

    public static LottoResult from(List<Lotto> lottos) {
        LottoResult lottoResult = new LottoResult();
        lottos.forEach(lottoResult::addLotto);

        return lottoResult;
    }

    private void addLotto(Lotto lotto) {
        lotto.addedToResult(lottoResultMaker);
    }

    public String getLottoResult() {
        return lottoResultMaker.toString();
    }
}
