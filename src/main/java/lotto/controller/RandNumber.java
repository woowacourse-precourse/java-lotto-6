package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandNumber {
    public static List<Integer> randomLottoNumber(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return numbers;
    }
}
