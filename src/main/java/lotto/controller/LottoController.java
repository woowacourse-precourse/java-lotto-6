package lotto.controller;

import lotto.model.*;
import lotto.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;

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
        Map<Prize, Integer> prizeCount = getLotteryPrizeCount(lottos, lottoFromUser);

        for (int i = Prize.values().length - 1; i >= 0; i--) {
            OutputView.showLottoResult(Prize.values()[i].getMessage(), prizeCount.get(Prize.values()[i]));
        }
    }

    public Map<Prize, Integer> getLotteryPrizeCount(Lottos lottos, LottoFromUser lottoFromUser) {   //당첨금 등수별 횟수 구하기
        Map<Prize, Integer> prizeCount = initPrizeCount();
        for (Lotto lotto : lottos.getLottoList()) {
            int numberMatchCount = compareLotto(lotto, lottoFromUser);
            boolean bonusCheck = lotto.getLottoNumbers().contains(lottoFromUser.getBonusNumber());

            Prize prize = Prize.getPrize(numberMatchCount, bonusCheck);     //당첨금 등수 구하기
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }

        return prizeCount;
    }

    public int compareLotto(Lotto lotto, LottoFromUser lottoFromUser) {
        return (int) lotto.getLottoNumbers().stream().filter(
                number -> lottoFromUser.getLotto().getLottoNumbers().contains(number)).count();
    }

    private Map<Prize, Integer> initPrizeCount() {
        Map<Prize, Integer> prizeCount = new LinkedHashMap<>();

        for (Prize prize : Prize.values()) {
            prizeCount.put(prize, 0);
        }

        return prizeCount;
    }
}
