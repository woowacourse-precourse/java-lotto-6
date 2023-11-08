package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;


public class Controller {

    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void lottoGame() {
        int insertedMoney = input.insertMoney();

        NumberOfLottoTickets numberOfLottoTickets = new NumberOfLottoTickets(insertedMoney);
        int countLottoTickets = numberOfLottoTickets.getCountLottoTickets();

        // 발행된 전체 로또
        List<List<Integer>> lottoTickets = getLottoTicketsTickets(countLottoTickets);
        output.printLottoTickets(lottoTickets);

        // 당첨 번호 입력받기
        List<Integer> winningNumbers = new Lotto(input.inputWinningNumbers()).getWinnerNumbers();
        // 보너스 당첨 번호
        int bonusNumber = new BonusWinningNumber(input.inputBonusNumber()).getBonusNumber();
        // 당첨 번호 + 보너스 번호
        List<Integer> winningNumbersWithBonusNumber = new WinningNumbersWithBonusNumber(winningNumbers, bonusNumber)
                .getWinningNumbersWithBonusNumber();

        // 당첨 통계 산출
        WinningRecords winningRecords = new WinningRecords(lottoTickets, bonusNumber, winningNumbersWithBonusNumber);
        int[] lotteryResults = winningRecords.getLotteryResults();
        int matchFiveWithBonus = winningRecords.getMatchFiveWithBonus();

        output.printWinningStatistics(lotteryResults, matchFiveWithBonus);

        // 수익률 계산 및 출력
        int winningPrize = calculateWinningPrize(lotteryResults);
        double rateOfReturn = calculateRateOfReturn(winningPrize, countLottoTickets);
        RateOfReturn yieldRateOfReturn = new RateOfReturn(winningPrize, rateOfReturn);

        output.printRateOfReturn(rateOfReturn);

    }

    private int calculateWinningPrize(int[] lotteryResults) {
        return (lotteryResults[3] * 5000) + (lotteryResults[4] * 50000) + (lotteryResults[5] * 1500000) + (lotteryResults[6] * 2000000000);
    }

        private double calculateRateOfReturn(int winningPrize, int numberOfLottoTickets) {
        return (double) winningPrize / (numberOfLottoTickets * 1000) * 100;
    }

    private List<List<Integer>> getLottoTicketsTickets(int countLottoTickets) {
        List<List<Integer>> lottoTickets = new ArrayList<>();
        for (int index = 0; index < countLottoTickets; index++) {
            List<Integer> lottoNumbers = new LottoTicket().getLottoNumbers();
            new LottoTickets(lottoTickets, lottoNumbers);
        }
        return lottoTickets;
    }

}
