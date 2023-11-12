package lotto.controller;

import lotto.model.*;
import lotto.model.Number;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private static List<Lotto> boughtLotto;
    private static List<Integer> lotto;
    private static int count;

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    public LottoController(InputView inputView,OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLotto(){
        inputCountMakeLotto();

        List<Integer> splittedNumber = inputView.readLotto();
        Lotto lotto = new Lotto(splittedNumber);

        int bonusNumber = inputView.readBonusNumber();
        WinningResult winningResult = new WinningResult(lotto,bonusNumber);

        lottoResult(boughtLotto,winningResult,count);
    }

    private void inputCountMakeLotto(){
        String price = inputView.readPrice();
        LottoAmount amount = new LottoAmount(price);
        count = amount.calculateLottoCount();
        outputView.printTicketCount(count);
        boughtLotto = makeLottoList(count);
    }

    public void lottoResult(List<Lotto> lottoList, WinningResult winningResult, int amount){
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printSuccessResult();
        for (int i=0;i<lottoList.size(); i++){
            rank = winningResult.match(lottoList.get(i));
            result.put(rank,result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result,amount);
    }

    public void printResult(Map<Ranking, Integer> result){
        for (int i = Ranking.values().length - 1;i>= 0;i--){
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    public void printEarningRate(Map<Ranking,Integer> result, int lottoAmount){
        double EarningRate = 0;
        for (Ranking rank : result.keySet()){
            EarningRate = EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(
                    rank)) * (PERCENTAGE));
        }
        outputView.printRevenueRate(EarningRate);
    }

    private Map<Ranking,Integer> setResult(){ //enum 값 가져옴
        Map<Ranking,Integer> result = new LinkedHashMap<>();

        for (Ranking rank: Ranking.values()){
            result.put(rank,0);
        }
        return result;
    }

    private List<Lotto> makeLottoList(int ticketCount){
        boughtLotto = new ArrayList<>();
        for (int i=0;i<ticketCount;i++){
            boughtLotto.add(makeLottos());
        }
        return boughtLotto;
    }

    private Lotto makeLottos(){
        Number lottoNumber = new Number();
        lotto = new ArrayList<>();
        lotto = lottoNumber.createNumbers();
        outputView.printLottoNumber(lotto);
        return new Lotto(lotto);
    }
}
