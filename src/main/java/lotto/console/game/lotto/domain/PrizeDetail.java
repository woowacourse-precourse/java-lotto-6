package lotto.console.game.lotto.domain;

import lotto.console.game.lotto.constants.PrizeRank;

import java.util.List;

import static lotto.console.game.lotto.constants.GameConstants.*;
import static lotto.console.game.lotto.constants.GameMessages.*;

public class PrizeDetail {
    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public PrizeDetail() {
        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
    }

    public void updateDetailByLotto(List<Integer> playerNumbers, List<Integer> winningNumbers, int bonusNumber) {
        PrizeMatchCount prizeMatchCount = new PrizeMatchCount();
        updatePrizeMatchCount(playerNumbers, winningNumbers, bonusNumber, prizeMatchCount);
        applyInPrizeDetail(prizeMatchCount);
    }

    private void updatePrizeMatchCount(List<Integer> playerNumbers, List<Integer> winningNumbers, int bonusNumber, PrizeMatchCount prizeMatchCount) {
        for (int number : playerNumbers) {
            if (winningNumbers.contains(number)) {
                prizeMatchCount.addCount();
            }
            if (bonusNumber == number) {
                prizeMatchCount.matchBonus();
            }
        }
    }

    private void applyInPrizeDetail(PrizeMatchCount prizeMatchCount) {
        PrizeRank rank = prizeMatchCount.getPrizeRank();
        if (rank == PrizeRank.FIRST) addFirstPrizeCount();
        if (rank == PrizeRank.SECOND) addSecondPrizeCount();
        if (rank == PrizeRank.THIRD) addThirdPrizeCount();
        if (rank == PrizeRank.FOURTH) addFourthPrizeCount();
        if (rank == PrizeRank.FIFTH) addFifthPrizeCount();
    }

    public void addFirstPrizeCount() {
        firstPrizeCount++;
    }
    public void addSecondPrizeCount() {
        secondPrizeCount++;
    }
    public void addThirdPrizeCount() {
        thirdPrizeCount++;
    }
    public void addFourthPrizeCount() {
        fourthPrizeCount++;
    }
    public void addFifthPrizeCount() { fifthPrizeCount++; }


    public String exportMessage() {
        return makeMessage();
    }

    private String makeMessage() {
        return makeFifthPrizeMessage()
                + makeFourthPrizeMessage()
                + makeThirdPrizeMessage()
                + makeSecondPrizeMessage()
                + makeFirstPrizeMessage();
    }

    private String makeFirstPrizeMessage() {
        return FIRST_PRIZE_INFO + firstPrizeCount + PRIZE_INFO_POSTFIX;
    }
    private String makeSecondPrizeMessage() {
        return SECOND_PRIZE_INFO + secondPrizeCount + PRIZE_INFO_POSTFIX;
    }
    private String makeThirdPrizeMessage() {
        return THIRD_PRIZE_INFO + thirdPrizeCount + PRIZE_INFO_POSTFIX;
    }
    private String makeFourthPrizeMessage() {
        return FOURTH_PRIZE_INFO + fourthPrizeCount + PRIZE_INFO_POSTFIX;
    }
    private String makeFifthPrizeMessage() {
        return FIFTH_PRIZE_INFO + fifthPrizeCount + PRIZE_INFO_POSTFIX;
    }


    public int getPrizeMoney(){
        return calculatePrizeMoney();
    }

    private int calculatePrizeMoney() {
        return
                FIRST_PRIZE_MONEY * firstPrizeCount
                + SECOND_PRIZE_MONEY * secondPrizeCount
                + THIRD_PRIZE_MONEY * thirdPrizeCount
                + FOURTH_PRIZE_MONEY * fourthPrizeCount
                + FIFTH_PRIZE_MONEY * fifthPrizeCount;
    }


    public int getFirstPrizeCount() { return firstPrizeCount; }
    public int getSecondPrizeCount() { return secondPrizeCount; }
    public int getThirdPrizeCount() { return thirdPrizeCount; }
    public int getFourthPrizeCount() { return fourthPrizeCount; }
    public int getFifthPrizeCount() { return fifthPrizeCount; }

}
