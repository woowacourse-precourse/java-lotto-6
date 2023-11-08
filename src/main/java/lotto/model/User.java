package lotto.model;

import static lotto.utility.Constants.LOTTO_LENGTH;
import static lotto.utility.Constants.MAX_LOTTO_NUMBER;
import static lotto.utility.Constants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.utility.Rank;

public class User {
    private static List<Integer> winningNumbers;
    private static Integer bonusNumber;
    private Integer purchaseAmount;
    private Integer purchaseLottoNumber;
    private Integer firstRank;
    private Integer secondRank;
    private Integer thirdRank;
    private Integer fourthRank;
    private Integer fifthRank;
    private Double earningRate;
    private List<Lotto> lottos;
    public User() {
        lottos = new ArrayList<>();
        firstRank = 0;
        secondRank = 0;
        thirdRank = 0;
        fourthRank = 0;
        fifthRank = 0;
    }

    public static void setWinningNumbers(List<Integer> winningNumbers) {
        User.winningNumbers = winningNumbers;
    }

    public static List<Integer> getWinningNumbers() {
        return User.winningNumbers;
    }

    public static void setBonusNumber(Integer bonusNumber) {
        User.bonusNumber = bonusNumber;
    }

    public static Integer getBonusNumber() {
        return User.bonusNumber;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getPurchaseLottoNumber() {
        return purchaseLottoNumber;
    }

    public void setPurchaseLottoNumber(Integer purchaseLottoNumber) {
        this.purchaseLottoNumber = purchaseLottoNumber;
    }

    public void setLottos() {
        for (int i=0; i<purchaseLottoNumber; i++) {
            this.lottos.add(generateLotto());
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void calculateWinning() {
        for (Lotto lotto : lottos) {
            Rank rank = Rank.getRank(lotto, winningNumbers, bonusNumber);
            if (rank == Rank.FIRST) {firstRank++;}
            if (rank == Rank.SECOND) {secondRank++;}
            if (rank == Rank.THIRD) {thirdRank++;}
            if (rank == Rank.FOURTH) {fourthRank++;}
            if (rank == Rank.FIFTH) {fifthRank++;}
        }
    }

    public void calculateEarningRate() {
        Integer totalEarning = 0;
        totalEarning += Rank.FIRST.getReward() * firstRank;
        totalEarning += Rank.SECOND.getReward() * secondRank;
        totalEarning += Rank.THIRD.getReward() * thirdRank;
        totalEarning += Rank.FOURTH.getReward() * fourthRank;
        totalEarning += Rank.FIFTH.getReward() * fifthRank;
        this.earningRate = (double) totalEarning / purchaseAmount * 100;
        this.earningRate = Math.round(this.earningRate * 10.0) / 10.0;
    }

    public Double getEarningRate() {
        return earningRate;
    }

    public Integer getFirstRank() {
        return firstRank;
    }

    public Integer getSecondRank() {
        return secondRank;
    }

    public Integer getThirdRank() {
        return thirdRank;
    }

    public Integer getFourthRank() {
        return fourthRank;
    }

    public Integer getFifthRank() {
        return fifthRank;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_LENGTH);
        Lotto newLotto = new Lotto(numbers);
        return newLotto;
    }

}
