package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> rankCount;

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

        for (int i = 0; i < ModelValue.RANK_NUMBER.getModelValue(); i++) {
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
        if (rank == ModelValue.FIFTH_PLACE.getModelValue()) {
            this.rankCount.set(ModelValue.FIFTH_PLACE.getModelValue(), this.rankCount.get(ModelValue.FIFTH_PLACE.getModelValue()) + 1);
        } else if (rank == ModelValue.FOURTH_PLACE.getModelValue()) {
            this.rankCount.set(ModelValue.FOURTH_PLACE.getModelValue(), this.rankCount.get(ModelValue.FOURTH_PLACE.getModelValue()) + 1);
        } else if (rank == ModelValue.THIRD_PLACE.getModelValue()) {
            this.rankCount.set(ModelValue.THIRD_PLACE.getModelValue(), this.rankCount.get(ModelValue.THIRD_PLACE.getModelValue()) + 1);
        } else if (rank == ModelValue.SECOND_PLACE.getModelValue()) {
            this.rankCount.set(ModelValue.SECOND_PLACE.getModelValue(), this.rankCount.get(ModelValue.SECOND_PLACE.getModelValue()) + 1);
        } else if (rank == ModelValue.FIRST_PLACE.getModelValue()) {
            this.rankCount.set(ModelValue.FIRST_PLACE.getModelValue(), this.rankCount.get(ModelValue.FIRST_PLACE.getModelValue()) + 1);
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
