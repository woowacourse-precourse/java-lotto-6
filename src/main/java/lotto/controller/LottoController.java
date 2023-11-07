package lotto.controller;

import lotto.model.PurchasePrice;
import lotto.validator.InputValidator;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    public LottoController(InputView inputView){
        this.inputView = inputView;
    }

    private PurchasePrice getPurchasePrice(){
        while(true){
            try {
                String inputPrice = inputView.inputPurchasePrice();
                InputValidator.validateInput(inputPrice);
                return new PurchasePrice(Integer.parseInt(inputPrice));
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoController lottoController = new LottoController(inputView);
        lottoController.getPurchasePrice();
    }

}
