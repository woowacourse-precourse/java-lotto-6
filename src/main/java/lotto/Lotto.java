package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리여야 합니다.");
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() > set.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자입니다.");
        }
    }
    public List<Integer> getlotto(){
        List<Integer> lottonums = new ArrayList<>(numbers);
        Collections.sort(lottonums);
        return lottonums;
    }

    // TODO: 추가 기능 구현
}
