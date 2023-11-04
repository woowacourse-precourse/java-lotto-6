package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.InputMessage;

public class LottoController {
    public static void start() {
        int purchaseAmount = getUserPurchaseAmount();
        int lottoTicketCount = purchaseAmount / 1000;
        LottoView.printLottoTicketCount(lottoTicketCount);

        List<List<Integer>> lottoTickets = generateLottoTickets(lottoTicketCount);
        List<Integer> lottoNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(lottoNumbers);

        LottoModel model = new LottoModel(lottoTickets, lottoNumbers, bonusNumber, purchaseAmount);
        model.calculatePrize();
        model.displayStatistics();
    }

    private static int getUserPurchaseAmount() {
        int purchaseAmount = 0;

        while (true) {
            try {
                System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
                String input = Console.readLine();

                if (!input.matches("[1-9]\\d*")) {
                    if (input.matches("[-]\\d+")) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_PURCHASE.getMessage());
                    }
                    if (input.matches("0+")) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_PURCHASE.getMessage());
                    }
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
                }

                purchaseAmount = Integer.parseInt(input);

                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
    }

    private static List<List<Integer>> generateLottoTickets(int ticketCount) {
        List<List<Integer>> allLotto = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> oneLotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(oneLotto);
            System.out.print("[");
            for (int j = 0; j < oneLotto.size(); j++) {
                if (j == oneLotto.size() - 1) {
                    System.out.println(oneLotto.get(j) + "]");
                    break;
                }
                System.out.print(oneLotto.get(j) + ", ");
            }
            allLotto.add(oneLotto);
        }
        System.out.println();
        return allLotto;
    }

    private static List<Integer> getWinningNumbers() {
        List<Integer> lottoNumbers;
        while (true) {
            try {
                System.out.println(InputMessage.LOTTO_NUMBERS.getMessage());
                String[] numbers = Console.readLine().split(",");
                lottoNumbers = new ArrayList<>();

                for (int i = 0; i < numbers.length; i++) {
                    try {
                        int number = Integer.parseInt(numbers[i]);
                        lottoNumbers.add(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC.getMessage());
                    }
                }
                Lotto lotto = new Lotto(lottoNumbers);
                return lottoNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumber(List<Integer> lottoNumbers) {
        System.out.println();
        int bonusNumber;
        while (true) {
            try {
                System.out.println(InputMessage.BONUS_NUMBER.getMessage());
                String input = Console.readLine();

                try {
                    bonusNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
                }

                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
                }

                if (lottoNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_DUPLICATE.getMessage());
                }

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

