package lotto.util.matcher;

import java.util.List;

public interface NumbersMatcher {
    // 두 리스트를 서로 비교하여 몇 개의 숫자가 일치하는지 반환합니다.
    int matches(List<Integer> numbers, List<Integer> target);
}
