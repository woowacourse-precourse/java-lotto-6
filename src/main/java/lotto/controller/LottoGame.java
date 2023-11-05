package lotto.controller;

import lotto.domain.InputValidator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;

import static constant.MessageList.PRICE_OF_ONE_LOTTO;

public class LottoGame {
    private final LottoNumbers lottoNumbers;
    private Lotto lotto;
    private InputValidator inputValidator;

    public LottoGame() {
        lottoNumbers = new LottoNumbers();
        lotto = new Lotto(lottoNumbers.numbers);
        inputValidator = new InputValidator();
    }
    public void run(){
        while(true){
            try{
                start();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void start(){
        inputValidator.validatePurchaseAmount(InputView.getPurchaseAmountInputFromPlayer());
    }
    public int getPurchaseQuantityOfLotto(int purchaseAmount) {
        return purchaseAmount / PRICE_OF_ONE_LOTTO;
    }
}
