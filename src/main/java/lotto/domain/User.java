package lotto.domain;

import lotto.service.GameService;
import lotto.service.LottoService;
import lotto.validation.Validator;

import java.util.HashMap;

public class User {

    private final Validator validator = new Validator();
    private  int purchaseAmount;

    private final GameService gameService = new GameService();


    public  User(int purchaseAmount) {
        validator.isValidPurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        gameService.initLottoResult();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

}
