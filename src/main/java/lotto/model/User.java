package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.LottoValue;
import lotto.RankValue;

public class User {
    private final int payment;
    private final int purchaseNumber;
    private final List<List<Integer>> purchasedLottoNumbers;
    private List<Integer> rankCount;

    public User(int payment) {
        validatePayment(payment);
        this.payment = payment;
        this.purchaseNumber = payment / (int)LottoValue.PAYMENT_UNIT.getValue();
        this.purchasedLottoNumbers = generateLottoNumbers(purchaseNumber);
        this.rankCount = initCount();
    }

    private void validatePayment(int payment) {
        if (payment % (int)LottoValue.PAYMENT_UNIT.getValue() != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> initCount() {
        this.rankCount = new ArrayList<>();

        for (int i = 0; i < RankValue.RANK_NUMBER.getRankValue(); i++) {
            this.rankCount.add(RankValue.INIT_RANK_ARRAY.getRankValue());
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
        if (rank == RankValue.FIFTH_PLACE.getRankValue()) {
            this.rankCount.set(RankValue.FIFTH_PLACE.getRankValue(), this.rankCount.get(RankValue.FIFTH_PLACE.getRankValue()) + 1);
        } else if (rank == RankValue.FOURTH_PLACE.getRankValue()) {
            this.rankCount.set(RankValue.FOURTH_PLACE.getRankValue(), this.rankCount.get(RankValue.FOURTH_PLACE.getRankValue()) + 1);
        } else if (rank == RankValue.THIRD_PLACE.getRankValue()) {
            this.rankCount.set(RankValue.THIRD_PLACE.getRankValue(), this.rankCount.get(RankValue.THIRD_PLACE.getRankValue()) + 1);
        } else if (rank == RankValue.SECOND_PLACE.getRankValue()) {
            this.rankCount.set(RankValue.SECOND_PLACE.getRankValue(), this.rankCount.get(RankValue.SECOND_PLACE.getRankValue()) + 1);
        } else if (rank == RankValue.FIRST_PLACE.getRankValue()) {
            this.rankCount.set(RankValue.FIRST_PLACE.getRankValue(), this.rankCount.get(RankValue.FIRST_PLACE.getRankValue()) + 1);
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
