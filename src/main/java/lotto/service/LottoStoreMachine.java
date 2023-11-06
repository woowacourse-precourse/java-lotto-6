package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.*;

public class LottoStoreMachine {
    // 로또 발행을 담당할 클래스입니다.
    private List<List<Integer>> purchasedLotto = new ArrayList<>();

    public List<List<Integer>> saleLotto(int numberOfIssues) {
        issuanceOfLotto(numberOfIssues);

        return purchasedLotto;
    }

    private void issuanceOfLotto(int numberOfIssues) {
        for (int i = 0; i < numberOfIssues; i++) {
            List<Integer> lotto = makeLottoNumbers();
            purchasedLotto.add(lotto);
        }
    }

    private List<Integer> makeLottoNumbers() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lotto);

        return lotto;
    }
}
