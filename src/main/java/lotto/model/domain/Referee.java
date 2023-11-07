package lotto.model.domain;

import lotto.util.validate.DomainValidate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


import static lotto.model.domain.Rank.*;
import static lotto.util.constant.Constant.*;
import static lotto.util.validate.DomainValidate.*;

public class Referee {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Integer> lottoRank;
    private Double lottoBenefit;

    public Referee(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new ArrayList<>(winningNumbers);
        Collections.sort(this.winningNumbers);
        this.bonusNumber = bonusNumber;
        this.lottoRank = new ArrayList<>(initLottoRank());
    }

    public List<Integer> initLottoRank() {
        return IntStream.range(INITIALIZE_NUMBER_MIN, INITIALIZE_NUMBER_MAX)
                .map(e -> 0)
                .boxed()
                .toList();
    }

    public void increaseCountForRank(int rank) {
        validateOutOfRankingIndex(rank);
        int count = this.lottoRank.get(rank);
        this.lottoRank.set(rank, count + PLUS_RANK);
    }

    public void calculateLottoBenefit(int lottoAmount) {
        DomainValidate.validateDivideZeroDenominator(lottoAmount);

        long first = lottoRank.get(FIRST.getRank()) * FIRST.getReward();
        long second = lottoRank.get(SECOND.getRank()) * SECOND.getReward();
        long third = lottoRank.get(THIRD.getRank()) * THIRD.getReward();
        long fourth = lottoRank.get(FOURTH.getRank()) * FOURTH.getReward();
        long fifth = lottoRank.get(FIFTH.getRank()) * FIFTH.getReward();

        long sum = first + second + third + fourth + fifth;

        this.lottoBenefit = (sum * PERCENTAGE / (double) lottoAmount);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getLottoRank() {
        return lottoRank;
    }

    public Double getLottoBenefit() {
        return lottoBenefit;
    }
}
