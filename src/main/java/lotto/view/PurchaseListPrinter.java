package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.service.LottoNumberGenerator;

public class PurchaseListPrinter {
    private static List<List<Integer>> purchaseList = new ArrayList<>();

    public static List<List<Integer>> getPurchaseList() {
        return purchaseList;
    }

    public static void generateAndPrintLottoNumbers(int purchaseAmount) {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        int numberOfTickets = purchaseAmount / 1000;

        IntStream.range(0, numberOfTickets)
                .mapToObj(i -> numberGenerator.generateNumbers())
                .forEach(prize -> {
                    purchaseList.add(prize);
                    System.out.println(prize);
                });

        System.out.println();
    }
}
