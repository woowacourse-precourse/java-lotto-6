package lotto.domain;

import static java.util.Collections.nCopies;
import static java.util.Collections.sort;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MAX_SCORE;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
public class MyLotto {
    private static final int START = 0;
    private static final int INIT = 0;

    private final int quantity;
    private final List<Lotto> myLottos;
    public MyLotto(int quantity) {
        this.quantity = quantity;
        this.myLottos = IntStream.range(START, quantity)
                .mapToObj(q -> generateMyLotto())
                .toList();
    }
    public List<Integer> getStatistics(WinningLotto winningLotto) {
        return calculateStatistics(winningLotto);
    }

    public List<List<Integer>> getMyLottoNumbersWithSorting() {
        return myLottos.stream()
                .map(Lotto::getSortedNumbers)
                .toList();
    }

    private List<Integer> calculateStatistics(WinningLotto winningLotto) {
        List<Integer> statistics = new ArrayList<>(nCopies(MAX_SCORE.getValue() + 1, INIT));

        for (Lotto myLotto : myLottos) {
            int score = winningLotto.getScore(myLotto);
            statistics.set(score, statistics.get(score) + 1);
        }

        return statistics;
    }

    private Lotto generateMyLotto() {
        return new Lotto(generateLottoNumber());
    }

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }

}
