package view;

import domain.LottoService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    LottoService lottoService = new LottoService();

    public int printNumberOfSheets(int amount) {
        int numberOfSheets = amount / 1000;
        System.out.println("\n" + numberOfSheets + "개를 구매했습니다.");

        return numberOfSheets;
    }

    public List<List<Integer>> printLottoSheet(int numberOfSheets) {
        List<List<Integer>> tickets = lottoService.generateLottoNumbers(numberOfSheets);
        List<List<Integer>> sortedTickets = new ArrayList<>();

        for (List<Integer> ticket : tickets) {
            List<Integer> sortedTicket = new ArrayList<>(ticket); // 새로운 리스트 생성
            Collections.sort(sortedTicket); // 새로운 리스트 정렬
            System.out.println(sortedTicket);
            sortedTickets.add(sortedTicket); // 정렬된 리스트를 새 리스트에 추가
        }
        return sortedTickets;
    }

    public void displayResults(int[] matchCounts, double profitPercentage) {

        System.out.println("\n당첨 통계\n---");

        DecimalFormat df = new DecimalFormat("#0.0");
        String formattedProfitPercentage = df.format(profitPercentage);

        System.out.println("3개 일치 (5,000원) - " + matchCounts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts[4] + "개");
        System.out.println("총 수익률은 " + Double.parseDouble(formattedProfitPercentage) + "%입니다.");
    }
}
