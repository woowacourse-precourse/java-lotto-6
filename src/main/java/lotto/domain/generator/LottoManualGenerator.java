package lotto.domain.generator;

import lotto.domain.lotto.Lotto;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManualGenerator {
    public Lotto generate(List<String> list) throws LottoException {
        try {
            Set<Integer> uniqueNumbers = list.stream()
                    .map(Integer::valueOf)
                    .collect(Collectors.toSet());
            return new Lotto(new ArrayList<>(uniqueNumbers));
        } catch (NumberFormatException exception) {
            throw new LottoException("숫자를 입력해 주세요");
        }
    }
}
