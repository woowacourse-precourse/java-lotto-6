package lotto.controller;

import static lotto.global.Parser.parseStringToLotto;
import static lotto.global.Parser.parseStringToUnsignedInt;
import static lotto.global.Validator.validateBonusNumber;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.Tickets;
import lotto.dto.LottosDto;
import lotto.dto.ResultsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    public void run() {
        Tickets tickets = buyTickets();
        OutputView.printNumberOfTickets(tickets.getNumberOfTickets());

        LottosDto lottosDto = Lotto.toLottosDto(tickets);
        OutputView.printLottoNumbers(lottosDto);

        Lotto winningLottoNumber = setWinningNumber();
        int bonusNumber = setBonusNumber(winningLottoNumber);

        ResultsDto resultsDto =
                Result.getAllLottoResults(lottosDto.lottos(), winningLottoNumber, bonusNumber);
        OutputView.printWinningStatistics(resultsDto);

        double profitRate = Result.getProfitRate(resultsDto.results(), tickets.getUserMoney());
        OutputView.printProfitRate(profitRate);
    }

    private Tickets buyTickets() {
        String input = InputView.PurchaseAmount();
        try {
            int userMoney = parseStringToUnsignedInt(input);
            return Tickets.buyTickets(userMoney);
        } catch (IllegalArgumentException e) {
            return buyTickets();
        }
    }

    private Lotto setWinningNumber() {
        String input = InputView.WinningNumber();
        try {
            return parseStringToLotto(input);
        } catch (IllegalArgumentException e) {
            return setWinningNumber();
        }
    }

    private int setBonusNumber(Lotto winningLottoNumber) {
        String bonusNumber = InputView.BonusNumber();
        int bonusNumberInt = parseStringToUnsignedInt(bonusNumber);
        try {
            validateBonusNumber(winningLottoNumber, bonusNumberInt);
            return bonusNumberInt;
        } catch (IllegalArgumentException e) {
            return setBonusNumber(winningLottoNumber);
        }
    }
}