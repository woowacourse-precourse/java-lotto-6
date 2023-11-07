package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static List<Integer> winningNumberList;
    private static List<Integer> winningnumber;

    public static String requestLottoBuyingPrice() {
        System.out.println("구매하실 로또 금액을 입력해주세요.");
        return Console.readLine();
    }

    public static List<Integer> requestLottoWinningNumber() {
        try {
            System.out.println("당첨 번호를 입력해주세요.");
            winningnumber = stringToList(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            requestLottoWinningNumber();
        }
        return winningnumber;
    }

    private static List<Integer> stringToList(String winningNumber) {
        String[] result = winningNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (String string : result) {
            winningNumberList.add(Integer.parseInt(string));
        }
        return winningNumberList;
    }

    public static int requestLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
