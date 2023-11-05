package lotto.model;

import static lotto.util.Constant.LOTTO_MINIMUM_NUMBER;
import static lotto.util.Constant.LOTTO_MAXIMUM_NUMBER;
import static lotto.util.Constant.LOTTO_WINNING_NUMBER_LENGTH;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class LottoMaker {
    public List<Integer> getLotto() { // 로또 만들기
        return Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_WINNING_NUMBER_LENGTH);
    }
}
