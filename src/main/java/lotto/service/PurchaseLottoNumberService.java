package lotto.service;

import lotto.Lotto;
import lotto.dto.PurchaseLottoDto;
import lotto.service.validation.LottoPurchaseAmountValidation;
import lotto.view.NumberOfLottoPurchaseView;

import java.util.List;

import static java.lang.Integer.parseInt;

public class PurchaseLottoNumberService {
    public List<Lotto> userPurchaseLottoLogic() {
        String lottoPurchaseAmount = LottoPurchaseAmountFromUser();
        validateLottoPurchaseAmount(lottoPurchaseAmount);
        List<Lotto> purchaseLotto = purchaseLotto(parseInt(lottoPurchaseAmount));
        return purchaseLotto;
    }

    private String LottoPurchaseAmountFromUser() {
        NumberOfLottoPurchaseView numberOfLottoPurchaseView = new NumberOfLottoPurchaseView();
        return numberOfLottoPurchaseView.lottoPurchaseInterface();
    }

    private void validateLottoPurchaseAmount(String amount) {
        LottoPurchaseAmountValidation lottoPurchaseAmountValidation = new LottoPurchaseAmountValidation(amount);
        lottoPurchaseAmountValidation.purchaseAmountValidation();
    }

    private List<Lotto> purchaseLotto(int amount) {
        PurchaseLottoDto purchaseLotto = new PurchaseLottoDto(amount);
        return purchaseLotto.BuyLottoGroup();
    }
}
