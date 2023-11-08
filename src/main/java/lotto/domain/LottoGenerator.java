package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public List<List<Integer>> issueLottoAsManyAsPurchased(long purchaseQuantity) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (long i = 0; i < purchaseQuantity; i++) {
            lottoNumbers.add(this.issueLotto());
        }
        return lottoNumbers;
    }

    private List<Integer> issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
