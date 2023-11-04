package lotto.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberValidation {

    public void validateDuplicateLottoNumbers(List<Integer> lottoNumbers) {
        Set<Integer> numbers = new HashSet<>();

        for (Integer number : lottoNumbers) {
            numbers.add(number);
        }

        if (lottoNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 로또 번호가 있습니다.");
        }
    }
}
