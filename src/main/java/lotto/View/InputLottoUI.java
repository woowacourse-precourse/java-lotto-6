package lotto.View;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class InputLottoUI {

    public static int inputMoneyPrint() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int inputBonusNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static List<Integer> inputAnswerLottoPrint() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Integer> lottoNumbers = new ArrayList<>();

        String[] numberTokens = input.split("[,\\s]+");
        for (String token : numberTokens) {
            try {
                int number = Integer.parseInt(token);
                lottoNumbers.add(number);
            } catch (NumberFormatException e) {
                // 숫자로 변환할 수 없는 입력은 무시
            }
        }
        return lottoNumbers;
    }
}
