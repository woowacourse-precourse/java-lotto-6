package lotto.domain.dto;

import java.util.List;

public class DtoMapper {

    private DtoMapper() {

    }

    public static PurchaseDto toPurchaseDtofrom(final List<List<Integer>> purchaseLottos) {
        return new PurchaseDto(purchaseLottos);
    }

    public static WinningResultDto toWinningResultDtofrom(final List<Integer> rankings,
                                                          final double rateOfReturn) {
        return new WinningResultDto(rankings, rateOfReturn);
    }
}
