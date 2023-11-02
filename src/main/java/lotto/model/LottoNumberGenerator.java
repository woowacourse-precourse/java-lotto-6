package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {

    private static final int LOTTO_PRICE = 1000;

    private static LottoNumberGenerator lottoNumberGenerator;

    private LottoNumberGenerator() {
    }

    public static LottoNumberGenerator getInstance() {
        if (lottoNumberGenerator == null) {
            lottoNumberGenerator = new LottoNumberGenerator();
        }
        return lottoNumberGenerator;
    }

    public List<LottoNumber> createLottoNumbers(int money) {
        checkIfDividedByLottoPrice(money);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < money / LOTTO_PRICE) {
            lottoNumbers.add(new LottoNumber());
        }
        return lottoNumbers;
    }

    private void checkIfDividedByLottoPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 가능합니다.");
        }
    }
}
