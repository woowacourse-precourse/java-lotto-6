package view;

import domain.CorrectBalls;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoDetailOutput {

    private final String startWord = "당첨 통계\n---";
    private final String lottoCountWord = "총 수익률은 %.1f%%입니다.";

    private final List<CorrectBalls> correctBalls;
    private float totalProfit;

    public LottoDetailOutput() {
        correctBalls = new ArrayList<>(Arrays.asList(CorrectBalls.values()));
        totalProfit = 0;
    }

    public void detailOutput(int[] answer) {
        System.out.println(startWord);
        for (CorrectBalls ball : correctBalls) {
            System.out.println(ball.makeSentence(answer[ball.getBallCount()]));
            totalProfit += ball.getPrice() * answer[ball.getBallCount()];
        }
    }

    public void totalProfitOutput(int money) {
        System.out.printf((lottoCountWord) + "%n", (totalProfit/money) * 100);
    }

}
