package lotto.view;

import java.util.List;

public class OutputView {
    public static void showCount(int count) {
        System.out.println();
        System.out.println(String.valueOf(count)+"개를 구매했습니다.");
    }
    public static void showLottoTickets(List<String> tickets) {
        for(String ticket : tickets){
            System.out.println(ticket);
        }
    }

    public static void showLottoResult(List<Integer> result, String profit, List<String> messageList) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i=0; i<5; i++){
            System.out.println(messageList.get(i) + " - " + result.get(i) + "개");
        }

        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
