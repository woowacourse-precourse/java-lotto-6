package lotto.services;

import static lotto.exception.ExceptionHandler.differentBuyFromPublish;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Buy {
    List<List<Integer>> buyLottoNumbers;

    public Buy(List<List<Integer>> buyLottoNumbers) {
        this.buyLottoNumbers = buyLottoNumbers;
    }

    public int createToLotto(int amount) {
        int buyCount = amount / 1000;

        publishOfLotto(buyCount);
        return buyCount;
    }

    private void publishOfLotto(int buyCount) {
        for (int count = 0; count < buyCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            addBuyLottoNumbers(lotto.getNumbers());
        }

        validatePublishSize(buyCount);
    }

    private void validatePublishSize(int buyCount) {
        if (getBuyLottoNumbers().size() != buyCount) {
            differentBuyFromPublish();
        }
    }

    public void addBuyLottoNumbers(List<Integer> buyLottoNumbers) {
        this.buyLottoNumbers.add(buyLottoNumbers);
    }

    public List<List<Integer>> getBuyLottoNumbers() {
        return this.buyLottoNumbers;
    }
}
