package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        int howMuchPurchase = Integer.parseInt(Console.readLine());
        int howManyLotto = howMuchPurchase / 1000;

        List<Lotto> lottoPapers = generateLottoPaper(howManyLotto);

        System.out.println("\n" + howManyLotto + "개를 구매했습니다.");
        for (Lotto lotto : lottoPapers) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        String[] winNumber_String = Console.readLine().trim().split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for (String numberStr : winNumber_String){
            winNumbers.add(Integer.parseInt(numberStr.trim()));
        }

        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine().trim());


        for (Lotto lotto : lottoPapers){
            int matchingCount = 0;
            boolean hasBonusNumber = false;
            for (Integer number : winNumbers){
                if (lotto.getNumbers().contains(number)) {
                    matchingCount++;
                }
            }

            if (lotto.getNumbers().contains(bonusNumber)) {
                hasBonusNumber = true;
            }


            if (matchingCount == 3){
                System.out.println("3개 일치 (5,000원) - " +matchingCount +"개");
            }
            if (matchingCount == 4){
                System.out.println("4개 일치 (50,000원) - " +matchingCount +"개");
            }
            if (matchingCount == 5){
                System.out.println("5개 일치 (1,500,000원) - " +matchingCount +"개");
            }

            if (matchingCount == 5 && hasBonusNumber){
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +matchingCount +"개");
            }

            if (matchingCount == 6){
                System.out.println("6개 일치 (2,000,000,000원) - " +matchingCount +"개");
            }
        }
    }

    private static List<Lotto> generateLottoPaper(int howManyLotto) {
        List<Lotto> lottoPapers = new ArrayList<>();
        for (int i = 0; i < howManyLotto; i++) {
            lottoPapers.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoPapers;
    }
}
