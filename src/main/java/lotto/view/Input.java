package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public static Integer inputAmount() {
        while(true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                String in = Console.readLine();
                Integer i = Integer.parseInt(in);
                return i;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자입력이 아닙니다. 다시 입력하세요");
            }
        }
    }

    public static List<Integer> inputWinningNumber() {
        while(true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                String in = Console.readLine();
                return stringToList(in);
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호에 숫자 이외의 값이 포함 되어 있습니다. 다시 입력하세요");
            }
        }
    }

    public static List<Integer> stringToList(String s) {
        List<Integer> numbers = new ArrayList<>();
        for (String number: s.split(",")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public static Integer inputBonusNumber() {
        while(true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                String in = Console.readLine();
                return Integer.parseInt(in);
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자입력이 아닙니다. 다시 입력하세요");
            }
        }
    }
}
