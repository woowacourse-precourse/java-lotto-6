package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoFromUser;
import lotto.model.LottoPurchasingAmount;
import lotto.model.Lottos;
import lotto.view.OutputView;

public class LottoController {
    private final InputController inputController;

    public LottoController() {
        this.inputController = new InputController();
    }

    public void initLotto() {
        LottoPurchasingAmount lottoPurchasingAmount =
                inputController.getLottoPurchasingAmountFromUser();
        Lottos lottos = new Lottos(lottoPurchasingAmount.getLottoAmount());

        OutputView.showPurchasedLottoQuantity(lottoPurchasingAmount.getLottoAmount());
        for (Lotto lotto : lottos.getLottoList()) {
            OutputView.showPurchasedLotto(lotto.getLottoNumbers());
        }

        LottoFromUser lottoFromUser = inputController.getWinnerNumbersFromUser();
        lottery(lottoPurchasingAmount, lottos, lottoFromUser);
    }

    public void lottery(LottoPurchasingAmount lottoPurchasingAmount, Lottos lottos, LottoFromUser lottoFromUser) {
        getProfits(lottos, lottoFromUser);
    }

    public void getProfits(Lottos lottos, LottoFromUser lottoFromUser) {
        for (Lotto lotto : lottos.getLottoList()) {
            int numberMatches = compareLotto(lotto, lottoFromUser);
            boolean bonusCheck = lotto.getLottoNumbers().contains(lottoFromUser.getBonusNumber());

            System.out.println("맞춘 숫자 갯수 : " + numberMatches + " 보너스 숫자 맞춘 여부 : " + bonusCheck);
        }
    }

    public int compareLotto(Lotto lotto, LottoFromUser lottoFromUser) {
        return (int) lotto.getLottoNumbers().stream().filter(
                number -> lottoFromUser.getLotto().getLottoNumbers().contains(number)).count();
    }
}
