package lotto.controller;

import jdk.jfr.Percentage;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    public Controller() {

    }

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static List<Integer> lottoNumberList = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static LottoPlayer lottoPlayer;
    private static WinningResult winningResult;
    public void run() {
        start();
    }

    //start
    public void start() {

        //로또 구매 갯수 구하기 -> service
        int ticketCount = inputTotalPrice();
        OutputView.responseLottoCount(ticketCount);

        //로또 갯수당 랜덤 넘버 이용해서 로또 번호 출력 -> outputview
        lottoList = makeLottoList(ticketCount);

        //로또 당첨 번호 입력
        List<Integer> winningNumber = inputLottoWinningNumber();

        //로또 보너스 번호 입력
        int bonusNumber = InputView.requestLottoBonusNumber();

        //로또 번호와 당첨 번호 비교하기 -> service
        winningResult = new WinningResult(new Lotto(winningNumber), bonusNumber);

        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }


        OutputView.responseWinningResult();
        for (int i = 0; i < ticketCount; i++) {
            Rank rank = winningResult.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }

        //당첨 내역 출력 -> outputview
        responseResult(result);

        //수익률 구하기 -> service, 수익률 출력 -> outputview
        responseEarningRate(result, ticketCount);

    }

    private static List<Integer> inputLottoWinningNumber() {
        Lotto lotto = new Lotto(InputView.requestLottoWinningNumber());
        List<Integer> winningNumber = lotto.getLottoNumbers();
        return winningNumber;
    }

    private void responseEarningRate(Map<Rank, Integer> result, int ticketCount) {
        double EarningRate = 0;
        for (Rank rank : result.keySet()) {
            EarningRate = EarningRate + ((double) (rank.getWinningPrice()) / (ticketCount * TICKET_PRICE) * (result.get(rank))) * (PERCENTAGE);
        }
        OutputView.responseRateOfReturn(EarningRate);
    }

    private void responseResult(Map<Rank, Integer> result) {
        for (int i = Rank.values().length - 1; i >= 0; i--) {
            Rank.values()[i].responseMessage(result.get(Rank.values()[i]));
        }

    }

    private int inputTotalPrice() {
        lottoPlayer = new LottoPlayer(InputView.requestLottoBuyingPrice());
        return lottoPlayer.calculateCountOfLotto();
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumberList = new ArrayList<>();

        lottoNumberList = lottoNumber.getRandomNumbers();
        System.out.println("lottoNumberList = " + lottoNumberList);
        OutputView.responseLottoRandomNumber(lottoNumberList);
        return new Lotto(lottoNumberList);
    }

}
