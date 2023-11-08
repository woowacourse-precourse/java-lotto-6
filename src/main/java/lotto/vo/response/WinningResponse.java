package lotto.vo.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public class WinningResponse {
    private static final String RANK_FORM = "%d개 일치%s (%s원) - %d개";
    private static final String PRICE_FORM = "%,d";
    private static final String BONUS_NUMBER_FORM = ", 보너스 볼 일치";

    private final Map<Rank, Long> rankResults;

    public WinningResponse(List<Rank> rankResults) {
        this.rankResults = countRanks(rankResults);
    }

    private Map<Rank, Long> countRanks(List<Rank> ranks) {
        return ranks.stream()
            .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting())
            );
    }

    public List<String> createdMessage() {
        List<Rank> allRanks = getAllRankExceptUnranked();
        List<String> message = new ArrayList<>();
        for(Rank rank: allRanks) {
            message.add(formatRank(rank));
        }
        return message;
    }

    private List<Rank> getAllRankExceptUnranked() {
        List<Rank> allRanks = new ArrayList<>(Arrays.asList(Rank.values()));
        allRanks.remove(0);
        return allRanks;
    }

    private String formatRank(Rank rank) {
        Integer criterion = rank.getCriterion();
        String bonusNumber = formatBonusNumber(rank);
        String price = formatPrice(rank.getPrice());
        Long count = getCount(rank);
        return String.format(RANK_FORM, criterion, bonusNumber, price, count);
    }

    private String formatPrice(Long price) {
        return String.format(PRICE_FORM, price);
    }

    private String formatBonusNumber(Rank rank) {
        if(rank.requireBonusNumber()) {
            return BONUS_NUMBER_FORM;
        }
        return "";
    }

    private Long getCount(Rank rank) {
        Long count = rankResults.get(rank);
        if(count == null) {
            return 0L;
        }
        return count;
    }
}
