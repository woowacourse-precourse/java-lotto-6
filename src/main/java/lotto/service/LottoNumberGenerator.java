package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

// sout할 때 애시당초 [ ..., ... ] 이런 식으로 표현됨
public class LottoNumberGenerator {
    public List<Integer> numbers;

    public LottoNumberGenerator() {
        // 리스트화 시키기
        List<Integer> sortedNumbers = new ArrayList<>(filterDuplicates());

        // 오름차순 나열
        Collections.sort(sortedNumbers);

        this.numbers = sortedNumbers;
    }

    // 중복 없이 숫자 6개 뽑아내기
    public Set<Integer> filterDuplicates() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 6) {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }

        return numbers;
    }
}
