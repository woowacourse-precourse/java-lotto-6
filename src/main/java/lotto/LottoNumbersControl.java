package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbersControl {
    int lottoCount;
    List<List<Integer>> allLottoNumbers = new ArrayList<>();

    public LottoNumbersControl() {

    }

    public int getLottoCount(int price) {
        lottoCount = price / 1000;

        return lottoCount;
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);

        return numbers;
    }

    public void getAllLottoNumbers() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumbers = getLottoNumbers();
            allLottoNumbers.add(lottoNumbers);
        }
    }
}
