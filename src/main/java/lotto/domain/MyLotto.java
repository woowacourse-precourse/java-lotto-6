package lotto.domain;

import static java.util.Collections.nCopies;
import static lotto.constant.CostConstant.UNIT;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MAX_SCORE;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.view.OutputView;

public class MyLotto {
    private static final int START = 0;
    private final static int INIT = 0;

    private final int quantity;
    private final List<Lotto> myLottos;
    public MyLotto(int quantity) {
        this.quantity = quantity;
        this.myLottos = IntStream.range(START, quantity)
                .mapToObj(q -> generateMyLotto())
                .toList();
    }
    public void printGenerateLottoResult() {
        OutputView outputView = new OutputView();
        outputView.printLotto(quantity, getMyLottoNumbers());
    }

    public void checkResult(WinningLotto winningLotto) {
        OutputView outputView = new OutputView();
        Result result = new Result(getStatistics(winningLotto));

        List<Integer> statistics = result.getStatistics();
        float profitability = result.getProfitability(quantity);

        outputView.printStatistics(statistics);
        outputView.printProfitability(profitability);
    }

    private List<List<Integer>> getMyLottoNumbers() {
        return myLottos.stream()
                .map(m -> m.getNumbers())
                .toList();
    }

    private List<Integer> getStatistics(WinningLotto winningLotto) {
        List<Integer> statistics = new ArrayList<>(nCopies(MAX_SCORE.getValue() + 1, INIT));

        for (Lotto myLotto : myLottos) {
            int score = winningLotto.getScore(myLotto);
            statistics.set(score, statistics.get(score) + 1);
        }

        return statistics;
    }

    private int getQuantity(int cost) {
        return cost / UNIT.getValue();
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
