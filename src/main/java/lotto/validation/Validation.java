package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validation {

    public static void validateDuplicationList(List<Integer> list) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(list);
        if (list.size() != nonDuplicateNumbers.size()) {
            //Message 출력
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateSize(List<Integer> list, int length) {
        if (list.size() != length) {
            //Message 출력
            throw new IllegalArgumentException("로또 번호는 6개가 필요합니다.");
        }
    }
}
