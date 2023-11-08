package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import lotto.domain.Cashier;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumberConverter;
import lotto.domain.LottoNumbers;
import lotto.domain.PrizeCategory;
import lotto.domain.WinningResult;

public class Application {
    private static final MessageContainer messageContainer = new MessageContainer();
    private static final LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();

    public static void main(String[] args) {
        Cashier cashier = getPurchaseAmountAndCreateCashier();

        List<Lotto> lottoTickets = createLottoTickets(cashier);

        List<Integer> winningNumbers = getWinningNumbers();
        Integer bonusNumber = getBonusNumber();
        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);

        printWinningResults(lottoTickets, lottoNumbers, cashier);
    }

    private static Cashier getPurchaseAmountAndCreateCashier() {
        Cashier cashier;

        while (true) {
            System.out.println(messageContainer.getEnterPurchaseAmount());
            try {
                cashier = new Cashier(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println();
            break;
        }

        return cashier;
    }

    private static List<Lotto> createLottoTickets(Cashier cashier) {
        long purchaseQuantity = cashier.getPurchaseQuantity();
        System.out.println(messageContainer.getPurchaseQuantityMessage(purchaseQuantity));

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> lottoNumbers = lottoGenerator.issueLottoAsManyAsPurchased(purchaseQuantity);
        printLottoNumbers(lottoNumbers);

        return Lotto.createLottoTickets(lottoNumbers);
    }

    private static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers.toString());
        }
        System.out.println();
    }

    private static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            System.out.println(messageContainer.getEnterWinningNumbers());
            try {
                winningNumbers = lottoNumberConverter.convertWinningNumbers(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println();
            break;
        }

        return winningNumbers;
    }

    private static Integer getBonusNumber() {
        int bonusNumber;
        while (true) {
            System.out.println(messageContainer.getEnterBonusNumbers());
            try {
                bonusNumber = lottoNumberConverter.convertBonusNumber(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.println();
            break;
        }

        return bonusNumber;
    }

    private static void printWinningResults(List<Lotto> lottoTickets, LottoNumbers lottoNumbers, Cashier cashier) {
        WinningResult winningResult = new WinningResult();
        Map<PrizeCategory, Integer> winningCounts = winningResult.countNumberOfWinning(lottoTickets, lottoNumbers);

        System.out.println(messageContainer.getWinningStatistics());
        System.out.println(createWinningCountsResult(winningCounts));

        long totalPrizeMoney = winningResult.getTotalPrizeMoney(winningCounts);
        double rateOfReturn = winningResult.getRateOfReturn(cashier.getPurchaseAmount(), totalPrizeMoney);
        System.out.println(messageContainer.createRateOfReturnMessage(rateOfReturn));
    }

    private static String createWinningCountsResult(Map<PrizeCategory, Integer> winningCounts) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        for (String winningDetail : messageContainer.createWinningDetails(winningCounts)) {
            stringJoiner.add(winningDetail);
        }
        return stringJoiner.toString();
    }
}
