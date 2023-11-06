package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import util.ConstantOfLotto;

public class LottoNumberGenerator {
    private static final int minimumNumber = ConstantOfLotto.MINIMUM_OF_LOTTO_NUMBER;
    private static final int maximumNumber = ConstantOfLotto.MAXIMUM_OF_LOTTO_NUMBER;
    private static final int numOfLottoNumber = ConstantOfLotto.NUMBER_OF_LOTTO_NUMBERS;

    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(minimumNumber,maximumNumber,numOfLottoNumber);
    }
}
