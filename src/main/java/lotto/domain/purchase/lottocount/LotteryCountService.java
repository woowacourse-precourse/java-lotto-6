package lotto.domain.purchase.lottocount;

import camp.nextstep.edu.missionutils.Console;

public class LotteryCountService {
    public Integer getLottoTicketCount() {
        // 입력
        String validCashInput = getValidCashInput();
        // 매핑
        Integer cash = CashMapper.mapToInteger(validCashInput);
        // 개수 반환
        return LottoCountCalculator.divideByLottoPrice(cash);
    }

    String getValidCashInput() {
        boolean success = false;
        String cashInput = null;
        while (!success) {
            cashInput = Console.readLine();
            success = validateCash(success, cashInput);
        }
        return cashInput;
    }

    boolean validateCash(boolean success, String cashInput) {
        try {
            CashValidator.validateCashInput(cashInput);
            success = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return success;
    }

    Integer getTicketCountFromCash(String cashInput) throws IllegalArgumentException {
        // 매핑
        Integer cash = CashMapper.mapToInteger(cashInput);
        // 개수 반환
        return LottoCountCalculator.divideByLottoPrice(cash);
    }
}
