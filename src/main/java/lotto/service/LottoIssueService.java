package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.util.ErrorMessages;

public class LottoIssueService {

    public Lottos issueLottos(int issueCount) {
        validateIssueCount(issueCount);
        return new Lottos(issueRandomLottoNumberByCount(issueCount));
    }

    private void validateIssueCount(int issueCount) {
        if (issueCount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.ISSUE_COUNT_ERROR.getMessage());
        }
    }

    private List<Lotto> issueRandomLottoNumberByCount(int issueCount) {
        List<Lotto> issuedLottosNumber = new ArrayList<>();
        for (int i = 0; i < issueCount; i++) {
            issuedLottosNumber.add(new Lotto(makeRandomLottoNumbers()));
        }
        return issuedLottosNumber;
    }

    private List<Integer> makeRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }


    public Lotto issueWinningLotto(List<Integer> winningNumber) {
        return new Lotto(winningNumber);
    }
}
