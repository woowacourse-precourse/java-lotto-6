package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import domain.Place;
import service.LottoService;
import view.InputView;
import view.OutputView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private LottoService lottoService;
    public static final int LOTTO_PRICE = 1000;

    public void lottoStart(){

        int purchasePrice = InputView.inputPurchasePrice();

        int numberOfLotto = getNumberOfLotto(purchasePrice);
        OutputView.outputNumberOfLotto(numberOfLotto);

        lottoService = new LottoService(numberOfLotto);

        List<List<Integer>> lottos = getLottos(numberOfLotto);
        OutputView.outputLottos(lottos);
        addLotto(lottos);

        List<Integer> winningNumber = InputView.inputWinningNumber();
        Lotto winningLotto = new Lotto(winningNumber);

        int bonusNumber = InputView.inputBonusNumber(winningNumber);
        Map<Place, Integer> numberOfWins = lottoService.numberOfWins(winningLotto, bonusNumber);

        OutputView.outputStatics(numberOfWins);

        Long profit = getProfit(numberOfWins);

        double rate = getRate(purchasePrice,profit);

        OutputView.outputRate(rate);
    }

    public double getRate(int purchasePrice, Long profit){
        double rate = ((double) profit / purchasePrice) * 100;
        BigDecimal bd = new BigDecimal(rate);
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    private Long getProfit(Map<Place, Integer> numberOfWins) {
        Place[] places = Place.values();
        Long[] winningPrice = {5000L,50000L,1500000L,30000000L,2000000000L};
        Long profit = 0L;
        for(int i=0; i< winningPrice.length; i++){
            profit += winningPrice[i] * numberOfWins.get(places[i]);
        }
        return profit;
    }


    private void addLotto(List<List<Integer>> lottos) {
        for(List<Integer> lottoList: lottos){
            Lotto lotto = new Lotto(lottoList);
            lottoService.addLotto(lotto);
        }
    }

    private int getNumberOfLotto(int purchasePrice) {
        return purchasePrice / LOTTO_PRICE;
    }

    public List<List<Integer>> getLottos(int numberOfLotto){
        List<List<Integer>> lottos = new ArrayList<>(numberOfLotto);

        for(int i=0; i<numberOfLotto; i++){
            List<Integer> lotto;
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(lotto);
        }

        return lottos;
    }


}
