package lotto.domain;

import static lotto.message.LottoMessage.FIFTH_PLACE;
import static lotto.message.LottoMessage.FIRST_PLACE;
import static lotto.message.LottoMessage.FOURTH_PLACE;
import static lotto.message.LottoMessage.SECOND_PLACE;
import static lotto.message.LottoMessage.THIRD_PLACE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.vo.Result;

public final class Statistics {

    private final List<Result> results;
    private final List<Integer> ranks;

    public Statistics(List<Result> results) {
        this.results = results;
        this.ranks = getRank();
    }

    public List<String> rankStatistics() {
        List<String> printResult = new ArrayList<>();
        for (int rank = 1; rank < ranks.size(); rank++) {
            String lottoMessage = getPlaceMessage(rank);
            printResult.add(lottoMessage + ranks.get(rank) + "개");
        }
        return printResult;
    }


    public BigDecimal calcRateOfReturn(int money) {
        List<Integer> rewards = Arrays.asList(0, 5000, 50000, 1500000, 30000000, 2000000000);
        int totalReturn = 0;
        for (int rank = 1; rank < ranks.size(); rank++) {
            totalReturn += rewards.get(rank) * ranks.get(rank);
        }
        return BigDecimal.valueOf(((double) totalReturn / money) * 100);
    }

    private String getPlaceMessage(int place) {
        List<String> placeMessages = Arrays.asList("", FIFTH_PLACE.getMessage(), FOURTH_PLACE.getMessage(),
                THIRD_PLACE.getMessage(), SECOND_PLACE.getMessage(), FIRST_PLACE.getMessage());
        return placeMessages.get(place);
    }

    private List<Integer> getRank() {
        List<Integer> ranks = Arrays.asList(0, 0, 0, 0, 0, 0);
        results.stream()
                .map(Result::getRank)
                .forEach(rank -> ranks.set(rank, ranks.get(rank) + 1));
        return ranks;
    }
}
