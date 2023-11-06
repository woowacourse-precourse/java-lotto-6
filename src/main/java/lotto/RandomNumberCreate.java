package lotto;

import java.util.List;
import java.util.Collections;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberCreate {

    private final int lottoQuantity;

    public RandomNumberCreate(int lottoQuantity){
        this.lottoQuantity = lottoQuantity;
    }

    public void createRandomNumber(int lottoQuantity){
        // 랜덤으로 생성해서 sortNumber에 넘기기
        List<Integer> randomNumbers;
        List<Integer> sortedNumber;
        Judging judging = new Judging();

        for (int i = 0; i < lottoQuantity; i++) {
            randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sortedNumber = sortNumber(randomNumbers);
            judging.judging(sortedNumber);
        }
    }

    public List<Integer> sortNumber(List<Integer> randomNumber){
        // sort해서 createRandomNumber에 다시 주기
        Collections.sort(randomNumber);
        return randomNumber;
    }
}
