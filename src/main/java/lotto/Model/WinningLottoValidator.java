package lotto.Model;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLottoValidator {
    private Lotto lotto;

    public WinningLottoValidator(String inputWinningLotto) {
        validate(inputWinningLotto);
         this.lotto = new Lotto(Stream.of(inputWinningLotto.split(","))
                 .map(Integer::parseInt)
                 .collect(Collectors.toList()));
    }

    public Lotto getWinningLotto() {
        return lotto;
    }

    private void validate(String inputWinningLotto) {
        if (inputWinningLotto.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException();
        }
    }
}
