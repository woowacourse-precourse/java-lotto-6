package lotto.view;

import lotto.service.dto.LottoResultDto;
import lotto.service.dto.PurchaseResultDto;

import java.util.*;

public class OutputView {
    private static final String PURCHASE_COMPLETE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";

    public void notifyPurchaseResult(PurchaseResultDto purchaseResultDto) {
        System.out.println(purchaseResultDto.size() + PURCHASE_COMPLETE);
        purchaseResultDto.lottoNumbers().forEach(System.out::println);
    }

    public void notifyLottoResult(List<LottoResultDto> lottoResultDtos, double rateOfReturn) {
        System.out.println(WINNING_STATISTICS);

        Map<Rank, Integer> resultMap = calculateWinningStatistics(lottoResultDtos);

        for (Map.Entry<Rank, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey().getMean() + " - " + entry.getValue() + "개");
        }

        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }


    private Map<Rank, Integer> calculateWinningStatistics(List<LottoResultDto> lottoResultDtos) {
        Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> rankMap.put(rank,0));

        return CountingRanks(lottoResultDtos, rankMap);
    }

    private Map<Rank, Integer> CountingRanks(List<LottoResultDto> lottoResultDtos, Map<Rank, Integer> rankMap) {
        lottoResultDtos.forEach(result -> {
            int allAmount = result.matchedAmount() + result.bonusMatchedAmount();

            if (result.matchedAmount() == 6) {
                rankMap.put(Rank.FIRST_PLACE, rankMap.get(Rank.FIRST_PLACE) + 1);
            }

            if (allAmount == 3) {
                rankMap.put(Rank.FIFTH_PLACE, rankMap.get(Rank.FIFTH_PLACE) + 1);
            }

            if (allAmount == 4) {
                rankMap.put(Rank.FOURTH_PLACE, rankMap.get(Rank.FOURTH_PLACE) + 1);
            }

            if (allAmount == 5) {
                rankMap.put(Rank.THIRD_PLACE, rankMap.get(Rank.THIRD_PLACE) + 1);
            }

            if (allAmount == 6) {
                rankMap.put(Rank.SECOND_PLACE, rankMap.get(Rank.SECOND_PLACE) + 1);
            }
        });
        return rankMap;
    }
}