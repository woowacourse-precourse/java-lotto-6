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
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ValidationUtil validationUtil =new ValidationUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final NumberUtil numberUtil = new NumberUtil();



    public LottoPurchase getInputPurchase(){
        String purchase = inputView.getInputWithMessage(InputMessage.INPUT_PURCHASE.getMessage());
        lottoPurchase.LottoPurchaseCreat(validationUtil.validatePurchase(purchase));
        printPurchaseLotto(lottoPurchase.getAmount());
        generateLotto(lottoPurchase.getAmount());
        return lottoPurchase;
    }

    public void printPurchaseLotto(int amount){
        outputView.printPurchaseAmount(amount);
    }

    public void generateLotto(int amount){
        List<Lotto> Lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = generateLottoNumber();
            Lottos.add(lotto);
        }
        lottoPurchase.getUserLotto(Lottos);
    }

    public Lotto generateLottoNumber(){
        List<Integer> lottoNumbers = numberUtil.getLottoNumbers();
        lottoNumbers.sort(Comparator.naturalOrder());
        Lotto lotto = new Lotto(lottoNumbers);
        outputView.printPurchaseLotto(lotto.getLottoNumbers());
        return lotto;
    }
}
