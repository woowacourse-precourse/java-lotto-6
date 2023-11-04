package lotto.service.domain.lotto;

import lotto.service.domain.random.CreateRandomNumberService;

import java.util.List;

public class CreateAutoLottoNumberService {
    public List<Integer> getLottoSixNumbers() {
        return CreateRandomNumberService.getAutoUniqueNumbers(LOTTO_PICK_VALUE_MAX_NUMBER);
    }
    public int getBonusNumber() {
        return CreateRandomNumberService.getBonusNumber();
    }
    private static final int LOTTO_PICK_VALUE_MAX_NUMBER = 6;
}
