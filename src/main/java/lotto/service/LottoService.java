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

    public static List<List<Integer>> generateLottoNumbers(int lottoNumber) {
        List<List<Integer>> allLottoNumbers = new ArrayList<>();
        for (int index = 0; index < lottoNumber; index++) {
            List<Integer> lottoNumbers = LottoNumberGenerator.generateNum();
            allLottoNumbers.add(lottoNumbers);
        }
        return allLottoNumbers;
    }

    public static int countMatchingNumbers(Lotto purchasedLotto, Lotto winningNumbers) {
        int count = 0;
        List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
        List<Integer> winningNumbersList = winningNumbers.getNumbers();

        for (Integer number : purchasedNumbers) {
            if (winningNumbersList.contains(number)) {
                count++;
            }
        }

        return count;
    }

}