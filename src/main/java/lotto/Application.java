package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();

        List<List<Integer>> lottoNumbers = generateLottoNumber(money % 1000);

        List<Integer> answerNum = inputAnswer();
        Lotto lotto = new Lotto(answerNum);


    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyStr = Console.readLine();
        int money = moneyToInt(moneyStr);

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원을 단위로 입력해주세요");
        }

        return money;
    }

    public static int moneyToInt(String moneyStr) {
        int money;

        try {
            money = Integer.parseInt(moneyStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        return money;
    }

    public static List<List<Integer>> generateLottoNumber(int lottoNum) {
        System.out.println(lottoNum + "개를 구매했습니다.");
        List<List<Integer>> lottoNumberTotal = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumber.sort(naturalOrder());
            lottoNumberTotal.add(lottoNumber);
        }
        return lottoNumberTotal;
    }

    public static List<Integer> inputAnswer() {
        List<Integer> answerNum = new ArrayList<>();
        String answerStr = Console.readLine();
        String[] answer = answerStr.split(",");

        for (String numStr : answer) {
            answerNum.add(moneyToInt(numStr));
        }

        return answerNum;
    }
}
