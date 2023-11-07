package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;

public class LottoService {
    private final int LOTTO_PRICE = 1000;
    public int checkLottoNumber(String purchaseAmount) {
        return convertToInt(purchaseAmount) / LOTTO_PRICE;
    }

    public Lotto generateLotto() {
        List<Integer> lottoNumber = generateRandomNumber();
        Lotto lotto = new Lotto(lottoNumber);
        return lotto;
    }
    private int convertToInt(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    private List<Integer> generateRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
