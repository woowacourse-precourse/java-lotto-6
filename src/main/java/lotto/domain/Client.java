package lotto.domain;

import java.util.ArrayList;
import lotto.validation.Validation;

public class Client {
    private static final int PERCHASE_AMOUNT_MINUMUN_UNIT = 1000;
    private final ArrayList<Lotto> clientLottoList = new ArrayList<>();
    private final int purchaseAmount;

    public Client(int purchaseAmount){
        validateBuyAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public ArrayList<Lotto> getClientLottoList(){
        return clientLottoList;
    }

    public void addClientLotto(Lotto lotto) {
        clientLottoList.add(lotto);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validateBuyAmount(int amount) {
        Validation.validateMultipleNumber(amount, PERCHASE_AMOUNT_MINUMUN_UNIT);
    }
}
