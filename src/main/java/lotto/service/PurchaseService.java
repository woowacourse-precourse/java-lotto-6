package lotto.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.constant.message.InputMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.util.NumberUtil;
import lotto.util.ValidationUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseService {
    private final ValidationUtil validationUtil =new ValidationUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final NumberUtil numberUtil = new NumberUtil();



    public LottoPurchase getInputPurchase(String purchase){
        lottoPurchase.LottoPurchaseCreat(validationUtil.validatePurchase(purchase));
        generateLotto(lottoPurchase.getAmount());
        return lottoPurchase;
    }

    public void generateLotto(int amount){
        List<Lotto> purchaseLotto = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = generateLottoNumber();
            purchaseLotto.add(lotto);
        }
        lottoPurchase.getUserLotto(purchaseLotto);
    }

    public Lotto generateLottoNumber(){
        List<Integer> lottoNumbers = numberUtil.getLottoNumbers();
        lottoNumbers.sort(Comparator.naturalOrder());
        return new Lotto(lottoNumbers);
    }


}
