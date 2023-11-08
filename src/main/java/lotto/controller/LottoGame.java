package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoTicketsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputWinningNumbers;
import static lotto.view.OutputView.printErrorMessage;

public class LottoGame {

    public void run() {
        LottoPurchaseMoney lottoPurchaseMoney = getLottoPurchaseMoney();

        LottoTickets lottoTickets = purchaseLottoTickets(lottoPurchaseMoney.getAvailablePurchaseCount());

        OutputView.printLottoTickets(new LottoTicketsDto(lottoTickets));

        WinningNumbers winningNumbers = getWinningNumbersWithBonusNumber();

        LottoResult lottoResult = getLottoResult(winningNumbers, lottoTickets);

        OutputView.printLottoResult(lottoResult, lottoPurchaseMoney);
    }

    public LottoPurchaseMoney getLottoPurchaseMoney() {
        try {
            int money = InputView.inputPurchaseMoney();
            return new LottoPurchaseMoney(money);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getLottoPurchaseMoney();
        }
    }

    public LottoTickets purchaseLottoTickets(int ticketNumber) {
        try {
            List<LottoTicket> lottoTickets = new ArrayList<>();
            for (int count = 0; count < ticketNumber; count++) {
                lottoTickets.add(generateLottoTicket());
            }
            return new LottoTickets(lottoTickets);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return purchaseLottoTickets(ticketNumber);
        }
    }

    private LottoTicket generateLottoTicket() {
        return new LottoTicket(NumberGenerator.generate());
    }

    public WinningNumbers getWinningNumbersWithBonusNumber() {
        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber(winningNumbers);
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        try {
            return inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    private Integer getBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = inputBonusNumber();
            if (winningNumbers.contains(bonusNumber))
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    public LottoResult getLottoResult(WinningNumbers winningNumbers, LottoTickets lottoTickets) {
        List<Rank> winningRanks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            winningRanks.add(winningNumbers.getRank(lottoTicket));
        }
        return new LottoResult(winningRanks);
    }

}
