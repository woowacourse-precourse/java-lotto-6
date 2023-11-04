package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountString = Console.readLine();

        int purchaseAmount = Integer.parseInt(purchaseAmountString); // 8000

        System.out.println();

        int purchaseQuantity = purchaseAmount / 1000; // 8
        System.out.println(purchaseQuantity + "개를 구매했습니다.");
        List<List<Integer>> userLottoNumberCollection = new ArrayList<>(purchaseQuantity);

        for (int index = 0; index < purchaseQuantity; index++) {
            List<Integer> originalRandomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortRandomNumbers = new ArrayList<>(originalRandomNumbers);
            Collections.sort(sortRandomNumbers);
            userLottoNumberCollection.add(sortRandomNumbers);

        }
        for (int index = 0; index < purchaseQuantity; index++) {
            System.out.println(userLottoNumberCollection.get(index));
        }

        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        String luckyNumberString = Console.readLine();

        List<Integer> luckyNumbers = new ArrayList<>();

        String[] tokenString = luckyNumberString.split(",");
        for (String part : tokenString) {
            int luckyNumber = Integer.parseInt(part);
            luckyNumbers.add(luckyNumber);
        }

        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberWord = Console.readLine();
        int bonusNumber = Integer.parseInt(bonusNumberWord);

        System.out.println();

        System.out.println("당첨 통계");
        System.out.println("---");

        int sixSuccess = 0;
        int fiveSuccess = 0;
        int fiveAndBonusSuccess = 0;
        int fourSuccess = 0;
        int threeSuccess = 0;

        for (int index = 0; index < userLottoNumberCollection.size(); index++) {
            int score = 0;
            int bonusScore = 0;
            for (int userNumber : userLottoNumberCollection.get(index)) {
                for (int luckyNumber : luckyNumbers) {
                    if (luckyNumber == userNumber) {
                        score++;
                    }
                    if (userNumber == bonusNumber) {
                        bonusScore++;
                    }
                }
            }
            if (score == 3) {
                threeSuccess++;
            }
            if (score == 4) {
                fourSuccess++;
            }
            if (score == 5) {
                fiveSuccess++;
            }
            if (score == 5 && bonusScore == 1) {
                fiveAndBonusSuccess++;
            }
            if (score == 6) {
                sixSuccess++;
            }
        }

        System.out.println("3개 일치 (5,000원) - " + threeSuccess + "개");
        System.out.println("4개 일치 (50,000원) - " + fourSuccess + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveSuccess + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveAndBonusSuccess + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixSuccess + "개");

        int totalReward = 0;
        totalReward += 5000 * threeSuccess;
        totalReward += 50000 * fourSuccess;
        totalReward += 1500000 * fiveSuccess;
        totalReward += 30000000 * fiveAndBonusSuccess;
        totalReward += 2000000000 * sixSuccess;

        double benefit = (double) totalReward / purchaseAmount * 100;

        double result = Math.round(benefit * 100.0) / 100.0;
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }
}