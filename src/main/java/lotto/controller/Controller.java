package lotto.controller;

import lotto.domain.*;
import lotto.util.LottoBonusNumberValidator;
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

    private static List<Integer> lottoNumberList;
    private static List<Integer> winningNumber;
    private static List<Lotto> lottoList;
    private static LottoPrice lottoPlayer;
    private static WinningResult winningResult;
    private static int inputBonusNumber;

    public void run() {
        start();
    }

    public void start() {
        int ticketCount = inputTotalPrice();
        OutputView.responseLottoCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = new WinningResult(new Lotto(inputLottoWinningNumber()), inputBonusNumber());

        lottoFinalResult(ticketCount);
    }

    private void lottoFinalResult(int ticketCount) {
        Map<Rank, Integer> result = new LinkedHashMap<>();

        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        OutputView.responseWinningResult();
        for (int i = 0; i < ticketCount; i++) {
            Rank rank = winningResult.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }

        responseResult(result);
        responseEarningRate(result, ticketCount);
    }

    private static List<Integer> inputLottoWinningNumber() {
        try {
            Lotto lotto = new Lotto(InputView.requestLottoWinningNumber());
            winningNumber = lotto.getLottoNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputLottoWinningNumber();
        }
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
        try {
            lottoPlayer = new LottoPrice(InputView.requestLottoBuyingPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputTotalPrice();
        }
        return lottoPlayer.calculateCountOfLotto();
    }

    private int inputBonusNumber() {
        try {
            inputBonusNumber = InputView.requestLottoBonusNumber();
            LottoBonusNumberValidator.validateBonusNumber(inputBonusNumber, winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
        return inputBonusNumber;
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        lottoNumberList = LottoRandomNumber.getRandomNumbers();
        OutputView.responseLottoRandomNumber(lottoNumberList);
        return new Lotto(lottoNumberList);
    }

}
