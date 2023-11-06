package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuyLotto {
    public int buy() {
        System.out.println("구입 금액을 입력 해 주세요.");
        String m = Console.readLine();
        int lottoCount = 0;
        try {
            moneyValidate(m);
            lottoCount = Integer.parseInt(m) / 1000;
            System.out.println();
            System.out.printf("%d개를 구매 했습니다.\n", lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buy();
        }
        return lottoCount;
    }

    public void moneyValidate(String money) {
        if (!money.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        int buy = Integer.parseInt(money);
        if (buy % 1000 != 0 || buy < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매 할 수 있습니다.");
        }
    }

    public Lotto generateLotto() {
        List<Integer> balls = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(balls);
        return new Lotto(balls);
    }

    public List<Integer> inputNumbers() {
        System.out.println("당첨 번호를 입력 해 주세요");
        String input = Console.readLine();
        try {
            return correctNumbers(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 올바르지 못한 숫자 형태 입니다.");
            inputNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputNumbers();
        }
        return null;
    }

    public List<Integer> correctNumbers(String input) {
        List<Integer> correctNumbers = new ArrayList<>();
        for (String n : input.split(",")) {
            int number = Integer.parseInt(n);
            inputValidateDuplicate(correctNumbers, number);
            inputValidateRange(number);
            correctNumbers.add(number);
        }
        inputValidateSize(correctNumbers);
        return correctNumbers;
    }

    public void inputValidateDuplicate(List<Integer> correctNumbers, int number) {
        if (correctNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 된 번호가 존재 할 수 없습니다.");
        }
    }

    public void inputValidateRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERRER] 로또 번호는 1 ~ 45 사이의 숫자만 존재 할 수 있습니다.");
        }
    }

    public void inputValidateSize(List<Integer> correctNumbers) {
        if (correctNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력 해 주세요.");
        }
    }
}
