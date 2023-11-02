package lotto.domain;

public class LottoMachine {

    private static LottoMachine lottoMachine = new LottoMachine();

    private LottoMachine() {
    }

    public static LottoMachine getInstance(){
        return lottoMachine;
    }

    
}
