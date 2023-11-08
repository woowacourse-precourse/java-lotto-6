package lotto.service;

import static lotto.constant.NumberConstant.SAME_COUNT_FIVE;
import static lotto.constant.NumberConstant.ZERO;

import java.util.List;
import lotto.constant.NumberConstant;
import lotto.domain.LottoTicket;
import lotto.domain.Result;

public class LottoService {


    private final RecordService recordService = new RecordService();
    private final YieldService yieldService = new YieldService();

    public void lottoGameProcess(List<LottoTicket> lottoTickets, List<Integer> lottoWinNumbers,
        Integer bonusNumber) {
        for (int ticketNumber = ZERO.getNumber(); ticketNumber < lottoTickets.size();
            ticketNumber++) {
            LottoTicket nowLottoTicket = lottoTickets.get(ticketNumber);
            nowLottoTicketHasWinNumber(nowLottoTicket, lottoWinNumbers);
            nowLottoTicketHasBonusNumber(nowLottoTicket, bonusNumber);
        }
        recordService.recordResult(lottoTickets);
    }

    private void nowLottoTicketHasWinNumber(LottoTicket lottoTicket,
        List<Integer> lottoWinNumbers) {
        for (Integer lottoWinNumber : lottoWinNumbers) {
            nowLottoTicketContainWinNumber(lottoTicket, lottoWinNumber);
        }
    }

    public double calculateYield(Long result, Long money) {
        return yieldService.calculateYield(result, money);
    }

    public long calculateFinalMoney() {
        long totalMoney = NumberConstant.ZERO.getNumber();
        for (Result value : Result.values()) {
            totalMoney += (long) value.getMoney() * value.getResultCount();
        }
        return totalMoney;
    }

    private void nowLottoTicketHasBonusNumber(LottoTicket lottoTicket, Integer bonusNumber) {
        if (lottoTicket.getSameCount() == SAME_COUNT_FIVE.getNumber() && lottoTicket.getNumbers()
            .contains(bonusNumber)) {
            lottoTicket.hasBonus();
        }
    }

    private void nowLottoTicketContainWinNumber(LottoTicket lottoTicket, Integer lottoWinNumber) {
        if (lottoTicket.getNumbers().contains(lottoWinNumber)) {
            lottoTicket.addSameCount();
        }
    }

}
