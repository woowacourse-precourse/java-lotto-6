package lotto.domain;

import lotto.view.ExceptionMessage;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoGame {
    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;


    public void start() {
        int ticketCount = setPlayerAmount();
        lottoList = setLottoList(ticketCount);

        winningResult = setWinningNumber();

        lottoResult(lottoList, winningResult, ticketCount);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningResult, int ticketCount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningResult.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, ticketCount);
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i--) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * 1000) * (result.get(
                            rank)) * (100));

        }
        OutputView.printRevenueRate(EarningRate);
    }

    private WinningResult setWinningNumber() {
        Lotto lotto;
        try {lotto = new Lotto(InputView.inputWinningNumbers());
        } catch (IllegalArgumentException e) {
            ExceptionMessage.wrongValueException();
            lotto = new Lotto(InputView.inputWinningNumbers());
        }
        List<Integer> winningNumbers = lotto.getLottoNumbers();

        int bonusNumber = setBonusNumber(lotto, winningNumbers);

        winningResult = new WinningResult(new Lotto(winningNumbers), bonusNumber);
        return winningResult;
    }

    private int setBonusNumber(Lotto lotto, List<Integer> winningNumbers) {
        int bonusNumber = InputView.inputBonusNumber();
        try {
            lotto.validateBonusNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            ExceptionMessage.wrongValueException();
            lotto.validateBonusNumber(winningNumbers, bonusNumber);
        }
        return bonusNumber;
    }

    private List<Lotto> setLottoList(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(setLotto());
        }
        return lottoList;
    }

    private Lotto setLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = LottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private int setPlayerAmount() {
        int ticketCount = inputPlayerAmount();
        OutputView.printLottoCount(ticketCount);
        return ticketCount;
    }

    private int inputPlayerAmount() {
        try {
            playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        } catch (IllegalArgumentException e) {
            ExceptionMessage.wrongValueException();
            playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        }
        return playerLottoAmount.purchaseTicketCount();
    }
}
