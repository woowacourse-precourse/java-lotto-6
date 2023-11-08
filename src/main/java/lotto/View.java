package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View {
    private static final String FIFTH = "3개 일치 (5,000원) -";
    private static final String FOURTH = "4개 일치 (50,000원) -";
    private static final String THIRD = "5개 일치 (1,500,000원) -";
    private static final String SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) -";
    private static final String FIRST = "6개 일치 (2,000,000,000원) -";

    private static final int tiketPrice = 1000;
    private static final String firstMent = "구입금액을 입력해 주세요.";
    private static final String secondMent = "개를 구매했습니다.";
    private static final String thirdMent = "당첨 번호를 입력해 주세요.";
    private static final String fourMent = "보너스 번호를 입력해 주세요.";
    private static final String finaleMent = "당첨 통계\n" + "---";


    public static int inputPrice() {
        System.out.println(firstMent);

        String input = Console.readLine();
        isNumValidate(input);
        inputValidate(input);


        return Integer.parseInt(input) / tiketPrice;
    }

    public static void outputTicket(int ticketCnt) {
        System.out.println("\n" + ticketCnt + secondMent);
    }

    private static void isNumValidate(String input) {
        //입력값이 정수인지 확인
        if(input == null || !input.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException();
        }
    }

    private static void inputValidate(String input) {
        //입력값이 1000으로 나누어 떨어지는지 확인
        if(Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }


    public static List<Integer> inputWinning() {
        System.out.println("\n" + thirdMent);
        String input = Console.readLine();

        String[] result = input.split(",");
        List<Integer> winningNum = new ArrayList<>();

        for (int i = 0; i < result.length; i++) {
            winningNum.add(transInt(result[i]));
        }

        return winningNum;
    }

    private static int transInt(String idx) {
        try {
            return Integer.parseInt(idx);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int inputBonusNum() {
        System.out.println("\n" + fourMent);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public static void outputLotto(List<Lotto> lottoList) {
        for(Lotto lotto : lottoList) {
            List<Integer> list = lotto.getLotto();
            int[] arr = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                arr[i] = list.get(i);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static long outputResult(int[] resultarr) {
        long totalRate = 0;
        System.out.println(FIFTH + " " + resultarr[3] + "개");
        totalRate += (long) resultarr[3] * 5000;
        System.out.println(FOURTH + " " + resultarr[4] + "개");
        totalRate += (long) resultarr[3] * 50000;
        System.out.println(THIRD + " " + resultarr[5] + "개");
        totalRate += (long) resultarr[3] * 1500000;
        System.out.println(SECOND + " " + resultarr[0] + "개");
        totalRate += (long) resultarr[3] * 30000000;
        System.out.println(FIRST + " " + resultarr[6] + "개");
        totalRate += (long) resultarr[3] * 2000000000;
        return totalRate;
    }

    public static int outputPlus(long rate) {

    }
}
