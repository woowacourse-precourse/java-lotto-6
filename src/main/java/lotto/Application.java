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
    public static void main(String[] args) {
        MessageContainer messageContainer = new MessageContainer();
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

        List<Lotto> lottoTickets = createLottoTickets(cashier, messageContainer);

        LottoNumberConverter lottoNumberConverter = new LottoNumberConverter();
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

        Integer bonusNumber;
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

        LottoNumbers lottoNumbers = new LottoNumbers(winningNumbers, bonusNumber);
        WinningResult winningResult = new WinningResult();
        Map<PrizeCategory, Integer> winningCounts = winningResult.countNumberOfWinning(lottoTickets, lottoNumbers);

        System.out.println(messageContainer.getWinningStatistics());

        StringJoiner stringJoiner = new StringJoiner("\n");
        for (String winningDetail : messageContainer.createWinningDetails(winningCounts)) {
            stringJoiner.add(winningDetail);
        }
        System.out.println(stringJoiner.toString());

        long totalPrizeMoney = winningResult.getTotalPrizeMoney(winningCounts);
        double rateOfReturn = winningResult.getRateOfReturn(cashier.getPurchaseAmount(), totalPrizeMoney);
        System.out.println(messageContainer.createRateOfReturnMessage(rateOfReturn));
    }

    private static List<Lotto> createLottoTickets(Cashier cashier, MessageContainer messageContainer) {
        long purchaseQuantity = cashier.getPurchaseQuantity();
        System.out.println(messageContainer.getPurchaseQuantityMessage(purchaseQuantity));
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> lottoNumbers = lottoGenerator.issueLottoAsManyAsPurchased(purchaseQuantity);
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers.toString());
        }
        System.out.println();
        return Lotto.createLottoTickets(lottoNumbers);
    }
}
