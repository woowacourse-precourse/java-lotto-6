package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> winningNumberCount;
    private final int NUMBER_OF_SAME = 8;
    private final int MINIMUM_NUMBER_OF_SAME = 3;
    private final int BONUS_NUMBER_SAME = 2;

    public User(int payment) {
        validatePayment(payment);
        this.payment = payment;
        this.purchaseNumber = payment / 1000;
        this.purchasedLottoNumbers = generateLottoNumbers(purchaseNumber);
        this.winningNumberCount = initCount();
    }

    private void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> initCount() {
        this.winningNumberCount = new ArrayList<>();

        for (int i=0;i<NUMBER_OF_SAME;i++) {
            this.winningNumberCount.add(0);
        }
        return this.winningNumberCount;
    }

    private List<List<Integer>> generateLottoNumbers(int purchaseNumber) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i=0;i<purchaseNumber;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public void increaseWinningNumberCount(int count) {
        if (count >= MINIMUM_NUMBER_OF_SAME) {
            int currentNumber = this.winningNumberCount.get(count);
            winningNumberCount.set(count, currentNumber + 1);
        }
    }

    public double payment() {
        return this.payment;
    }

    public int purchaseNumber() {
        return this.purchaseNumber;
    }

    public List<List<Integer>> PurchasedLottoNumbers() {
        return this.purchasedLottoNumbers;
    }

    public List<Integer> winningNumberCount() {
        return this.winningNumberCount;
    }

    public int purchasedLottoNumbersSize() {
        return this.PurchasedLottoNumbers().size();
    }
}
