package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    static int isMatchedThree = 0;
    static int isMatchedFour = 0;
    static int isMatchedFive = 0;
    static int isMatchedFiveAndBonus = 0;
    static int isMatchedSix = 0;

    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해주세요.");
        String answer = Console.readLine();
        System.out.println();

        int numberOfLotto = Integer.parseInt(answer) / 1000;
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        List<Lotto> issuedLotto = new ArrayList<>();

        int init = 1;
        while(init <= numberOfLotto) {
            List<Integer> numbers = new ArrayList<>
                (Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            issuedLotto.add(new Lotto(numbers));
            String result = Arrays.toString(numbers.toArray());
            System.out.println(result);
            init++;
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해주세요.");
        String userLottoNumber = Console.readLine();

        List<Integer> numbers = new ArrayList<>();
        String delimiter = ",";
        String[] userNumber = userLottoNumber.split(delimiter);
        for(String number : userNumber) {
            numbers.add(Integer.parseInt(number));
        }

        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("당첨 통계\n---");

        for(Lotto lotto : issuedLotto) {
            List<Integer> issuedNumbers = lotto.getNumbers();
            boolean isMatchedBonusNumber = false;
            if(issuedNumbers.contains(bonusNumber)) {
                isMatchedBonusNumber = true;
            }
            issuedNumbers.retainAll(numbers);
            calculateResult(issuedNumbers.size(), isMatchedBonusNumber);
        }

        System.out.printf("3개 일치 (5,000원) - %d개\n", isMatchedThree);
        System.out.printf("4개 일치 (50,000원) - %d개\n", isMatchedFour);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", isMatchedFive);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", isMatchedFiveAndBonus);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", isMatchedSix);

        float revenue = (5000 * isMatchedThree) + (50000 * isMatchedFour)
            + (1500000 * isMatchedFive) + (30000000 * isMatchedFiveAndBonus) + (2000000000 * isMatchedSix);
        float result = (revenue / Integer.parseInt(answer)) * 100 ;

        System.out.println();
        System.out.printf("총 수익률은 %.1f%%입니다.", result);
    }

    private static void calculateResult(int size, boolean isMatchedWithBonus) {
        if (size == 3) {
            isMatchedThree++;
        } else if (size == 4) {
            isMatchedFour++;
        } else if (size == 5 && !isMatchedWithBonus) {
            isMatchedFive++;
        } else if (size == 5) {
            isMatchedFiveAndBonus++;
        } else if (size == 6) {
            isMatchedSix++;
        }
    }
}
