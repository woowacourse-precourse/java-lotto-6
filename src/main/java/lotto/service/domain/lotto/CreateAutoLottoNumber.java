package lotto.service.domain.lotto;

import lotto.service.domain.random.CreateRandomNumber;

import java.util.List;

public class CreateAutoLottoNumber {
    public List<Integer> getLottoSixNumbers() {
        return CreateRandomNumber.getAutoUniqueNumbers(LOTTO_PICK_VALUE_MAX_NUMBER);
    }
    public int getBonusNumber() {
        return CreateRandomNumber.getBonusNumber();
    }
    private static final int LOTTO_PICK_VALUE_MAX_NUMBER = 6;
}
