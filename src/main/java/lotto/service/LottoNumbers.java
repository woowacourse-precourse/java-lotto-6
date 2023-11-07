package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    public LottoNumbers() {
    }

    private static List<Integer> lottoNumberList;

    public static List<Integer> getRandomNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            uniqueNumbers.add(randomNumber);

        }
        List<Integer> lottoNumberList = new ArrayList<>(uniqueNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }
}
