package lotto.controller;

import static lotto.constant.ConstantInteger.ZERO;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoTicketManager;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.number.AutoNumberGenerator;
import lotto.domain.number.LottoNumberGenerator;

public class LottoController {

    private final LottoTicketManager lottoTicketManager;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoTickets lottoTickets;

    public LottoController(){
        lottoTicketManager = new LottoTicketManager();
        lottoNumberGenerator = new AutoNumberGenerator();
        lottoTickets = new LottoTickets();
    }

    public List<Lotto> buyTicket(String price) {
        Integer numberOfTickets = lottoTicketManager.countTickets(price);
        settingTicketNumbers(numberOfTickets);
        List<Lotto> userLottoTicket = lottoTickets.getLottoTickets();
        lottoTicketManager.setUserLottoTickets(userLottoTicket);
        return userLottoTicket;
    }

    private void settingTicketNumbers(Integer ticketCount){
        while (ticketCount-- > ZERO ){
            lottoTickets.setTicket(lottoNumberGenerator.getLottoNumbers());
        }
    }

    public void setLuckyNumber(Lotto luckyNumber) {
        lottoTicketManager.getLuckyNumber(luckyNumber);
    }

    public void validateBonusNumber(Integer bonusNumber) {
        lottoTicketManager.getBonusNumber(bonusNumber);
    }

    public Map<Rank, Integer> provideResult() {
        return lottoTicketManager.makeResult();
    }

    public double provideRevenue() {
        return lottoTicketManager.calculateRevenue();
    }
}
