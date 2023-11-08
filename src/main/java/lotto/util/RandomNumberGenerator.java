package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 숫자를 만드는 함수가 포함된 클래스.
 */
public class RandomNumberGenerator {

    /**
     * 길이가 count인 어떤 벡터 X = (x_1, x_2, ...)에 대하여
     * X에 속하는 숫자 x가 min <= x <= max를 만족하는 벡터 X를 생성한다.
     * @param min 벡터의 각 요소의 최솟값.
     * @param max 벡터의 각 요소의 최댓값.
     * @param count 벡터의 길이.
     * @return 벡터를 리스트 형식으로 반환한다. 값이 중복된 요소를 허용하지 않는다.
     */
    public static List<Integer> generateMultiple(int min, int max, int count) {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(min, max, count));
    }
}
