package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> rankCount;
    private final int RANK_NUMBER = 6;
    private final int FIRST_PLACE = 1;
    private final int SECOND_PLACE = 2;
    private final int THIRD_PLACE = 3;
    private final int FOURTH_PLACE = 4;
    private final int FIFTH_PLACE = 5;

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
        if (rank == FIFTH_PLACE) {
            this.rankCount.set(FIFTH_PLACE, this.rankCount.get(FIFTH_PLACE) + 1);
        } else if (rank == FOURTH_PLACE) {
            this.rankCount.set(FOURTH_PLACE, this.rankCount.get(FOURTH_PLACE) + 1);
        } else if (rank == THIRD_PLACE) {
            this.rankCount.set(THIRD_PLACE, this.rankCount.get(THIRD_PLACE) + 1);
        } else if (rank == SECOND_PLACE) {
            this.rankCount.set(SECOND_PLACE, this.rankCount.get(SECOND_PLACE) + 1);
        } else if (rank == FIRST_PLACE) {
            this.rankCount.set(FIRST_PLACE, this.rankCount.get(FIRST_PLACE) + 1);
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

    public List<Integer> getPurchasedLottoNumbers(int index) {
        return this.PurchasedLottoNumbers().get(index);
    }

    public List<Integer> rankCount() {
        return this.rankCount;
    }

    public int rankCountSize() {
        return this.rankCount.size();
    }

    public int getRankCount(int index) {
        return this.rankCount.get(index);
    }

    public int purchasedLottoNumbersSize() {
        return this.PurchasedLottoNumbers().size();
    }
}
