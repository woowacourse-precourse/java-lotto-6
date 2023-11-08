package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Domain.LottoRate;
import lotto.model.Lotto;
import lotto.model.LottoCal;
import lotto.model.LottoShop;
import lotto.model.RateCal;
import lotto.model.UserLotto;
import lotto.model.UserLottoPrice;
import lotto.view.LottoView;
import lotto.view.RateView;
import lotto.view.UserLottoView;

public class LottoController {

    private UserLottoView userLottoView = new UserLottoView();
    private LottoView lottoView = new LottoView();
    private LottoShop lottoShop;
    private UserLotto userLotto;
    private UserLottoPrice userLottoPrice;
    private LottoCal lottoCal = new LottoCal();
    private RateView rateView = new RateView();
    private static final List<Integer> RESULT_INDEX = new ArrayList<>(Arrays.asList(3, 4, 5, 7, 6));

    public void buyLotto() {
        String buyPrice = userLottoView.inputBuyPrice();
        userLottoPrice = new UserLottoPrice(buyPrice);
        lottoShop = new LottoShop(userLottoPrice.getLottoAmount());
    }

    public void inputLottoNumber() {
        String userLottoNumber = userLottoView.inputUserLottoNumber();
        String userBonusLotto = userLottoView.inputUserBonusLotto();
        userLotto = new UserLotto(userLottoNumber, userBonusLotto);

    }

    public void printBuyLotto() {
        lottoView.printLottoAmount(userLottoPrice.getLottoAmount());
        List<Lotto> lottos = lottoShop.getLottos();
        for (Lotto lotto :
                lottos) {
            lottoView.printLottoNumber(lotto.getNumbers());
        }
    }

    public void countLotto() {
        for (Lotto lotto :
                lottoShop.getLottos()) {
            lottoCal.count(lotto.getNumbers(), userLotto.getUserLotto(), userLotto.getUserBonus());
        }
    }

    public void printRate() {
        rateView.printResultStart();

        //View에 낮은 등수부터 높은 등수까지 Count한 개수 리스트 전달위해 가공
        List<Integer> resultCount = new ArrayList<>();
        List<String> resultHit = new ArrayList<>();
        List<String> resultPrize = new ArrayList<>();

        for (int index :
                RESULT_INDEX) {
            resultCount.add(lottoCal.getPrizeCount().get(index));
            resultHit.add(LottoRate.getPlace(index).getHit());
            resultPrize.add(LottoRate.getPlace(index).getPrize());
        }
        rateView.printPrize(resultCount, resultHit, resultPrize);

        RateCal rateCal = new RateCal(lottoCal.getPrizeCount());
        String formatResult = String.format("%.2f", rateCal.getReturnRate(userLottoPrice.getPrice()));
        rateView.printRate(formatResult);

    }


}
