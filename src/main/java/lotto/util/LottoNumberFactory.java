package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.util.GameConstant.*;

// 로또 번호를 생성하기 위한 클래스
public class LottoNumberFactory implements NumberFactory {
    @Override
    public List<Integer> getNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                CONSTANT_LOTTO_MIN_NUMBER.getConstant(),
                CONSTANT_LOTTO_MAX_NUMBER.getConstant(),
                CONSTANT_LOTTO_LENGTH.getConstant());

        return randomNumbers.stream().sorted().toList();
    }
}
