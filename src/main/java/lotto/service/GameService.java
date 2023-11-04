package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class GameService {

    /**
     * 2. 구매 가능한 로또 개수만큼 로또 자동 발급기능
     */
    public List<Lotto> generateLottoList(int lottoCount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            //랜덤 값 자동 생성 및 세팅
            list.add(new Lotto(getRandomNumList()));
        }
        return list;
    }

    static private List<Integer> getRandomNumList() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortRandomNumList(list); //정렬 시키기
        return list;
    }

    static private void sortRandomNumList(List<Integer> list) {
        Collections.sort(list);
    }
}
