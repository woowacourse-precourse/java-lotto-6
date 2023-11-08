package lotto;

import java.util.Comparator;
import java.util.List;

public class NumberGenerator {
    private Lotto lottoNumbers;

    public void generateLottoNumbers() {
        lottoNumbers = new Lotto(camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6));
        lottoNumbers.getNumbers().sort(Comparator.naturalOrder()); // 리스트를 오름차 순으로 정렬
    }

    // 구입 금액에 해당하는 만큼 로또를 발행하는 메서드
    public static void generateLottos(int purchaseAmount, NumberGenerator[] purchaseNumbers) {
        for (int i = 0; i < purchaseAmount; i++) {
            purchaseNumbers[i] = new NumberGenerator();
            purchaseNumbers[i].generateLottoNumbers();
            System.out.println(purchaseNumbers[i].getLottoNumbers());
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }

    public Lotto getLotto(){
        return lottoNumbers;
    }

}
