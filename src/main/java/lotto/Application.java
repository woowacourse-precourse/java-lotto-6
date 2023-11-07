package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int input = buyLotto();
        System.out.println();
        int number = input / 1000;
        Lotto[] lottos = outputLottoNumber(number);
        String[] winning = winningNumber();
        bonusNumber();
    }

    private static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String str = Console.readLine();

        if (!isDigit(str)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }

        int input = Integer.parseInt(str);
        inputValidate(input);
        return input;
    }

    private static boolean isDigit(String str) {
        boolean isNumeric = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
                break;
            }
        }

        return isNumeric;
    }

    private static List<Integer> lottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private static void inputValidate(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }
    }

    private static Lotto[] outputLottoNumber(int number) {
        int i = 0;
        Lotto[] lottos = new Lotto[number];

        while (i < number) {
            lottos[i] = new Lotto(lottoNumber());
            i++;
        }

        System.out.println(number + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String str = lotto.length(lotto);
            System.out.println(str);
        }

        return lottos;
    }

    private static String[] winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String str = Console.readLine();

        if (!checkExpression(str)) {
            throw new IllegalArgumentException("쉼표(,) 기준으로 구분합니다. 쉼표(,)를 넣어주세요.");
        } else if (!duplicateNumber(str)) {
            throw new IllegalArgumentException("이미 숫자가 존재합니다.");
        } else if (!checkLength(str)) {
            throw new IllegalArgumentException("6개만 입력하세요");
        }

        return str.split(",");
    }

    private static boolean checkExpression(String str) {
        return str.contains(",");
    }

    private static boolean duplicateNumber(String str) {
        boolean flag = true;
        List<String> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (list.contains(s)) {
                flag = false;
            } else {
                list.add(s);
            }
        }

        return flag;
    }

    private static boolean checkLength(String str) {
        return str.length() == 6;
    }

    private static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String str = Console.readLine();

        return Integer.parseInt(str);
    }

}
