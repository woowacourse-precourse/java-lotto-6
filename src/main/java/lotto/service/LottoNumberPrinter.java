package lotto.service;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberPrinter {
    private static List<List<Integer>> prizeList = new ArrayList<>();

    public static List<List<Integer>> getPrizeList() {
        return prizeList;
    }

    public static void generateAndPrintLottoNumbers(int purchaseAmount) {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        int numberOfTickets = purchaseAmount / 1000;

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> prize = numberGenerator.generateNumbers();
            prizeList.add(prize);
            System.out.println(prize);
        }
        System.out.println();
    }
}
