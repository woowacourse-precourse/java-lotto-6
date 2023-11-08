package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class WinningLotto {
    private static final String DELIMITER = ",";

    private final LottoValidator validator = new LottoValidator();
    private final Lotto winningLotto;

    private int bonusNumber = 0;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void addBonusNumber(String number) {
        validator.validateWholeNumber(number);
        int bonusNumber = Integer.parseInt(number);
        validator.validateNumberRange(bonusNumber);
        validator.validateContains(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String lotto) {
        List<Integer> numbers = createLottos(lotto);
        validator.validateNumbersRange(numbers);
        winningLotto = new Lotto(numbers);
    }

    private List<Integer> createLottos(String lotto) {
        return Stream.of(lotto.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    public int getNumber(int index) {
        return winningLotto.getNumber(index);
    }
}
