package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
    private final LottoValidator validator = new LottoValidator();
    private final Lotto winningLotto;

    private int bonusNumber = 0;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void addBonusNumber(String number) {
        int bonusNumber = Integer.parseInt(number);
        validator.validateNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String lotto) {
        List<Integer> numbers = createLottos(lotto);
        validator.validateNumbersRange(numbers);
        winningLotto = new Lotto(numbers);
    }

    private List<Integer> createLottos(String lotto) {
        return Stream.of(lotto.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }
}
