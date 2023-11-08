package lotto.view;

import java.util.List;

public class OutputMessage {

    public static void lottoNumber(List<Integer> number) {
        System.out.println(number);
    }

    public static void purchaseMessage(int output){
        System.out.printf("\n%d개를 구입했습니다.\n",output);
    }

    public static void winningMessage() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }
}
