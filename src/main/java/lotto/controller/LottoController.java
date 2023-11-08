package lotto.controller;

import static lotto.constant.Number.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.checker.BonusNumberChecker;
import lotto.checker.PaymentPriceChecker;
import lotto.checker.WinningNumbersChecker;
import lotto.domain.Lotto;
import lotto.domain.Statistic;
import lotto.service.Converter;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoReader;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class LottoController {

    private long paymentPrice;
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private BonusNumberChecker bonusNumberChecker;
    private LottoReader lottoReader;
    private Statistic statistic;

    public void start() throws IllegalArgumentException {
        buyLottos();
        setWinningNumber();
        printStatistic();
    }

    private void buyLottos() {
        long ticketCount = getTicketCountLoop();
        OutputHandler.sayTicketCount(ticketCount);
        lottos = getLottos(ticketCount);
    }

    private long getTicketCountLoop() {
        try {
            return getTicketCount();
        } catch (IllegalArgumentException e) {
            return getTicketCountLoop();
        }
    }

    private long getTicketCount() throws IllegalArgumentException {
        OutputHandler.requirePaymentPrice();
        String paymentPriceInput = InputHandler.getInput();
        paymentPrice = Converter.paymentPrice(paymentPriceInput);
        PaymentPriceChecker.positive(paymentPrice);
        PaymentPriceChecker.multipleOfPrice(paymentPrice);
        OutputHandler.printEmptyLine();
        return paymentPrice / LOTTO_PRICE.getNumber();
    }

    private List<Lotto> getLottos(long ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> numbers;
        for (int i = 0; i < ticketCount; i++) {
            numbers = lottoNumberGenerator.getNumbers();
            lottos.add(new Lotto(numbers));
            OutputHandler.printLottoNumbers(numbers);
        }
        OutputHandler.printEmptyLine();
        return lottos;
    }

    private void setWinningNumber() {
        winningNumbers = getWinningNumbersLoop();
        bonusNumber = getBonusNumberLoop();
    }

    private List<Integer> getWinningNumbersLoop() {
        try {
            return getWinningNumbers();
        } catch (IllegalArgumentException e) {
            return getWinningNumbersLoop();
        }
    }

    private List<Integer> getWinningNumbers() throws IllegalArgumentException {
        OutputHandler.requireWinningNumbers();
        String winningNumbersInput = InputHandler.getInput();
        List<Integer> winningNumbers = Converter.winningNumbers(winningNumbersInput);
        winningNumbers.sort(Comparator.naturalOrder());
        WinningNumbersChecker.rightSize(winningNumbers);
        WinningNumbersChecker.rightNumbers(winningNumbers);
        OutputHandler.printEmptyLine();
        return winningNumbers;
    }

    private int getBonusNumberLoop() {
        try {
            return getBonusNumber();
        } catch (IllegalArgumentException e) {
            return getBonusNumberLoop();
        }
    }

    private int getBonusNumber() throws IllegalArgumentException {
        OutputHandler.requireBonusNumber();
        String bonusNumberInput = InputHandler.getInput();
        int bonusNumber = Converter.bonusNumbers(bonusNumberInput);
        BonusNumberChecker.rightRange(bonusNumber);
        BonusNumberChecker.differentFrom(bonusNumber, winningNumbers);
        OutputHandler.printEmptyLine();
        return bonusNumber;
    }

    private void printStatistic() throws IllegalArgumentException {
        lottoReader = new LottoReader(lottos, winningNumbers, bonusNumber);
        statistic = lottoReader.getStatistic();
        statistic.printWinningDetails();
        statistic.printEarningRate(paymentPrice);
    }
}

