package lotto.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputHandler {
    public static StringBuilder lottosSB = new StringBuilder();

    public static void addLotto(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.sort(copyNumbers);
        lottosSB.append(copyNumbers.toString()).append("\n");
    }

    public void printLottos() {
        System.out.println(lottosSB.toString());
    }

    public void printTicketCnt(int ticketCnt) {
        System.out.println(ticketCnt + "개를 구매했습니다.");
    }

    public void printResult(List<Integer> result) {
        System.out.println("3개 일치 (5,000원) - " + result.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.get(6) + "개");
    }

    public String printRoi(double result) {
        String str = String.format("%.1f", result);
        return "총 수익률은 " + str + "%입니다.";
    }
}
