package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public int inputPurchaseAmount = 0;
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputPurchaseAmount = Integer.parseInt(Console.readLine());
        validateInputPurchaseAmount(inputPurchaseAmount);
        return inputPurchaseAmount;
    }

    public void validateInputPurchaseAmount(int inputPurchaseAmount){
        if (inputPurchaseAmount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    public int calculateRound(int inputPurchaseAmount) {
        int round = inputPurchaseAmount / 1000;
        return round;
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
