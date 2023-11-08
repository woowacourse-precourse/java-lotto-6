package lotto;

import static lotto.Enum.Number.LOTTO_SIZE;
import static lotto.Enum.Number.MAX_LOTTO_NUMBER;
import static lotto.Enum.Number.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
    private static List<Integer> createRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getNumber(), MAX_LOTTO_NUMBER.getNumber(), LOTTO_SIZE.getNumber());
    }

    public static List<Lotto> publishLotto(int lottoSize) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoSize; i++) {
            Lotto lotto = new Lotto(createRandomLottoNumber());
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }

    public static void printLotto(List<Lotto> lottoNumbers) {
        for (Lotto lotto : lottoNumbers) {
            System.out.println(lotto.toString());
        }
    }
}
