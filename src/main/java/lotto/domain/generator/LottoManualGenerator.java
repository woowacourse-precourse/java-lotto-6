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
        } catch (NumberFormatException | LottoException exception) {
            throw new LottoException(LottoException.ErrorMessage.RANGE_LOTTO_NUMBER.getMessage());
        }
    }
}
