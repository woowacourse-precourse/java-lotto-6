package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public void inputPurchaseAmount() {

    }

    public void createLottoNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        int randomNumberSize = randomNumbers.size();
        Integer[] lottoNumbers = randomNumbers.toArray(new Integer[randomNumberSize]);
        Arrays.sort(lottoNumbers);
        System.out.println(Arrays.toString(lottoNumbers));
    }
    public void inputLuckyNumbers() {

    }
    public void inputBonusNumber() {

    }
}
