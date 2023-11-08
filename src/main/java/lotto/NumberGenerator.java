package lotto;

import java.util.Comparator;
import java.util.List;

public class NumberGenerator {
    private Lotto lottoNumbers;

    public void generateLottoNumbers() {
        lottoNumbers = new Lotto(camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lottoNumbers.getNumbers().sort(Comparator.naturalOrder()); // 리스트를 오름차 순으로 정렬
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }

    public Lotto getLotto(){
        return lottoNumbers;
    }

}
