package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.constants.LottoNumConstant;

public class LottoService {

    public static int amountPurchaseDivide(int purchaseInput) {
        int lottoNumber = purchaseInput / LottoNumConstant.LOTTO_AMOUNT_PURCHASE.getNumber();
        return lottoNumber;
    }

    public static List<Lotto> generateLottoNumbers(int lottoNumber) {
        List<Lotto> allLottoNumbers = new ArrayList<>();
        for (int index = 0; index < lottoNumber; index++) {
            Lotto lottoNumbers = LottoNumberGenerator.generateNum();
            allLottoNumbers.add(lottoNumbers);
        }
        return allLottoNumbers;
    }
}
