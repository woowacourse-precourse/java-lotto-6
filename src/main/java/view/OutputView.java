package view;

import java.util.List;
import lotto.Lotto;
import lotto.WinnerRank;
import repository.RankRepository;

public class OutputView {

    public static void outputTotalPurchaseQuantity(int totalPurchaseQuantity) {
        String message = String.format(OutputMessages.TOTAL_PURCHASED_QUANTITY.getMessage(), totalPurchaseQuantity);
        System.out.println(message);
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        lottoList.stream().forEach(Lotto::printLottoNumbers);
    }

    public static void outputWinningStatistics() {
        System.out.println(OutputMessages.WINNING_STATISTICS.getMessage());
        outputFifthPlaceCount();
        outputFourthPlaceCount();
    }

    private static void outputFifthPlaceCount() {
        System.out.println(String.format(OutputMessages.FIFTH_PLACE.getMessage(),
                RankRepository.getWinningStatistics(WinnerRank.FIFTH.getRank())));
    }

    private static void outputFourthPlaceCount() {
        System.out.println(String.format(OutputMessages.FOURTH_PLACE.getMessage(),
                RankRepository.getWinningStatistics(WinnerRank.FOURTH.getRank())));
    }
}
