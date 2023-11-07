package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int COUNT_LOTTO_NUMBER = 6;

    private int purchaseCount;
    private ArrayList<List<Integer>> purchaseLottoNumbers;

    public PurchaseLotto(int purchaseCount) {
        this.purchaseLottoNumbers = createLottoNumbers(purchaseCount);
        this.purchaseCount = purchaseCount;
    }
    public ArrayList<List<Integer>> getPurchaseLottoNumbers() {
        return purchaseLottoNumbers;
    }

    public ArrayList<List<Integer>> createLottoNumbers(int purchaseCount) {
        ArrayList<List<Integer>> purchaseLottoNumbers = new ArrayList<>();
        for (int count = 0; count < purchaseCount; count++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, COUNT_LOTTO_NUMBER);
            purchaseLottoNumbers.add(lottoNumber);
        }
        return purchaseLottoNumbers;
    }
}