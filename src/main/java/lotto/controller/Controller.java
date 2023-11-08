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
        List<Integer> winningNumbers = getWinningNumbers();
        // 보너스 당첨 번호
        int bonusNumber = getBonusNumber();
        // 당첨 번호 + 보너스 번호
        List<Integer> winningNumbersWithBonusNumber = new WinningNumbersWithBonusNumber(winningNumbers, bonusNumber)
                .getWinningNumbersWithBonusNumber();

        int[] lotteryResults = new int[winningNumbers.size() + 1];

        WinningRecords winningRecords = new WinningRecords(lottoTickets, bonusNumber,
                winningNumbersWithBonusNumber, lotteryResults);

        lotteryResults = winningRecords.getLotteryResults();
        int matchFiveWithBonus = winningRecords.getMatchFiveWithBonus();

        output.printWinningStatistics(lotteryResults, matchFiveWithBonus);
    }

    private List<Integer> getWinningNumbers() {
        return new WinningNumbers(input.inputWinningNumbers()).getWinnerNumbers();
    }

    private int getBonusNumber() {
        return new BonusWinningNumber(input.inputBonusNumber()).getBonusNumber();
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
