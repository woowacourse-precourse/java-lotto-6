package lotto.model;

import static lotto.constant.ErrorMessage.CONTAINING_OTHER_THAN_NUMBER;
import static lotto.constant.ErrorMessage.NOT_IN_LOTTO_NUMBER_RANGE;
import static lotto.constant.LottoNumber.RANGE;
import static lotto.constant.StringPattern.NUMBER_PATTERN;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int quantity) {
        return new Lottos(
                IntStream.range(0, quantity)
                        .mapToObj(index -> Lotto.create())
                        .collect(Collectors.toList())
        );
    }

    private void validateBonusNumber(String inputBonusNumber) {
        if (NUMBER_PATTERN.isNotMatching(inputBonusNumber)) {
            throw new IllegalArgumentException(CONTAINING_OTHER_THAN_NUMBER.getMessage());
        }
    }

    private void validateNumberInLottoNumberRange(int inputBonusNumber) {
        if (RANGE.notInclude(inputBonusNumber)) {
            throw new IllegalArgumentException(NOT_IN_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Lotto> getLotto() {
        return lottos;
    }
}
