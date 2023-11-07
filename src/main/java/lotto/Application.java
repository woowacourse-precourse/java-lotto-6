package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int input = buyLotto();
        System.out.println();
        int number = input / 1000;
        outputLottoNumber(number);
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

    private static void outputLottoNumber(int number){
        int i = 0;
        Lotto[] lottos = new Lotto[number];

        while (i < number){
            lottos[i] = new Lotto(lottoNumber());
            i++;
        }

        System.out.println(number +"개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String str = lotto.length(lotto);
            System.out.println(str);
        }
    }
}
