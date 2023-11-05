package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoIssueService {

    public List<Lotto> issueLottos(int issueCount) {
        validateIssueCount(issueCount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            lottos.add(new Lotto(getLottoNumbers()));
        }
        return lottos;
    }

    private void validateIssueCount(int issueCount) {
        if (issueCount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
