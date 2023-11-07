package lotto.console.game.lotto.core;

import java.util.List;

import static lotto.console.game.lotto.constants.GameConstants.*;
import static lotto.console.game.lotto.constants.GameMessages.*;

public class PrizeDetail {
    int firstPrizeCount;
    int secondPrizeCount;
    int thirdPrizeCount;
    int fourthPrizeCount;
    int fifthPrizeCount;

    public PrizeDetail() {
        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
    }


    public void updateDetailByLotto(List<Integer> numbers, List<Integer> winningNumbers, int bonusNumber) {
        Match match = new Match();
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                match.addCount();
            }
            if (bonusNumber == number)
                match.isBonus();
        }

        makeDetail(match);
    }

    private void makeDetail(Match match) {
        Rank rank = match.getRank();
        if (rank == Rank.FIRST) firstPrizeCount++;
        if (rank == Rank.SECOND) secondPrizeCount++;
        if (rank == Rank.THIRD) thirdPrizeCount++;
        if (rank == Rank.FOURTH) fourthPrizeCount++;
        if (rank == Rank.FIFTH) fifthPrizeCount++;
    }

    public String exportMessage() {
        return
                makeFifthPrizeMessage()
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


}
