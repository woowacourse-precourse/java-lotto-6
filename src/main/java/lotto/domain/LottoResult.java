package lotto.domain;

import java.util.StringJoiner;
import lotto.config.Message;

public class LottoResult {

    private final StringJoiner lottoResultMaker = new StringJoiner(Message.NEW_LINE);

    public void addLotto(Lotto lotto) {
        lotto.addedToResult(lottoResultMaker);
    }

    public String getLottoResult() {
        return lottoResultMaker.toString();
    }
}
