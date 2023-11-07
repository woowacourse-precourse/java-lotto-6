package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private int inputAmount;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoMachine(){
        lottos = new ArrayList<>();
    }
}
