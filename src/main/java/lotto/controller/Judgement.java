package lotto.controller;

import lotto.domain.Jackpot;
import lotto.domain.Lotto;

import java.util.List;

public class Judgement {

    List<Lotto> lottos;
    Jackpot jackpot;

    public Judgement(List<Lotto> lottos, Jackpot jackpot) {
        this.lottos = lottos;
        this.jackpot = jackpot;
    }

    public void confirmJackpot() {

    }

    
}
