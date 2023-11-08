package lotto.domain.dto;

import java.util.List;
import java.util.Map;
import lotto.domain.entity.Ranking;

public class DtoMapper {

    private DtoMapper() {

    }

    public static PurchaseDto toPurchaseDtofrom(final List<List<Integer>> purchaseLottos) {
        return new PurchaseDto(purchaseLottos);
    }

    public static WinningResultDto toWinningResultDtofrom(final Map<Ranking, Integer> rankings,
                                                          final double rateOfReturn) {
        return new WinningResultDto(rankings, rateOfReturn);
    }
}
