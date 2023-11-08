package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static Integer inputBuyMoney() {
        System.out.println("구매금액을 입력해 주세요");
        String result = Console.readLine();
        int input;
        try {
            input = Integer.parseInt(result);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
        return input;
    }

    public static List<Integer> inputWinningNum(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String result = Console.readLine();
        String[] split = result.split(",");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int inputBonusNum() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String result = Console.readLine();
        return Integer.parseInt(result);
    }
}
