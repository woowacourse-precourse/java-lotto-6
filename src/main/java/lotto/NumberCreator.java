package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static java.util.Collection.*;

public class NumberCreator {
    private static final int START_LOTTO_NUM = 1;
    private static final int END_LOTTO_NUM = 45;
    private static final int COUNT_LOTTO_NUM = 6;
    private static List<Integer> lottoBallList;

    public List<Integer> randomNumbers() {
        //int[] lottoBall = {1,2,3,4,5,6};
        // 6개의 숫자가 담길때 까지
        // 만약 이미 존재하는 숫자라면 담지 않는다.
        // 만약 존재하지 않는 숫자라면 담는다.
        lottoBallList = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUM, END_LOTTO_NUM, COUNT_LOTTO_NUM);
        List<Integer> numbers = new ArrayList<>(lottoBallList);
        //오름차순 정렬을 위해 sort()메서드를 사용한다.
        Collections.sort(numbers);
        return numbers;
    }
}
