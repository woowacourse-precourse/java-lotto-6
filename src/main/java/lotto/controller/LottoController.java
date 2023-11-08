package lotto.controller;

import lotto.Lotto;

import java.util.List;

public class LottoController {
    private User user;
    private LottoMachine lottoMachine;

    public LottoController(){
        this.user = new User();
        this.lottoMachine = new LottoMachine();
    }

    public void startGame() {
        int purchaseAmount = user.getPayment();
        List<Lotto> lottoNumbers = lottoMachine.getLottoNumberList(purchaseAmount);
        lottoMachine.printLottoNumbers(lottoNumbers);
        user.receiveLottoNumbers(lottoNumbers);

        LottoResult lottoResult = lottoMachine.getLottoResult();
        user.compareWithLottoResult(lottoResult);
        user.printLottoResult();
    }
}
