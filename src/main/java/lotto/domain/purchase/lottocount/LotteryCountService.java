package lotto.domain.purchase.lottocount;

import camp.nextstep.edu.missionutils.Console;

public class LotteryCountService {
    public Integer getLottoTicketCount() {
        boolean success = false;
        Integer lottoTicketCount = 0;
        lottoTicketCount = getValidTicketCount(success, lottoTicketCount);
        return lottoTicketCount;
    }

    Integer getValidTicketCount(boolean success, Integer lottoTicketCount) {
        // 검증 통과될 때까지 입력
        while (!success) {
            String cashInput = Console.readLine();
            try {
                lottoTicketCount = getTicketCountFromCash(cashInput);
                success = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoTicketCount;
    }

    Integer getTicketCountFromCash(String cashInput) throws IllegalArgumentException {
        // 검증
        CashValidator.validateCashInput(cashInput);
        // 매핑
        Integer cash = CashMapper.mapToInteger(cashInput);
        // 개수 반환
        return LottoCountCalculator.getLottoTicketCount(cash);
    }
}
