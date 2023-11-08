package view;

import java.util.List;
import lotto.Lotto;
import lotto.Rank;
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
        outputThirdPlaceCount();
        outputSecondPlaceCount();
        outputFirstPlaceCount();
    }

    public static void outputRateOfReturn(Float rateOfReturn) {
        System.out.println(String.format(OutputMessages.RATE_OF_RETURN.getMessage(), rateOfReturn));
    }

    private static void outputFifthPlaceCount() {
        System.out.println(String.format(OutputMessages.FIFTH_PLACE.getMessage(),
                RankRepository.getWinningStatistics(Rank.FIFTH_PLACE.getRank())));
    }

    private static void outputFourthPlaceCount() {
        System.out.println(String.format(OutputMessages.FOURTH_PLACE.getMessage(),
                RankRepository.getWinningStatistics(Rank.FOURTH_PLACE.getRank())));
    }

    private static void outputThirdPlaceCount() {
        System.out.println(String.format(OutputMessages.THIRD_PLACE.getMessage(),
                RankRepository.getWinningStatistics(Rank.THIRD_PLACE.getRank())));
    }

    private static void outputSecondPlaceCount() {
        System.out.println(String.format(OutputMessages.SECOND_PLACE.getMessage(),
                RankRepository.getWinningStatistics(Rank.SECOND_PLACE.getRank())));
    }

    private static void outputFirstPlaceCount() {
        System.out.println(String.format(OutputMessages.FIRST_PLACE.getMessage(),
                RankRepository.getWinningStatistics(Rank.FIRST_PLACE.getRank())));
    }
}
