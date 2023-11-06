package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    public static List<Integer> generateRandomLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < 6) {
            int randomNumber = (int) (Math.random() * 45) + 1;
            if (!lottoNumbers.contains(randomNumber)) {
                lottoNumbers.add(randomNumber);
            }
        }
        return lottoNumbers;
    }
}
