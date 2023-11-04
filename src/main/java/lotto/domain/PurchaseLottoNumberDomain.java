package lotto.domain;

import lotto.Lotto;
import lotto.dto.PurchaseLottoDto;
import lotto.domain.validation.LottoPurchaseAmountValidation;
import lotto.view.NumberOfLottoPurchaseView;

import java.util.List;

import static java.lang.Integer.parseInt;

public class PurchaseLottoNumberDomain {
    private NumberOfLottoPurchaseView numberOfLottoPurchaseView;

    public PurchaseLottoNumberDomain() {
        this.numberOfLottoPurchaseView = new NumberOfLottoPurchaseView();
    }

    public List<Lotto> userPurchaseLottoLogic() {
        String lottoPurchaseAmount = LottoPurchaseAmountFromUser();
        validateLottoPurchaseAmount(lottoPurchaseAmount);
        return purchaseLotto(parseInt(lottoPurchaseAmount));
    }

    private String LottoPurchaseAmountFromUser() {
        return numberOfLottoPurchaseView.lottoPurchaseInterface();
    }

    private void validateLottoPurchaseAmount(String amount) {
        LottoPurchaseAmountValidation lottoPurchaseAmountValidation = new LottoPurchaseAmountValidation(amount);
        lottoPurchaseAmountValidation.purchaseAmountValidation();
    }

    private List<Lotto> purchaseLotto(int amount) {
        PurchaseLottoDto purchaseLotto = new PurchaseLottoDto(amount);
        List<Lotto> purchasedLotto = purchaseLotto.BuyLottoGroup();
        numberOfLottoPurchaseView.lottoPurchasedResult(purchasedLotto);
        return purchasedLotto;
    }
}
