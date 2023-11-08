package lotto.domain;

import lotto.Lotto;
import lotto.constant.LottoNumber;
import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidateUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();
    private final InputUtil inputUtil = new InputUtil();
    private final ValidateUtil validateUtil = new ValidateUtil();

    private final NumberGenerator numberGenerator = new NumberGenerator();
    private final List<Lotto> userLottos = new ArrayList<>();

    public void play(){
        messageUtil.printBonusInput();
        int purchaseAmount = getUserPurchaseAmount();
        getPurchaseInfo(purchaseAmount);
    }

    private int getUserPurchaseAmount(){
        int purchaseAmount = Integer.parseInt(inputUtil.getUserInput());
        validateUtil.validatePurchase(purchaseAmount);
        return purchaseAmount;
    }
    private void getPurchaseInfo(int purchaseAmount){
        int purchaseCount = purchaseAmount /
                LottoNumber.PURCHASE_AMOUNT_COND.getNumber();
        messageUtil.printPurchaseCount(purchaseCount);

        for (int i = 0; i <purchaseCount; i++){
            List<Integer>lottoNumbers=numberGenerator.getLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            messageUtil.printPurchaseInfo(lotto.getLottoNumbers());
            userLottos.add(lotto);
        }

    }


}
