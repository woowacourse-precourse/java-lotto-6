package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {
    // TODO: 랜덤 숫자를 생성하고 중복 여부 확인하는 클래스
    public static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static boolean isUniqueNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .distinct()
                .toList().size() == 6;
    }
}
