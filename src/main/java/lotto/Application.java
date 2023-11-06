package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Validation validation = new Validation();

        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();

        /* 구입금액 validation 시작 */
        int purchaseAmount = validation.parsePurchaseAmount(moneyInput);
        validation.validateUnderZero(purchaseAmount);
        validation.validateDivideThousand(purchaseAmount);
        /* 구입금액 validation 종료 */

        int purchaseCount = purchaseAmount / 1000;
        System.out.println(purchaseCount + "개를 구매했습니다.");

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        for (int i = 0; i < lottoList.size(); i++) {
            Collections.sort(lottoList.get(i).getNumbers());
        }

        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i).toString());
        }

        System.out.println("당첨 번호를 입력해 주세요.");
        String winNumbersInput = Console.readLine();

        /* 당첨번호 validation 시작 */
        validation.validateWinNumbersFormatByChar(winNumbersInput);
        validation.validateWinNumbersFormatByLength(winNumbersInput);
        validation.validateWinNumbersFormatBySide(winNumbersInput);
        int[] winNumbers = validation.validateWinNumbersInRange(winNumbersInput);
        validation.validateWinNumbersByDuplicate(winNumbers);
        /* 당첨번호 validation 종료 */

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();

        /* 보너스번호 validation 시작 */
        int bonusNumber = validation.validateBonusNumberInRangeOrIsNumber(bonusNumberInput);
        validation.validateBonusNumberByDuplicate(bonusNumber, winNumbers);
        /* 보너스번호 validation 종료 */

        System.out.println("당첨 통계");
        System.out.println("---");

        /* 당첨통계 시작 */
        Set<Integer> setForCompareNumbers = new HashSet<>();
        for (int i = 0; i < winNumbers.length; i++) {
            setForCompareNumbers.add(winNumbers[i]);
        }
        int[] winStatistic = new int[5];
        for (int i = 0; i < lottoList.size(); i++) {
            int count = 0;
            for (int j = 0; j < lottoList.get(i).getNumbers().size(); j++) {
                if (setForCompareNumbers.contains(lottoList.get(i).getNumbers().get(j))) {
                    count++;
                }
            }
            if (count == 6) {
                winStatistic[0]++;
            } else if (count == 5 && lottoList.get(i).getNumbers().contains(bonusNumber)) {
                winStatistic[1]++;
            } else if (count == 5 && !lottoList.get(i).getNumbers().contains(bonusNumber)) {
                winStatistic[1]++;
            } else if (count == 4) {
                winStatistic[3]++;
            } else if (count == 3) {
                winStatistic[4]++;
            }
        }
        int totalMoneyGet = winStatistic[0] * 2000000000 + winStatistic[1] * 30000000 + winStatistic[2] * 1500000 + winStatistic[3] * 50000 + winStatistic[4] * 5000;
        /* 당첨통계 종료 */

        System.out.println("3개 일치 (5,000원) - " + winStatistic[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + winStatistic[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winStatistic[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winStatistic[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winStatistic[0] + "개");
        System.out.println("총 수익률은 " + (totalMoneyGet / purchaseAmount) * 100f + "%입니다.");
    }

}
