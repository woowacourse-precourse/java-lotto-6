package lotto.domain.purchase.lottocount;

public class LotteryCountService {
    public Integer getLottoTicketCount(String cashInput) throws IllegalArgumentException {
        // 검증
        CashValidator.validateCashInput(cashInput);
        // 매핑
        Integer cash = CashMapper.mapToInteger(cashInput);
        // 개수 반환
        return LottoCountCalculator.getLottoTicketCount(cash);
    }
}
