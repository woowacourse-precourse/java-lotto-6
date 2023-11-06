package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

import lotto.Constant.LottoNumber;
import lotto.Util.ExceptionTest;
import lotto.Util.Input;
import lotto.Util.PrintUserLotto;
import static lotto.Constant.Const.USER_PURCHASE_LOTTO_AMOUNT;

public class LottoPurchase {
    private final ExceptionTest exceptionTest = new ExceptionTest();
    private final LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();
    private List<Lotto> userLotto;
    private int userLottoPrice;

    public LottoPurchase userInputPurchase(){
        int userLottoPrice = getUserPurchasePrice();
        int userLottoAmount = getUserLottoAmount(userLottoPrice);
        List<Lotto> userLotto = new ArrayList<>();


        for(int i = 0; i < userLottoAmount; i++) {
            Lotto lotto = getLottoRandomNumber();
            userLotto.add(lotto);
        }
        this.userLotto = userLotto;
        this.userLottoPrice = userLottoAmount;

        return this;
    }

    public int getUserPurchasePrice(){
        String userPurchasePrice = Input.userInputPurchaseLotto();
        return exceptionTest.checkUserInputPrice(userPurchasePrice);
    }

    public int getUserLottoAmount(int userInputPurchaseLottoPrice){
        int userLottoAmount = (userInputPurchaseLottoPrice / LottoNumber.PURCHASE_LOTTO_PRICE.getLottoNumber());
        System.out.println("\n" + userLottoAmount + USER_PURCHASE_LOTTO_AMOUNT);
        return userLottoAmount;
    }

    private Lotto getLottoRandomNumber(){
        List<Integer> lottoNumber = lottoRandomNumber.createLottoRandomNumber();
        Lotto lotto = new Lotto(lottoNumber);
        PrintUserLotto.printUserLotto(lotto.getLottoNumber());
        return lotto;
    }

    public List<Lotto> getLottoNumber(){
        return userLotto;
    }

    public int getLottoPrice(){
        return userLottoPrice;
    }

}
