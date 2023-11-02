package lotto.model;

import com.sun.security.auth.NTSidPrimaryGroupPrincipal;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoException.checkNumbersException(numbers);
        this.numbers = numbers;
    }

    public String sortNumbers() {
        return numbers.stream().sorted().map(String::valueOf).reduce((a,b) -> a + ", " + b).orElse("");
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
