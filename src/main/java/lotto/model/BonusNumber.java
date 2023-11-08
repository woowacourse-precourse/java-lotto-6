package lotto.model;
import static lotto.PlayLottoGame.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BonusNumber {
    private final List<Integer> bonusNumber;

    public BonusNumber(String bonusNumber){
        String validateNumber = validator.validateBonusNumber(bonusNumber);
        this.bonusNumber = Arrays.stream(validateNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getBonusNumber() {
        return bonusNumber;
    }
}
