package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.vo.Lotto;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final int LOTTO_LEN = 6;

    public static List<Lotto> generateLottoes(BigDecimal lottoCount) {
        List<Lotto> lottoes = new ArrayList<>();
        for (BigDecimal i = BigDecimal.ZERO; i.compareTo(lottoCount) < 0; i = i.add(BigDecimal.ONE)) {
            lottoes.add(new Lotto(getRandomNumbers()));
        }
        return lottoes;
    }

    private static List<Integer> getRandomNumbers() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUM, LOTTO_MAX_NUM, LOTTO_LEN);
        return sort(list);
    }

    private static List<Integer> sort(List<Integer> numbers) {
        // ApplicationTest 에서 테스트할 때 immutable numbers 를 넘겨줄 때가 있어서 mutable numbers 로 만들어줌
        List<Integer> copiedList = new ArrayList<>(numbers);
        Collections.sort(copiedList);
        return copiedList;
    }
}