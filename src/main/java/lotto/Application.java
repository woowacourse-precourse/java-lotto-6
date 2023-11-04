package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchase = 0;

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

                purchase = Integer.parseInt(input);

                if (purchase % 1000 != 0) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        int lottoTicket = purchase / 1000;
        System.out.println(lottoTicket + InputMessage.LOTTO_TICKET_COUNT.getMessage());

        List<List<Integer>> allLotto = new ArrayList<>();
        for (int i = 0; i < lottoTicket; i++) {
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

        List<Integer> lottoNumbers;
        while (true) {
            try {
                System.out.println();
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
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                System.out.println();
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

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Integer> lucky = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (int i = 0; i < lottoTicket; i++) {
            int sameNumberCount = 0;
            for (int number : lottoNumbers) {
                if (allLotto.get(i).contains(number)) {
                    sameNumberCount++;
                }
            }

            if (sameNumberCount == 3) {
                lucky.set(0, lucky
                        .get(0) + 1);
            }
            if (sameNumberCount == 4) {
                lucky.set(1, lucky
                        .get(1) + 1);
            }
            if (sameNumberCount == 5) {
                if (!allLotto.get(i).contains(bonusNumber)) {
                    lucky.set(2, lucky
                            .get(2) + 1);
                } else {
                    lucky.set(3, lucky
                            .get(3) + 1);
                }
            }
            if (sameNumberCount == 6) {
                lucky.set(4, lucky
                        .get(4) + 1);
            }
        }
        double sumPrize = 0;
        sumPrize += 5000 * lucky.get(0);
        sumPrize += 50000 * lucky.get(1);
        sumPrize += 1500000 * lucky.get(2);
        sumPrize += 30000000 * lucky.get(3);
        sumPrize += 2000000000 * lucky.get(4);

        double beforeRate = sumPrize / purchase * 100;
        double rate = Math.round(beforeRate * 10.0) / 10.0;

        System.out.println();
        System.out.println(OutputMessage.LOTTO_STATISTICS.getMessage());
        System.out.println(OutputMessage.LINE_SEPARATOR.getMessage());

        for (int i = 0; i < lucky.size(); i++) {
            System.out.println(String.format(OutputMessage.values()[i + 2].getMessage(), lucky.get(i)));
        }
        System.out.println(String.format(OutputMessage.PROFIT_RATE.getMessage(), rate));

    }
}
