package lotto.domain.number;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.utils.Constants.*;

// 1. 랜덤넘버 생성 전략
public class RandomNumberStrategy implements NumberStrategy{

    @Override
    public Lotto generateNumber() {
        // List<Integer>는 인터페이스이기 때문에 sort()시 예외 발생 확률 있음 -> 구현체인 ArrayList<> 인스턴스 생성
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT));
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers); // generate 시 Lotto 생성 -> 생성자의 validate 과정 all clear
    }
}
