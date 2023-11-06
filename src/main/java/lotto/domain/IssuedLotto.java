package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssuedLotto {

    private List<List<Integer>> lottoBundle;

    private int countLotto() {
        int money = Input.getMoney();
        return money / 1000;
    }

    private List<List<Integer>> makeLottoBundle(int count) {
        lottoBundle = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            //Collections.sort(lotto);
            List<Integer> oneLotto = new ArrayList<>(lotto);
            lottoBundle.add(oneLotto);
        }
        return lottoBundle;
    }

    public List<List<Integer>> showLottoTickets() {
        int count = countLotto();
        lottoBundle = makeLottoBundle(count);
        lottoBundle.forEach(Collections::sort);
        //List<List<Integer>> lottoTickets = makeLottoBundle(count);
        System.out.println("\n" + count + "개를 구매했습니다.");
        return lottoBundle;
    }

    public List<List<Integer>> getLottoBundle() {
        return lottoBundle;
    }
}
