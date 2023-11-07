package lotto;

import static lotto.constants.ConstantValues.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class LottoMaker {

    // HashSet의 요소들을 정렬하여 Lotto로 만들어 반환
    public static Lotto makeLotto() {
        HashSet<Integer> lottoNumbers = makeLottoSet();
        List<Integer> LottoNumbers = List.copyOf(lottoNumbers);
        List<Integer> sortedLottoNumbers = LottoNumbers.stream().sorted().toList();
        return new Lotto(sortedLottoNumbers);
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
