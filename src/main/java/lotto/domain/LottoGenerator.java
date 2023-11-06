package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

/* 로또 번호 랜덤 생성기
* */
public class LottoGenerator {
    private int MINIMUM_LOTTO_NUMBER = 1;
    private int MAX_LOTTO_NUMBER = 45;
    private int LOTTO_COUNT = 6;

    public Lotto generateNumber() {
        return new Lotto(generateLotto());
    }

    private List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT);
    }
}
