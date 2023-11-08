package lotto.output;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.PurchaseMoneyInPut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CreateLottoNumber {
    static final int COUNT_STANDARD = 1000;
    static final String PURCHASE_COUNT = "개를 구매 했습니다.";
    static final int LOTTO_NUMBER_COUNT = 6;
    static final int MIN_NUM = 1;
    static final int MAX_NUM = 45;

    public static int LottoCount() {
        int lottoCount = PurchaseMoneyInPut.purchaseMoney();
        int result = lottoCount / COUNT_STANDARD;
        System.out.println(result + PURCHASE_COUNT);
        return result;
    }

    public static List<List<Integer>> createLottoNumbers() {

        int purchaseCount = LottoCount();
        HashSet<Integer> randomNumbers = new HashSet<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            while (randomNumbers.size() < LOTTO_NUMBER_COUNT) {
                int randomNum = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
                randomNumbers.add(randomNum);
            }
            List<Integer> randomNumbersList = new ArrayList<>(randomNumbers);
            Collections.sort(randomNumbersList); // 오름차순 정렬
            System.out.println(randomNumbersList);
            result.add(randomNumbersList);
            randomNumbers.clear();
        }
        return result;
    }
}



