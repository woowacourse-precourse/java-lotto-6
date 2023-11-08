package controller;

import common.Converter;
import dto.Purchase;
import model.Amount;
import service.LottoService;
import view.InputView;
import view.OutputView;

public class LottoController {
    private LottoService lottoService = LottoService.getInstance();

    public void run(){
        String inputAmount = InputView.purchaseAmount();
        Amount amount = new Amount(Converter.stringToInteger(inputAmount));
        Purchase purchase = lottoService.start(amount);
        OutputView.showBuying(purchase);
    }
}
