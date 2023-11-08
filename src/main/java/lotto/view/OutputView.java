package lotto.view;

import java.util.List;

public class OutputView extends Message{
    public void confirmLottoCount(int count) {
        System.out.println(count+INPUT_CONFIRM_MESSAGE);
    }
    public void showLotto(String output) {
        System.out.println(output);
    }

    public void showStatisticMessage() {
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(BAR);
    }

    public void showResult(String resultLine) {
        System.out.println(resultLine);
    }
    public void showRevenue(double revenue){
        System.out.println(REVENUE_FRONT_MESSAGE + revenue + REVENUE_BACK_MESSAGE);
    }
}
