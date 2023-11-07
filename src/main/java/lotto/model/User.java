package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Util.Size;
import lotto.Util.TBD;
import lotto.controller.Validation;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> rankCount;

    public User(int payment) {
        validate(payment);
        this.payment = payment;
        this.purchaseNumber = payment / Size.PAYMENT_UNIT.getSize();
        this.purchasedLottoNumbers = generateLottoNumbers(purchaseNumber);
        this.rankCount = initCount();
    }

    private void validate(int payment) {
        Validation.validatePaymentDivisibility(payment);
    }

    private List<Integer> initCount() {
        this.rankCount = new ArrayList<>();

        for (int i = 0; i < Size.RANK_SIZE.getSize(); i++) {
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
        if (rank == TBD.FIFTH_PLACE.getRank()) {
            this.rankCount.set(TBD.FIFTH_PLACE.getRank(),
                    this.rankCount.get(TBD.FIFTH_PLACE.getRank()) + 1);
        } else if (rank == TBD.FOURTH_PLACE.getRank()) {
            this.rankCount.set(TBD.FOURTH_PLACE.getRank(),
                    this.rankCount.get(TBD.FOURTH_PLACE.getRank()) + 1);
        } else if (rank == TBD.THIRD_PLACE.getRank()) {
            this.rankCount.set(TBD.THIRD_PLACE.getRank(),
                    this.rankCount.get(TBD.THIRD_PLACE.getRank()) + 1);
        } else if (rank == TBD.SECOND_PLACE.getRank()) {
            this.rankCount.set(TBD.SECOND_PLACE.getRank(),
                    this.rankCount.get(TBD.SECOND_PLACE.getRank()) + 1);
        } else if (rank == TBD.FIRST_PLACE.getRank()) {
            this.rankCount.set(TBD.FIRST_PLACE.getRank(),
                    this.rankCount.get(TBD.FIRST_PLACE.getRank()) + 1);
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
