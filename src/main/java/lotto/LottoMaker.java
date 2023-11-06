package lotto;

import static lotto.constants.ConstantValues.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class LottoMaker {

    public static Lotto makeLotto() {
        return new Lotto(List.copyOf(makeLottoSet()));
    }

    public static HashSet<Integer> makeLottoSet() {
        HashSet<Integer> lottoNumbers = new HashSet<Integer>();
        while (lottoNumbers.size() < LOTTO_LENGTH.getValue()) {
            lottoNumbers.add(makeLottoNumber());
        }
        return lottoNumbers;
    }

    public static int makeLottoNumber() {
        return Randoms.pickNumberInRange(START_LOTTO_NUMBER.getValue(), END_LOTTO_NUMBER.getValue());
    }

}
