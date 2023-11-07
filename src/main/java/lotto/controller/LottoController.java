package lotto.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.Converter;
import lotto.checker.BonusNumberChecker;
import lotto.checker.InputChecker;
import lotto.checker.PaymentPriceChecker;
import lotto.checker.WinningNumbersChecker;
import lotto.constant.Number;
import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.service.LottoReader;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

// TODO : service 나누기
public class LottoController {

    long paymentPrice;
    long ticketCount;
    List<Lotto> lottos;

    List<Integer> winningNumbers;
    int bonusNumber;
    Statistic statistic = new Statistic();

    public void start() throws IllegalArgumentException {
        callPaymentPriceLoop();
        winningNumbers = getWinningNumbersLoop();
        bonusNumber = getBonusNumberLoop();
        setStatic(lottos);
        OutputHandler.showWinningDetails(statistic.getRank(1), statistic.getRank(2), statistic.getRank(3),
                statistic.getRank(4),
                statistic.getRank(5));
        showRateOfReturn(statistic, paymentPrice);
    }

    void callPaymentPriceLoop() {
        try {
            paymentPrice = getPaymentPrice();
            ticketCount = getTicketCount(paymentPrice);
            OutputHandler.sayTicketCount(ticketCount);
            lottos = issueLottos(ticketCount);
        } catch (IllegalArgumentException e) {
            callPaymentPriceLoop();
        }
    }

    long getPaymentPrice() throws IllegalArgumentException {
        OutputHandler.requirePaymentPrice();
        String paymentPriceInput = InputHandler.getInput();
        long paymentPrice = Converter.pay(paymentPriceInput);
        PaymentPriceChecker paymentPriceChecker = new PaymentPriceChecker(paymentPrice);
        paymentPriceChecker.positive();
        OutputHandler.printEmptyLine();
        return paymentPrice;
    }

    long getTicketCount(long paymentPrice) throws IllegalArgumentException {
        PaymentPriceChecker paymentPriceChecker = new PaymentPriceChecker(paymentPrice);
        paymentPriceChecker.positive();
        paymentPriceChecker.multipleOfPrice();
        return paymentPrice / Number.LOTTO_PRICE.getNumber();
    }

    List<Lotto> issueLottos(long ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            OutputHandler.printLottoNumbers(lotto.getNumbers());
        }
        OutputHandler.printEmptyLine();
        return lottos;
    }

    List<Integer> getWinningNumbersLoop() {
        try {
            return getWinningNumbers();
        } catch (IllegalArgumentException e) {
            return getWinningNumbersLoop();
        }
    }

    List<Integer> getWinningNumbers() throws IllegalArgumentException {

        OutputHandler.requireWinningNumbers();
        String winningNumbersInput = InputHandler.getInput();
        List<Integer> winningNumbers = Converter.winningNumbers(winningNumbersInput);
        winningNumbers.sort(Comparator.naturalOrder());
        WinningNumbersChecker winningNumbersChecker = new WinningNumbersChecker(winningNumbers);
        winningNumbersChecker.rightSize();
        winningNumbersChecker.rightNumbers();
        OutputHandler.printEmptyLine();
        return winningNumbers;
    }

    int getBonusNumberLoop() {
        try {
            return getBonusNumber();
        } catch (IllegalArgumentException e) {
            return getBonusNumberLoop();
        }
    }

    int getBonusNumber() throws IllegalArgumentException {
        OutputHandler.requireBonusNumber();
        String bonusNumberInput = InputHandler.getInput();
        InputChecker.nonEmpty(bonusNumberInput);
        int bonusNumber = Converter.bonusNumbers(bonusNumberInput);
        BonusNumberChecker bonusNumberChecker = new BonusNumberChecker(bonusNumber);
        bonusNumberChecker.rightRange();
        bonusNumberChecker.differentFrom(winningNumbers);
        OutputHandler.printEmptyLine();
        return bonusNumber;
    }

    void setStatic(List<Lotto> lottos) throws IllegalArgumentException {
        for (Lotto lotto : lottos) {
            LottoReader lottoReader = new LottoReader(lotto, winningNumbers, bonusNumber);
            Integer rank = lottoReader.getRank();
            statistic.addRank(rank);
        }
    }

    void showRateOfReturn(Statistic statistic, long paymentPrice) {
        long winningPrize = getWinningPrize(statistic);
        double rateOfReturn = (double) winningPrize / paymentPrice;
        OutputHandler.printRateOfReturn(rateOfReturn);
    }

    long getWinningPrize(Statistic statistic) {
        return statistic.getRank(1) * (long) Number.RANK1_PRIZE.getNumber()
                + statistic.getRank(2) * (long) Number.RANK2_PRIZE.getNumber()
                + statistic.getRank(3) * (long) Number.RANK3_PRIZE.getNumber()
                + statistic.getRank(4) * (long) Number.RANK4_PRIZE.getNumber()
                + statistic.getRank(5) * (long) Number.RANK5_PRIZE.getNumber();
    }
}

