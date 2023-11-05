package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public void inputPurchaseAmount() {

    }

    public void createLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomNumbers);
        for (Integer randomSortNumber : randomNumbers) {
            System.out.print(randomSortNumber + ",");
        }

    }
    public void inputLuckyNumbers() {

    }
    public void inputBonusNumber() {

    }
}
