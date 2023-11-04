package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import util.ConstantOfLotto;

public class LottoNumberGenerator {
    private static final int minimumNumber = ConstantOfLotto.minimumOfLottoNumber;
    private static final int maximumNumber = ConstantOfLotto.maximumOfLottoNumber;
    private static final int numOfLottoNumber = ConstantOfLotto.numberOfLottoNumbers;

    public List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(minimumNumber,maximumNumber,numOfLottoNumber);
    }
}
