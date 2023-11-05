package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static List<Integer> winningNumberList;

    public static String requestLottoBuyingPrice() {
        System.out.println("구매하실 로또 금액을 입력해주세요.");
        return Console.readLine();
    }

    public static List<Integer> requestLottoWinningNumber() {
        System.out.println("당첨 번호를 입력해주세요.");
        return stringToList(Console.readLine());
    }

    private static List<Integer> stringToList(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(Integer.parseInt(result[i]));
        }
        return winningNumberList;
    }

    public static int requestLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
