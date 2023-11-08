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

    public static void rateOfReturn(int totalPrize, int money) {
        double profitRate = (double) totalPrize / money * 100;
        String formattedProfitRate = String.format("%.1f%%", profitRate);
        System.out.println("총 수익률은: " + formattedProfitRate);
    }

    public static void rankViewTotal(String resultDescription, int count){
        System.out.println(resultDescription + " - " + count + "개");
    }

    public static void lottoSalse(List<List<Integer>> lottos) {
        for(List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void lottoCountView(int lottoCount) {
        System.out.println("\n" +lottoCount + "개를 구매했습니다.");
    }
}
