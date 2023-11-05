package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGameService {

    private static final int lottoPrice = 1000;
    private final List<List<Integer>> purchasedLottoNumbers = new ArrayList<>();

    public void generateLottoNumbers() {
        Lotto lotto = new Lotto(LottoNumbersGenerator.generateLottoNumbers());
        purchasedLottoNumbers.add(lotto.getNumbers());
    }

    public int getLottoPurchaseCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / lottoPrice;
    }

    public List<List<Integer>> getPurchasedLottoNumbers() {
        return purchasedLottoNumbers;
    }
}
