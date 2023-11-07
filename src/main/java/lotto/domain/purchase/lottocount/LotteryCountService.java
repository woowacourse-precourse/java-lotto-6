package lotto.domain.purchase.lottocount;

import lotto.domain.UserInput;
import lotto.domain.view.InputView;
import lotto.domain.view.OutputView;

public class LotteryCountService {
    public Integer getCash() {
        // 금액 입력 뷰
        InputView.getCash();
        // 금액 입력받기
        String validCashInput = UserInput.getValidInput(CashValidator.validateCashInput);
        // 금액 매핑
        return CashMapper.mapToInteger(validCashInput);
    }

    /***
     * {@link LottoCountCalculator}에게 티켓 개수 구하기를 위임
     */
    public Integer getTicketCount(Integer cash) {
        // 금액에 대한 티켓 개수 계산
        Integer ticketCount = LottoCountCalculator.divideByLottoPrice(cash);
        // 티켓 개수 출력 뷰
        OutputView.printLottoAmount(ticketCount);
        return ticketCount;
    }
}
