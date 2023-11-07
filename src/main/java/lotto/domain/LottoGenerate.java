package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerate {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    public static List<Lotto> generateLottoNumbers(int amount){
        List<Lotto> lottoNumbersList = new ArrayList<>();
        while (lottoNumbersList.size() < amount) {
            lottoNumbersList.add(generateLotto());
        }
        return lottoNumbersList;
    }
    public static Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }
    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
    }
}
