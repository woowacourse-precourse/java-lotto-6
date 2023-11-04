package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssuedLotto {
    private final List<List<Integer>> IssuedLotto = new ArrayList<>();

    private int countLotto() {
        int money = Input.inputMoneyMessage();
        return money % 1000;
    }

    private List<List<Integer>> makeLottoBundle() {
        int count = countLotto();
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(lotto);
            List<Integer> oneLotto = new ArrayList<>(lotto);
            IssuedLotto.add(oneLotto);
        }
        return IssuedLotto;
    }

    public List<List<Integer>> lottoTickets() {
        return makeLottoBundle();
    }

    public void showLottoTickets() {
        int count = countLotto();
        System.out.println("\n" + count + "개를 구매했습니다.");
        System.out.println(IssuedLotto);
    }
}
