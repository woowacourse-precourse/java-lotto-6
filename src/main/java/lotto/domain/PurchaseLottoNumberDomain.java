package lotto.domain;

import lotto.Lotto;
import lotto.dto.PurchaseLottoDto;
import lotto.domain.validation.LottoPurchaseAmountValidation;
import lotto.view.NumberOfLottoPurchaseView;

import java.util.List;

public class PurchaseLottoNumberDomain {
    private NumberOfLottoPurchaseView numberOfLottoPurchaseView;
    private static int lottoAmount;

    public PurchaseLottoNumberDomain() {
        this.numberOfLottoPurchaseView = new NumberOfLottoPurchaseView();
    }

    public List<Lotto> userPurchaseLottoLogic() {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                String lottoPurchaseAmount = LottoPurchaseAmountFromUser();
                lottoAmount = validateLottoPurchaseAmount(lottoPurchaseAmount);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseLotto(lottoAmount);
    }

    private String LottoPurchaseAmountFromUser() {
        return numberOfLottoPurchaseView.lottoPurchaseInterface();
    }

    private int validateLottoPurchaseAmount(String amount) {
        LottoPurchaseAmountValidation lottoPurchaseAmountValidation = new LottoPurchaseAmountValidation(amount);
        return lottoPurchaseAmountValidation.purchaseAmountValidation();
    }

    private List<Lotto> purchaseLotto(int amount) {
        PurchaseLottoDto purchaseLotto = new PurchaseLottoDto(amount);
        List<Lotto> purchasedLotto = purchaseLotto.BuyLottoGroup();
        numberOfLottoPurchaseView.lottoPurchasedResult(purchasedLotto);
        return purchasedLotto;
    }
}
