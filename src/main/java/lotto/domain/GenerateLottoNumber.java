package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateLottoNumber {

    /**
     * 1. 1~45 범위 내에서 총 6개의 랜덤 숫자를 입력 받는다
     * 2. 오름차순 정렬을 진행 후, 정렬된 리스트를 반환
     */
    public List<Integer> selectNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numberSorted = new ArrayList<>(numbers);
        Collections.sort(numberSorted);
        return numberSorted;
    }

}
