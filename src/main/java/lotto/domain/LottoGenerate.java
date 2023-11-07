package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerate {
    public LottoGenerate(){

    }
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    public static List<List<Integer>> generateLottoNumbers(int amount){
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for(int i = 0; i < amount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_COUNT);
            Collections.sort(lottoNumbers);
            lottoNumbersList.add(lottoNumbers);
        }
        return lottoNumbersList;
    }
}
