package lotto.service;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.Result;

public class LottoService {


    private RecordService recordService = new RecordService();

    public Long calculateMoney(List<LottoTicket> lottoTickets, List<Integer> lottoWinNumbers,
        Integer bonusNumber) {
        for (int count = 0; count < lottoTickets.size(); count++) {
            for (Integer lottoWinNumber : lottoWinNumbers) {
                nowLottoTicketContainWinNumber(lottoTickets, lottoWinNumber, count);
            }
            nowLottoTicketHasBonusNumber(lottoTickets, bonusNumber, count);
        }
        recordService.recordResult(lottoTickets);
        return calculateFinalMoney();
    }

    private long calculateFinalMoney() {
        Result[] values = Result.values();
        long totalMoney = 0L;
        for (Result value : values) {
            totalMoney += (long) value.getMoney() * value.getResultCount();
        }
        return totalMoney;
    }

    private void nowLottoTicketHasBonusNumber(List<LottoTicket> lottoTickets, Integer bonusNumber,
        int count) {
        if (lottoTickets.get(count).getSameCount() == 5 && lottoTickets.get(count).getNumbers()
            .contains(bonusNumber)) {
            lottoTickets.get(count).hasBonus();
        }
    }

    private void nowLottoTicketContainWinNumber(List<LottoTicket> lottoTickets,
        Integer lottoWinNumber, int count) {
        if (lottoTickets.get(count).getNumbers().contains(lottoWinNumber)) {
            lottoTickets.get(count).addSameCount();
        }
    }

}
