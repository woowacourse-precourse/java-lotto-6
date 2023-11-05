package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> numberOfWin;
    private final int NUMBER_OF_SAME = 8;
    private final int MINIMUM_NUMBER_OF_SAME = 3;
    private final int BONUS_NUMBER_SAME = 2;

    public User(int payment) {
        validatePayment(payment);
        this.payment = payment;
        this.purchaseNumber = payment / 1000;
        this.purchasedLottoNumbers = generateLottoNumbers(purchaseNumber);
        this.numberOfWin = initNumberOfWin();
    }

    private void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> initNumberOfWin() {
        this.numberOfWin = new ArrayList<>();

        for (int i=0;i<NUMBER_OF_SAME;i++) {
            this.numberOfWin.add(0);
        }
        return this.numberOfWin;
    }

    private List<List<Integer>> generateLottoNumbers(int purchaseNumber) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i=0;i<purchaseNumber;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public int purchaseNumber() {
        return this.purchaseNumber;
    }

    public List<List<Integer>> PurchasedLottoNumbers() {
        return this.purchasedLottoNumbers;
    }

    public void increaseNumberOfWin(int count) {
        if (count >= MINIMUM_NUMBER_OF_SAME) {
            int currentNumber = this.numberOfWin.get(count);
            numberOfWin.set(count, currentNumber + 1);
        }
    }

    public double payment() {
        return this.payment;
    }


    public List<Integer> numberOfWin() {
        return this.numberOfWin;
    }

    public int purchasedLottoNumbersSize() {
        return this.PurchasedLottoNumbers().size();
    }
}
