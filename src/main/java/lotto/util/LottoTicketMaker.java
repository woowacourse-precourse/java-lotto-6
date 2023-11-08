package lotto.util;

import static lotto.config.SystemNumberConfig.RANDOM_END;
import static lotto.config.SystemNumberConfig.RANDOM_START;
import static lotto.config.SystemNumberConfig.SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.OutputView;

public class LottoTicketMaker {
    public List<Lotto> make(int purchasedCount) {
        List<Lotto> lottoTicket = new ArrayList<>();
        for (int count = 0; count < purchasedCount; count++) {
            lottoTicket.add(makeLotto());
        }
        return lottoTicket;
    }

    private Lotto makeLotto() {
        try {
            return new Lotto(
                    makeRandomUniqueNumber(RANDOM_START.getConfig(), RANDOM_END.getConfig(), SIZE.getConfig()));
        } catch (IllegalStateException exception) {
            OutputView.println(exception.getMessage());
            return makeLotto();
        }

    }

    private List<Integer> makeRandomUniqueNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
