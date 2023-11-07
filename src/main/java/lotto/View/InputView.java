package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해 주세요.");
        }
        return amount / LOTTO_PRICE;
    }
    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] numbertmp = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : numbertmp) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }



    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
