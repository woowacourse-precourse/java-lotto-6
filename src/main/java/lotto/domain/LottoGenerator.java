package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.vo.Lotto;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_LEN = 6;

    public static List<Lotto> generateLottoList(int lottoCount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            //랜덤 값 자동 생성 및 세팅
            list.add(new Lotto(getRandomNumList()));
        }
        return list;
    }

    private static List<Integer> getRandomNumList() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LEN);
        return sort(list);
    }

    private static List<Integer> sort(List<Integer> list) {
        // ApplicationTest 에서 테스트할 때 immutable list 를 넘겨줄 때가 있어서 mutable list 로 만들어줌
        List<Integer> copiedList = new ArrayList<>(list);
        Collections.sort(copiedList);
        return copiedList;
    }
}