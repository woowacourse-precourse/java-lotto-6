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
                System.out.println("구입금액을 입력해 주세요.");
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
        System.out.println(lottoTicket + "개를 구매했습니다.");

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

        List<Integer> jackPot;
        while (true) {
            try {
                System.out.println();
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] numbers = Console.readLine().split(",");
                jackPot = new ArrayList<>();

                for (int i = 0; i < numbers.length; i++) {
                    try {
                        int number = Integer.parseInt(numbers[i]);
                        jackPot.add(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC.getMessage());
                    }
                }
                Lotto lotto = new Lotto(jackPot);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                System.out.println();
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();

                try {
                    bonusNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
                }

                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
                }

                if (jackPot.contains(bonusNumber)) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_DUPLICATE.getMessage());
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Integer> goodLuck = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        for (int i = 0; i < lottoTicket; i++) {
            int sameNumberCount = 0;
            for (int number : jackPot) {
                if (allLotto.get(i).contains(number)) {
                    sameNumberCount++;
                }
            }

            if (sameNumberCount == 3) {
                goodLuck.set(0, goodLuck.get(0) + 1);
            }
            if (sameNumberCount == 4) {
                goodLuck.set(1, goodLuck.get(1) + 1);
            }
            if (sameNumberCount == 5) {
                if (!allLotto.get(i).contains(bonusNumber)) {
                    goodLuck.set(2, goodLuck.get(2) + 1);
                } else {
                    goodLuck.set(3, goodLuck.get(3) + 1);
                }
            }
            if (sameNumberCount == 6) {
                goodLuck.set(4, goodLuck.get(4) + 1);
            }
        }
        double sumPrize = 0;
        sumPrize += 5000 * goodLuck.get(0);
        sumPrize += 50000 * goodLuck.get(1);
        sumPrize += 1500000 * goodLuck.get(2);
        sumPrize += 30000000 * goodLuck.get(3);
        sumPrize += 2000000000 * goodLuck.get(4);

        double beforeRate = sumPrize / purchase * 100;
        double rate = Math.round(beforeRate * 10.0) / 10.0;

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + goodLuck.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + goodLuck.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + goodLuck.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + goodLuck.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + goodLuck.get(4) + "개");
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
