package lotto.util;

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
            return new Lotto(makeRandomUniqueNumber(1, 45, 6));
        } catch (IllegalStateException exception) {
            OutputView.print(exception.getMessage());
            OutputView.print("\n");
            return makeLotto();
        }

    }

    private List<Integer> makeRandomUniqueNumber(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
