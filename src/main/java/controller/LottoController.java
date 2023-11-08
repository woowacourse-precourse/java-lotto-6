package controller;

import common.Converter;
import model.Amount;
import service.LottoService;
import view.InputView;

public class LottoController {
    private LottoService lottoService = LottoService.getInstance();

    public void run(){
        String inputAmount = InputView.purchaseAmount();
        Amount amount = new Amount(Converter.stringToInteger(inputAmount));
        lottoService.start(amount);
    }
}
