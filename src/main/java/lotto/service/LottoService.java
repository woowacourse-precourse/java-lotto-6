package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoService {
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;
    private static final Integer NUMBER_STANDARD = 6;
    private static final Integer DIVIDE_STANDARD = 1000;

    public Integer purchaseLottoWithValidPrice(Integer inputMoney) {
        validateInputMoney(inputMoney);

        return inputMoney/DIVIDE_STANDARD;
    }

    private void validateInputMoney(Integer inputMoney) {
        if (!(inputMoney % DIVIDE_STANDARD == 0)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_STANDARD);
    }
}
