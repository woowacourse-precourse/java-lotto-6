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


}
