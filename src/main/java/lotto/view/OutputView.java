package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public void printLottos(List<Lotto> bundle) {
        System.out.printf("\n%d" + InformationMessage.PURCHASE.getMessage() + "\n", bundle.size());
        for (Lotto lotto : bundle) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Rank, Integer> result) {
        System.out.println(InformationMessage.STATISTICS.getMessage());
        System.out.printf(InformationMessage.FIFTH_PLACE.getMessage(), result.get(Rank.FIFTH_PLACE));
        System.out.printf(InformationMessage.FOURTH_PLACE.getMessage(), result.get(Rank.FOURTH_PLACE));
        System.out.printf(InformationMessage.THIRD_PLACE.getMessage(), result.get(Rank.THIRD_PLACE));
        System.out.printf(InformationMessage.SECOND_PLACE.getMessage(), result.get(Rank.SECOND_PLACE));
        System.out.printf(InformationMessage.FIRST_PLACE.getMessage(), result.get(Rank.FIRST_PLACE));
    }

    public void printRateOfReturn(String rate) {
        System.out.printf(InformationMessage.RATE_OF_RETURN.getMessage(), rate);
    }
}
