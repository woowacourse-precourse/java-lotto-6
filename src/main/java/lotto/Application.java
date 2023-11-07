package lotto;

import camp.nextstep.edu.missionutils.Console;
import service.BonusDraw;
import service.LottoDraw;
import service.Purchase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        Purchase purchase = new Purchase();
        LottoDraw lottoDraw = new LottoDraw();
        BonusDraw bonusDraw = new BonusDraw();

        try {

            System.out.println("구입금액을 입력해 주세요.");
            String userInput = Console.readLine();

            List<Lotto> lottoList = purchase.printPurchasedList(userInput);

            System.out.println("당첨 번호를 입력해 주세요.");
            String winNumbersInput = Console.readLine();

            List<Integer> winNumbers = lottoDraw.winNumbers(winNumbersInput);

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberInput = Console.readLine();

            bonusDraw.bonusDraw(winNumbers, bonusNumberInput);

            System.out.println("당첨 통계");
            System.out.println("---");

            /* 당첨통계 시작 */
//            Set<Integer> setForCompareNumbers = new HashSet<>();
//            for (int i = 0; i < winNumbers.size(); i++) {
//                setForCompareNumbers.add(winNumbers.get(i));
//            }
//            int[] winStatistic = new int[5];
//            for (int i = 0; i < lottoList.size(); i++) {
//                int count = 0;
//                for (int j = 0; j < lottoList.get(i).getNumbers().size(); j++) {
//                    if (setForCompareNumbers.contains(lottoList.get(i).getNumbers().get(j))) {
//                        count++;
//                    }
//                }
//                if (count == 6) {
//                    winStatistic[0]++;
//                } else if (count == 5 && lottoList.get(i).getNumbers().contains(bonusNumber)) {
//                    winStatistic[1]++;
//                } else if (count == 5 && !lottoList.get(i).getNumbers().contains(bonusNumber)) {
//                    winStatistic[1]++;
//                } else if (count == 4) {
//                    winStatistic[3]++;
//                } else if (count == 3) {
//                    winStatistic[4]++;
//                }
//            }
//            int totalMoneyGet = winStatistic[0] * 2000000000 + winStatistic[1] * 30000000 + winStatistic[2] * 1500000 + winStatistic[3] * 50000 + winStatistic[4] * 5000;
//            /* 당첨통계 종료 */
//
//            System.out.println("3개 일치 (5,000원) - " + winStatistic[4] + "개");
//            System.out.println("4개 일치 (50,000원) - " + winStatistic[3] + "개");
//            System.out.println("5개 일치 (1,500,000원) - " + winStatistic[2] + "개");
//            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winStatistic[1] + "개");
//            System.out.println("6개 일치 (2,000,000,000원) - " + winStatistic[0] + "개");
//            System.out.println("총 수익률은 " + (totalMoneyGet / (float) 8000) * 100 + "%입니다.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
