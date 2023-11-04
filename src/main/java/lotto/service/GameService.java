package lotto.service;

import lotto.constant.NumberConstant;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoInputParser;
import lotto.model.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class GameService {

    private int purchaseAmount;
    private List<Lotto> issuedLotto;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public int inputPurchaseAmount(String input){
        purchaseAmount = PurchaseAmount.validated(input);
        return purchaseAmount;
    }

    public List<Lotto> createIssuedLotto(){
        int issuedLottoCount = purchaseAmount/ NumberConstant.LOTTO_ONE_PRICE;
        issuedLotto = new ArrayList<>();
        for(int i=1; i<=issuedLottoCount; i++){
            issuedLotto.add(new Lotto());
        }
        return issuedLotto;
    }

    public void inputWinningNumbers(String input){
        List<Integer> tempWinningNumbers = LottoInputParser.notNumber(input);
        winningNumbers = new Lotto(tempWinningNumbers);
    }

    public void inputBonusNumber(String input){
        bonusNumber = new BonusNumber(input, winningNumbers);
    }

}
