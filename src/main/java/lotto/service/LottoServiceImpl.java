package lotto.service;

import static java.util.Collections.nCopies;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MAX_SCORE;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoServiceImpl implements LottoService{
    private static final int START = 0;
    private final static int INIT = 0;

    @Override
    public List<List<Integer>> buyLotto() {
        int quantity = payMoney();
        List<List<Integer>> myLottoNumbers = getMyLotto(quantity);

        OutputView outputView = new OutputView();
        outputView.printLotto(quantity, myLottoNumbers);

        return myLottoNumbers;
    }

    @Override
    public List<Integer> getResult(List<List<Integer>> myLottoNumbers, List<Integer> numbers, int bonusNumber) {
        Lotto lotto = new Lotto(numbers);
        List<Integer> statistics = new ArrayList<>(nCopies(MAX_SCORE.getValue() + 1, INIT));

        for (List<Integer> myLottoNumber : myLottoNumbers) {
            int sameCount = lotto.getSameNumberCount(myLottoNumber);
            int score = getScore(bonusNumber, myLottoNumber, sameCount);
            statistics.set(score, statistics.get(score) + 1);
        }

        return statistics;
    }

    private int getScore(int bonusNumber, List<Integer> myLottoNumber, int sameCount) {
        int score = sameCount;

        if (hasBonusNumber(bonusNumber, myLottoNumber) && score == 5 || score == 6) {
            score++;
        }

        return score;
    }

    private Boolean hasBonusNumber(int bonusNumber, List<Integer> myLottoNumber) {
        if (myLottoNumber.contains(bonusNumber)) {//보너스 볼 일치
            return true;
        }

        return false;
    }


    private int payMoney() {
        InputView inputView = new InputView();
        Cost cost = new Cost(inputView.inputBuyingCost());

        return cost.getQuantity();
    }

    private List<List<Integer>> getMyLotto(int quantity){
        return IntStream.range(START, quantity)
                .mapToObj(q -> generateLottoNumber())
                .toList();
    }

    private List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), LOTTO_SIZE.getValue());
    }

}
