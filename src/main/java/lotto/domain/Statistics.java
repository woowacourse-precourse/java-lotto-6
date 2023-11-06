package lotto.domain;

import static lotto.message.LottoMessage.FIFTH_PLACE;
import static lotto.message.LottoMessage.FIRST_PLACE;
import static lotto.message.LottoMessage.FOURTH_PLACE;
import static lotto.message.LottoMessage.SECOND_PLACE;
import static lotto.message.LottoMessage.THIRD_PLACE;
import static lotto.utils.ValueUnit.FIFTH_PLACE_WINNING_AMOUNT;
import static lotto.utils.ValueUnit.FIRST_PLACE_WINNING_AMOUNT;
import static lotto.utils.ValueUnit.FOURTH_PLACE_WINNING_AMOUNT;
import static lotto.utils.ValueUnit.LAST_PLACE_WINNING_AMOUNT;
import static lotto.utils.ValueUnit.ONE;
import static lotto.utils.ValueUnit.PERCENT_CALCULATION;
import static lotto.utils.ValueUnit.SECOND_PLACE_WINNING_AMOUNT;
import static lotto.utils.ValueUnit.THIRD_PLACE_WINNING_AMOUNT;
import static lotto.utils.ValueUnit.ZERO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.utils.StringUnit;
import lotto.utils.ValueUnit;
import lotto.vo.Result;

public final class Statistics {

    private final List<Result> results;
    private final List<Integer> ranks;

    public Statistics(List<Result> results) {
        this.results = results;
        this.ranks = getRank();
    }

    private static List<Integer> makeWinningAmounts() {
        Integer lastPlaceWinningAmount = LAST_PLACE_WINNING_AMOUNT.getValue();
        Integer fifthPlaceWinningAmount = FIFTH_PLACE_WINNING_AMOUNT.getValue();
        Integer fourthPlaceWinningAmount = FOURTH_PLACE_WINNING_AMOUNT.getValue();
        Integer thirdPlaceWinningAmount = THIRD_PLACE_WINNING_AMOUNT.getValue();
        Integer secondPlaceWinningAmount = SECOND_PLACE_WINNING_AMOUNT.getValue();
        Integer firstPlaceWinningAmount = FIRST_PLACE_WINNING_AMOUNT.getValue();
        return Arrays.asList(lastPlaceWinningAmount, fifthPlaceWinningAmount, fourthPlaceWinningAmount,
                thirdPlaceWinningAmount, secondPlaceWinningAmount, firstPlaceWinningAmount);
    }

    public List<String> rankStatistics() {
        List<String> printResult = new ArrayList<>();
        ValueUnit fifthPlace = ValueUnit.FIFTH_PLACE;
        ValueUnit firstPlace = ValueUnit.FIRST_PLACE;
        StringUnit unit = StringUnit.UNIT;
        for (int rank = fifthPlace.getValue(); rank < firstPlace.getValue(); rank++) {
            String lottoMessage = getPlaceMessage(rank);
            printResult.add(lottoMessage + ranks.get(rank) + unit.getValue());
        }
        return printResult;
    }

    public BigDecimal calcRateOfReturn(int money) {
        List<Integer> rewards = makeWinningAmounts();
        ValueUnit fifthPlace = ValueUnit.FIFTH_PLACE;
        ValueUnit firstPlace = ValueUnit.FIRST_PLACE;
        int totalReturn = ZERO.getValue();
        for (int rank = fifthPlace.getValue(); rank < firstPlace.getValue(); rank++) {
            totalReturn += rewards.get(rank) * ranks.get(rank);
        }
        return BigDecimal.valueOf(((double) totalReturn / money) * PERCENT_CALCULATION.getValue());
    }

    private String getPlaceMessage(int place) {
        List<String> placeMessages = Arrays.asList("", FIFTH_PLACE.getMessage(), FOURTH_PLACE.getMessage(),
                THIRD_PLACE.getMessage(), SECOND_PLACE.getMessage(), FIRST_PLACE.getMessage());
        return placeMessages.get(place);
    }

    private List<Integer> getRank() {
        Integer zero = ZERO.getValue();
        List<Integer> ranks = Arrays.asList(zero, zero, zero, zero, zero, zero);
        results.stream()
                .map(Result::getRank)
                .forEach(rank -> ranks.set(rank, ranks.get(rank) + ONE.getValue()));
        return ranks;
    }
}
