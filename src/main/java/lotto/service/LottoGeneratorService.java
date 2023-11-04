package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class LottoGeneratorService {

    private static final int MIN_RANDOMNUMBER = 1;
    private static final int MAX_RANDOMNUMBER = 45;
    private static final int MAX_LOTTO_NUMBER_SIZE = 6;

    public Lotto createLotto() {
        List<Integer> numbers = new ArrayList<>(generateLottoNumbers());
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    private Set<Integer> generateLottoNumbers() {
        Set<Integer> numbers = new HashSet<>();
        do {
            numbers.add(Randoms.pickNumberInRange(MIN_RANDOMNUMBER, MAX_RANDOMNUMBER));
        } while (!(numbers.size() == MAX_LOTTO_NUMBER_SIZE));
        return numbers;
    }
}
