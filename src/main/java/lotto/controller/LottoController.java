package lotto.controller;

import lotto.view.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoWinner;



public class LottoController {

    //생성자:객체 초기화, 매개변수 전달, 오버로딩,상속,에러처리

    //상수
    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static PlayerLotto playerLotto;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static LottoWinner lottoWinner;



    public void run(){
        try {
            start();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
       }
    }
   public void start(){
        int ticketCount = inputPlayerAmount();
   }






    public int inputPlayerAmount(){
        //클래스의 필드:클래스의 상태나 클래스의 객체의 데이터를 나타나는 변수
        //멤버변수라고도 하며, 클래스의 객첵가 가지는 데이터의 속성이나 상태를 나타난다
        PlayerLotto playerLotto = new PlayerLotto(InputView.inputPlayerAmount());
        return playerLotto.calLottoCount();
    }

    public LottoWinner validateBonus(){
        Lotto lotto = new Lotto(InputView.inputLottoWinningNum());
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int ball = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber, ball);
        lottoWinner = new LottoWinner(new Lotto(winningNumber), ball);

        return lottoWinner;
    }
    private static Lotto makeLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto>lottoList,LottoWinner lottoWinner, int amount){
        Map<LottoRanking, Integer> result = setResult();
        LottoRanking ranking;


        OutputView.printSuccessResult();
        for (Lotto value : lottoList) {
            LottoRanking Ranking = lottoWinner.match(value);
            result.put(Ranking, result.get(Ranking) + 1);

        }
        printResult(result);
        printEarningRate(result, amount);
    }
    private void printResult(Map<LottoRanking, Integer> result) {

        for (int i = LottoRanking.values().length-1; i >= 0 ; i--) {
            LottoRanking.values()[i].printMessage(result.get(LottoRanking.values()[i]));

        }
    }

    private void printEarningRate(Map<LottoRanking, Integer> result, int amount) {
        double EarningRate = 0;
        for (LottoRanking ranking : result.keySet()){
            EarningRate =   EarningRate + ((double) (ranking.getWinningAmount()) / (amount
                    * TICKET_PRICE) * (result.get(
                    ranking)) * (PERCENTAGE));
        }
        OutputView.printRevenueRate(EarningRate);
    }


    private Map<LottoRanking, Integer> setResult() {
        Map<LottoRanking, Integer> result = new LinkedHashMap<>();

        for (LottoRanking rank : LottoRanking.values()) {
            result.put(rank, 0);
        }
        return result;
    }



}
