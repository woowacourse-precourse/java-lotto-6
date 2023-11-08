package lotto.controller;

import lotto.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.PlayerLottoAmount;
import lotto.domain.Ranking;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class LottoController {
    public LottoController(){
    }

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;
    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;

    public void start() {
        int ticketCount = inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);

        lottoList = makeLottoList(ticketCount);
        winningResult = validateBonus();
    }

    // 발행할 로또 개수의 금액 입력 메소드
    public int inputPlayerAmount(){
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPurchaseAmount());
        return playerLottoAmount.calculateLottoCount();
    }

    // 보너스 번호 검증 하기
    public WinningResult validateBonus() {
        Lotto lotto = new Lotto(InputView.inputLottoWinningNumber());
        List<Integer> winningNumber = lotto.getLottoNumbers();

        int bonus = InputView.inputBonusNumber();
        lotto.validateBonusNumber(winningNumber, bonus);
        return  new WinningResult(new Lotto(winningNumber), bonus);
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printSuccessResult();
        for (Lotto lotto : lottoList) {
            rank = winningLotto.match(lotto);
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()){
            result.put(rank, 0);
        }
        return result;
    }

    private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double earningRate = 0;
        for (Ranking rank : result.keySet()){
            earningRate = earningRate + ((double) (rank.getWinningAmount()) /
                    (lottoAmount * TICKET_PRICE) * (result.get(rank)) * (PERCENTAGE));
        }
        OutputView.printRevenuRate(earningRate);
    }
}
