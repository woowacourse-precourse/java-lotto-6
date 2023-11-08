package lotto.vo;


import static lotto.utils.LottoConstants.FIFTH_PLACE_WINNING_AMOUNT;
import static lotto.utils.LottoConstants.FIRST_PLACE_WINNING_AMOUNT;
import static lotto.utils.LottoConstants.FOURTH_PLACE_WINNING_AMOUNT;
import static lotto.utils.LottoConstants.LAST_PLACE_WINNING_AMOUNT;
import static lotto.utils.LottoConstants.SECOND_PLACE_WINNING_AMOUNT;
import static lotto.utils.LottoConstants.THIRD_PLACE_WINNING_AMOUNT;

import java.util.Arrays;
import java.util.List;

public final class Reward {
    private final List<Integer> prize;

    public Reward() {
        Integer lastPlaceWinningAmount = LAST_PLACE_WINNING_AMOUNT.getValue();
        Integer fifthPlaceWinningAmount = FIFTH_PLACE_WINNING_AMOUNT.getValue();
        Integer fourthPlaceWinningAmount = FOURTH_PLACE_WINNING_AMOUNT.getValue();
        Integer thirdPlaceWinningAmount = THIRD_PLACE_WINNING_AMOUNT.getValue();
        Integer secondPlaceWinningAmount = SECOND_PLACE_WINNING_AMOUNT.getValue();
        Integer firstPlaceWinningAmount = FIRST_PLACE_WINNING_AMOUNT.getValue();
        this.prize = Arrays.asList(lastPlaceWinningAmount, fifthPlaceWinningAmount, fourthPlaceWinningAmount,
                thirdPlaceWinningAmount, secondPlaceWinningAmount, firstPlaceWinningAmount);
    }

    public List<Integer> getPrize() {
        return prize;
    }
}
