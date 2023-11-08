package view;

import domain.CorrectBalls;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoDetailOutput {

    private final String START_WORD = "당첨 통계\n---";
    private final String LOTTO_COUNT_WORD = "총 수익률은 %.1f%%입니다.";

    private final List<CorrectBalls> correctBalls;
    private float totalProfit;

    public LottoDetailOutput() {
        correctBalls = new ArrayList<>(Arrays.asList(CorrectBalls.values()));
        totalProfit = 0;
    }

    public void detailOutput(int[] answer) {
        System.out.println(START_WORD);
        for (CorrectBalls ball : correctBalls) {
            System.out.println(ball.makeSentence(answer[ball.getBallCount()]));
            totalProfit += ball.getPrice() * answer[ball.getBallCount()];
        }
    }

    public void totalProfitOutput(int money) {
        System.out.printf((LOTTO_COUNT_WORD) + "%n", (totalProfit / money) * 100);
    }

}
