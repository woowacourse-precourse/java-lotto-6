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

public class LottoGameController {

    public void run() {
        Tickets tickets = buyTickets();
        OutputView.printNumberOfTickets(tickets.getNumberOfTickets());

        LottosDto lottosDto = Lotto.toLottosDto(tickets);
        OutputView.printLottoNumbers(lottosDto);

        Lotto winningLottoNumber = setWinningNumber();
        int bonusNumber = getBonusNumber(winningLottoNumber);

        ResultsDto resultsDto = Result.getAllLottoResult(lottosDto.lottos(), winningLottoNumber,
            bonusNumber);
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

    private int getBonusNumber(Lotto winningLottoNumber) {
        String bonusNumber = InputView.BonusNumber();
        try {
            int bonusNumberInt = parseStringToUnsignedInt(bonusNumber);
            validateBonusNumber(winningLottoNumber, bonusNumberInt);
            return bonusNumberInt;
        } catch (IllegalArgumentException e) {
            return getBonusNumber(winningLottoNumber);
        }
    }
}
