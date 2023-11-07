package lotto.controller;

import lotto.constant.LottoAnnouncer;
import lotto.domain.Jackpot;
import lotto.domain.Lotto;
import lotto.view.Output;

import java.util.List;

public class Judgement {
    private Output output = Output.getOutput();

    private List<Lotto> lottos;
    private Jackpot jackpot;

    public Judgement(List<Lotto> lottos, Jackpot jackpot) {
        this.lottos = lottos;
        this.jackpot = jackpot;

        output.printMessage(LottoAnnouncer.PRIZE_STATISTICS.getMessage());
        output.printMessage(LottoAnnouncer.SEPARATOR.getMessage());
    }

    public void confirmJackpot() {
    }


}
