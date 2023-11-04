package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.LottoMachine;
import domain.LottoTicket;
import lotto.Lotto;

import java.util.List;

public class LottoController {
    public void start() {
        LottoTicket lottoTicket = new LottoTicket();
        int lottoTicketCount =  lottoTicket.lottoTicketService();

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.lottoMachineService(lottoTicketCount);

    }
}
