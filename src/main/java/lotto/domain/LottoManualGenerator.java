package lotto.domain;

import lotto.exception.LottoException;
import lotto.vo.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoManualGenerator {
    public Lotto generate(List<String> list) throws LottoException {
        try {
            Set<LottoNumber> uniqueNumbers = list.stream()
                    .map(number -> new LottoNumber(Integer.valueOf(number)))
                    .collect(Collectors.toSet());
            return new Lotto(new ArrayList<>(uniqueNumbers));
        } catch (NumberFormatException exception) {
            throw new LottoException("숫자를 입력해 주세요");
        }
    }
}
