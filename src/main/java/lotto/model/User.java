package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.ErrorMessages;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> rankCount;
    private final int RANK_NUMBER = 6;
    private final int MINIMUM_NUMBER_OF_SAME = 3;
    private final int BONUS_NUMBER_SAME = 2;

    public User(int payment) {
        validatePayment(payment);
        this.payment = payment;
        this.purchaseNumber = payment / 1000;
        this.purchasedLottoNumbers = generateLottoNumbers(purchaseNumber);
        this.rankCount = initCount();
    }

    private void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> initCount() {
        this.rankCount = new ArrayList<>();

        for (int i = 0; i < RANK_NUMBER; i++) {
            this.rankCount.add(0);
        }
        return this.rankCount;
    }

    private List<List<Integer>> generateLottoNumbers(int purchaseNumber) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < purchaseNumber; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public void increaseRankCount(int rank) {
        if (rank == 5) {
            this.rankCount.set(5, this.rankCount.get(5) + 1);
        } else if (rank == 4) {
            this.rankCount.set(4, this.rankCount.get(4) + 1);
        } else if (rank == 3) {
            this.rankCount.set(3, this.rankCount.get(3) + 1);
        } else if (rank == 2) {
            this.rankCount.set(2, this.rankCount.get(2) + 1);
        } else if (rank == 1) {
            this.rankCount.set(1, this.rankCount.get(1) + 1);
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

    public List<Integer> rankCount() {
        return this.rankCount;
    }

    public int purchasedLottoNumbersSize() {
        return this.PurchasedLottoNumbers().size();
    }
}
