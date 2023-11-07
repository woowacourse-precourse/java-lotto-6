package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validator;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView lottoView;

    public LottoController() {
        this.lottoView = new LottoView();
    }

    public int inputPurchaseMoney() {
        lottoView.printPurchasePrompt();
        String purchaseMoney = "";
        while(true) {
            try{
                purchaseMoney = Console.readLine();
                Validator.validatePurchaseMoney(purchaseMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(purchaseMoney);
    }
}
