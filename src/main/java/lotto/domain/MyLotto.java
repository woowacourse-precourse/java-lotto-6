package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class MyLotto {
    private static final int START = 0;
    private final List<Lotto> myLottos;
    public MyLotto(int quantity) {
        this.myLottos = IntStream.range(START, quantity)
                .mapToObj(q -> generateMyLotto())
                .toList();
    }

    public List<List<Integer>> getMyLottoNumbers() {
        return myLottos.stream()
                .map(m -> m.getNumbers())
                .toList();
    }

    private Lotto generateMyLotto() {
        Lotto lotto = new Lotto(generateLottoNumber());
        return lotto;
    }

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }
}
