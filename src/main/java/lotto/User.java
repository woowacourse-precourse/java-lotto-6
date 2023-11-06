package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.naturalOrder;

public class User {

    final static int LOTTO_PRICE = 1000;
    final static int LOTTO_START_NUMBER = 1;
    final static int LOTTO_END_NUMBER = 45;
    final static int LOTTO_PICK_NUMBER = 6;
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyStr = Console.readLine();
        System.out.println();
        return verifyMoney(moneyStr);
    }

    public static int verifyMoney(String moneyStr) {
        int money;

        try {
            money = Integer.parseInt(moneyStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원을 단위로 입력해주세요");
        }

        return money;
    }

    public static int verifyIntValue(String moneyStr) {
        int money;

        try {
            money = Integer.parseInt(moneyStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        if (money < LOTTO_START_NUMBER || money > LOTTO_END_NUMBER) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        return money;
    }

    public List<List<Integer>> generateLottoNumber(int money) {
        int lottoNum = money / LOTTO_PRICE;
        System.out.println(lottoNum + "개를 구매했습니다.");
        List<List<Integer>> lottoNumberTotal = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_PICK_NUMBER);
            lottoNumber.sort(naturalOrder());
            lottoNumberTotal.add(lottoNumber);
        }
        printLottoNumbers(lottoNumberTotal);
        System.out.println();
        return lottoNumberTotal;
    }

    public static void printLottoNumbers(List<List<Integer>> lottoNumberTotal) {
        for (List<Integer> lottoNumber : lottoNumberTotal) {
            System.out.println(lottoNumber.toString());
        }
    }

    public List<Integer> inputAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> answerNum = new ArrayList<>();
        String answerStr = Console.readLine();
        String[] answer = answerStr.split(",");
        System.out.println();

        for (String numStr : answer) {
            answerNum.add(verifyIntValue(numStr));
        }

        return answerNum;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusStr = Console.readLine();
        System.out.println();

        return verifyIntValue(bonusStr);
    }

}
