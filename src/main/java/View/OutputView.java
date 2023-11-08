package View;

import Model.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printStatistics(List<Integer> winningCountList) {
        if(winningCountList.size() != OutputViewString.values().length) {
            throw new IllegalArgumentException();
        }

        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i = 0; i < winningCountList.size(); i++) {
            System.out.println(OutputViewString.values()[i] +
                    Integer.toString(winningCountList.get(i)) + "개");
        }
    }

    public void printMyLotto(List<Lotto> lotto) {
        System.out.println(lotto.size() + "개를 구매했습니다.");

        lotto.stream().forEach(e -> printMyLottoOneLine(e.getNumbers()));
    }

    private void printMyLottoOneLine(List<Integer> lotto) {
        String result = lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("[" + result + "]");
    }
}
