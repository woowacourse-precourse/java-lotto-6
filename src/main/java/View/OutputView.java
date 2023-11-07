package View;

import Model.Lotto;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    public void printStatistics(List<Integer> winningCountList) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i = 0; i < winningCountList.size(); i++) {
            System.out.println(OutputViewString.values()[i] +
                    Integer.toString(winningCountList.get(i)) + "개");
        }
    }
}
