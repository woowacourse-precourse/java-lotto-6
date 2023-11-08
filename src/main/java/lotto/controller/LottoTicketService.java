package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoTicketMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketService {
    private LottoTicketMoney lottoTicketMoney;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoTicketMoney issueLottoTicket() {
        this.lottoTicketMoney = UserInput.inputPrice();
        for (int i = 0; i < this.lottoTicketMoney.calculateTicketNumber(); i++) {
            this.lottos.add(new Lotto(LottoNumberGenerator.createNumbers()));
        }
        return this.lottoTicketMoney;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
