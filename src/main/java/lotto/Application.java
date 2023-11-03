package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int inputLottoAmount() {
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount;
    }

    public static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        List<String> originalNums = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        return new Lotto(convertStringToInt(originalNums));
    }

    public static List<Integer> convertStringToInt (List<String> original) {
        List<Integer> convert = new ArrayList<Integer>();
        for (String num: original){
            convert.add(Integer.parseInt(num));
        }
        return convert;
    }

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = inputLottoAmount();
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningLotto = inputWinningNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
    }
}
