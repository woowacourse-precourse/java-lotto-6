package lotto.domain;

import lotto.constant.LottoNumberComposition;
import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.NumberGenerator;
import lotto.util.PurchaseValidator;

import java.util.ArrayList;
import java.util.List;


public class LottoPurchase {
    private final InputUtil inputUtil = new InputUtil();
    private final MessageUtil messageUtil = new MessageUtil();
    private final PurchaseValidator purchaseValidator = new PurchaseValidator();
    private final NumberGenerator numberGenerator = new NumberGenerator();
    private List<Lotto> userLottos;
    private int purchaseAmount;

    public LottoPurchase getPurchaseInfo() {
        int purchaseAmount = getUserPurchaseAmount();
        List<Lotto> userLottos = new ArrayList<>();
        int purchaseCount = getPurchaseCount(purchaseAmount);

        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = generateLottoNumbers();
            userLottos.add(lotto);
        }

        this.userLottos = userLottos;
        this.purchaseAmount = purchaseAmount;

        return this;
    }

    private int getUserPurchaseAmount() {
        String purchaseAmount = inputUtil.getUserInput();
        return purchaseValidator.validatePurchase(purchaseAmount);
    }

    private int getPurchaseCount(int purchaseAmount) {
        int purchaseCount = purchaseAmount / LottoNumberComposition.MIN_PURCHASE_AMOUNT.getNumber();
        messageUtil.printPurchaseCount(purchaseCount);

        return purchaseCount;
    }

    private Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = numberGenerator.getLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        messageUtil.printPurchaseInfo(lotto.getLottoNumbers());

        return lotto;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}