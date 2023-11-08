package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.NumberConstants.*;
import static lotto.StringConstants.*;
import static lotto.Validator.*;
import static lotto.InputView.*;
import static lotto.OutputView.*;

public class GameController {
    public void run() {
        BuyingLotto buyingLotto = doBuyingLotto();
        List<Lotto> lottos = receiveLottos(buyingLotto.getTicketNumber());
        WinningNumbers winningNumbers = receiveWinningNumbers();
        PrizeStats prizeStats = receivePrizeStats(lottos, winningNumbers);
        PrizeProfit prizeProfit = receivePrizeProfit(prizeStats, buyingLotto.getBuyingPrice());
    }

    private BuyingLotto doBuyingLotto() {
        while (true) {
            String input = BUYING_PRICE.scan();
            try {
                validateNumberString(input);
                BuyingLotto buyingLotto = new BuyingLotto(Integer.parseInt(input));
                printTicketNumber(buyingLotto.getTicketNumber());
                return buyingLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> receiveLottos(long ticketNumber) {
        List<Lotto> lottos = new LottoGenerator(ticketNumber).getLottos();
        printLottoNumbers(lottos);
        return lottos;
    }

    private WinningNumbers receiveWinningNumbers() {
        Lotto winningLotto = winningLottoFromInput();
        int bonusNumber = bonusNumberFromInput(winningLotto);
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private Lotto winningLottoFromInput() {
        while (true) {
            String input = WINNING_NUMBERS.scan();
            try {
                validateNumberCommaString(input);
                return new Lotto(inputToNumbers(input));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int bonusNumberFromInput(Lotto winningLotto) {
        while (true) {
            String input = BONUS_NUMBER.scan();
            try {
                validateNumberString(input);
                int bonusNumber = Integer.parseInt(input);
                validateRange(bonusNumber, MIN_NUMBER, MAX_NUMBER);
                validateDuplicates(winningLotto, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private PrizeStats receivePrizeStats(List<Lotto> lottos, WinningNumbers winningNumbers) {
        PrizeStats prizeStats = new PrizeStats(lottos, winningNumbers);
        printPrizeStats(prizeStats.getGradeDist());
        return prizeStats;
    }

    private PrizeProfit receivePrizeProfit(PrizeStats prizeStats, int buyingPrice) {
        PrizeProfit prizeProfit = new PrizeProfit(prizeStats, buyingPrice);
        printProfitRate(prizeProfit.getRate());
        return prizeProfit;
    }

    private List<Integer> inputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String splitInput : input.split(COMMA)) {
            numbers.add(Integer.parseInt(splitInput));
        }
        Collections.sort(numbers);
        return numbers;
    }
}
