package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> numberOfMatches;
    private final int NUMBER_OF_SAME = 8;
    private final int MINIMUM_NUMBER_OF_SAME = 3;
    private final int BONUS_NUMBER_SAME = 2;

    public User(int payment) {
        validatePayment(payment);
        this.payment = payment;
        this.purchaseNumber = payment / 1000;
        this.purchasedLottoNumbers = generateLottoNumbers(purchaseNumber);
        this.numberOfMatches = initNumberOfMatches();
    }

    private void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages
                    .NOT_DIVISIBLE_BY_THOUSAND
                    .getMessage());
        }
    }

    private List<Integer> initNumberOfMatches() {
        this.numberOfMatches = new ArrayList<>();

        for (int i=0;i<NUMBER_OF_SAME;i++) {
            this.numberOfMatches.add(0);
        }
        return this.numberOfMatches;
    }

    private List<List<Integer>> generateLottoNumbers(int purchaseNumber) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i=0;i<purchaseNumber;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public int PurchaseNumber() {
        return this.purchaseNumber;
    }

    public List<List<Integer>> PurchasedLottoNumbers() {
        return this.purchasedLottoNumbers;
    }

    public void increaseNumberOfMatches(int count) {
        if (count >= MINIMUM_NUMBER_OF_SAME){
            if (count == 5) {
                int currentNumber = this.numberOfMatches.get(count + BONUS_NUMBER_SAME);
                numberOfMatches.set(count + BONUS_NUMBER_SAME, currentNumber + 1);
                return;
            }
            int currentNumber = this.numberOfMatches.get(count);
            numberOfMatches.set(count, currentNumber + 1);
        }
    }

    public List<Integer> numberOfMatches() {
        return this.numberOfMatches;
    }
}
