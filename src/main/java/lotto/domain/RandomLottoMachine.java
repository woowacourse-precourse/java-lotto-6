package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomLottoMachine {
    //동 -> 횟수
    //랜덤 생성
    //저ㅑㅜ

    private int purchasedLottoCount;

    public RandomLottoMachine(int purchasedLottoCount) {
        this.purchasedLottoCount = purchasedLottoCount;
    }

    public List<List<Integer>> getRandomLottoList(){
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for(int i = 0; i<purchasedLottoCount; i++){
            randomNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return randomNumbers;
    }

}
