package lotto.service;

public class LottoNumberPrinter {
    public static void generateAndPrintLottoNumbers(int purchaseAmount) {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        int numberOfTickets = purchaseAmount / 1000;

        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println(numberGenerator.generateNumbers());
        }
        System.out.println();
    }
}
