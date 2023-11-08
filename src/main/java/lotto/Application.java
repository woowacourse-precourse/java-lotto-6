package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Cashier;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumberConverter;

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
