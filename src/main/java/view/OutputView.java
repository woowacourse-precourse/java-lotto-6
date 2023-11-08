package view;

import domain.LottoService;
import java.util.List;

public class OutputView {

    LottoService lottoService = new LottoService();

    public int printNumberOfSheets(int amount) {
        int numberOfSheets = amount / 1000;
        System.out.println("\n" + numberOfSheets + "개를 구매했습니다.");

        return numberOfSheets;
    }

    public void printLottoSheet(int numberOfSheets) {
        List<List<Integer>> tickets = lottoService.generateLottoNumbers(numberOfSheets);

        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
