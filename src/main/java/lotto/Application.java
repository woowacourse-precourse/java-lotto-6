package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int input = 0;
    private static int buyCount = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputPurchaseMoney();

        List<Lotto> list = createLottosLikeBuyCount();


        List<Integer> correct = inputLottoAnswer();

        int bonus = inputBonusNumber(correct);

        printResult(list, correct, bonus, input);
    }

    private static int inputBonusNumber(List<Integer> correct) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        correct.add(bonus);
        System.out.println("당첨 통계");
        System.out.println("---");
        return bonus;
    }

    private static List<Integer> inputLottoAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> correct = new ArrayList<>();
        String s = Console.readLine();
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            correct.add(Integer.parseInt(split[i]));
        }
        return correct;
    }

    private static List<Lotto> createLottosLikeBuyCount() {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            List<Integer> randomList = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomList);
            lotto.printLottoList(randomList);
            list.add(lotto);
        }
        return list;
    }

    private static void inputPurchaseMoney() {
        try {
            validatePurchaseMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseMoney();
        }
    }

    private static void validatePurchaseMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            input = Integer.parseInt(Console.readLine());
            buyCount = input / 1000;
            System.out.println(buyCount + "개를 구매했습니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private static void printResult(List<Lotto> list, List<Integer> correct, int bonus, int input) {
        int[] check = new int[5];
        for (int i = 0; i < list.size(); i++) {
            int[] correctAndBonus = new int[2];
            Lotto lotto = list.get(i);
            for (int j = 0; j < lotto.getNumbers().size(); j++) {
                if (correct.contains(lotto.getNumbers().get(j))) correctAndBonus[0]++;
                if (correct.contains(bonus)) correctAndBonus[1]++;
            }
            if (correctAndBonus[0] == 3) check[0]++;
            if (correctAndBonus[0] == 2 && correctAndBonus[1] == 1) check[0]++;
            if (correctAndBonus[0] == 4) check[1]++;
            if (correctAndBonus[0] == 3 && correctAndBonus[1] == 1) check[1]++;
            if (correctAndBonus[0] == 5) check[2]++;
            if (correctAndBonus[0] == 4 && correctAndBonus[1] == 1) check[2]++;
            if (correctAndBonus[0] == 5 && correctAndBonus[1] == 1) check[3]++;
            if (correctAndBonus[0] == 6) check[4]++;
        }

        System.out.println("3개 일치 (5,000원) - " + check[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + check[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + check[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + check[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + check[4] + "개");

        double sum = check[0] * 5000 + check[1] * 50000 + check[2] * 1500000 + check[3] * 30000000 + check[4] * 2000000000;

        System.out.println("총 수익률은 " + String.format("%.1f", sum / input * 100) + "%입니다.");
    }
}
