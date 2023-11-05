package lotto.view;

import lotto.enums.Rank;

import java.text.DecimalFormat;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleImpl implements Console {
    private void println(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println();
    }

    @Override
    public String inputPayment() {
        println("구입금액을 입력해 주세요.");
        return input();
    }

    @Override
    public void displayPurchasedLotteryCount(int lotteryCount) {
        println(lotteryCount + "개를 구매했습니다.");
    }

    @Override
    public void displayPurchasedLottery(List<Integer> lottery) {
        println(lottery.toString());
    }

    @Override
    public String inputWinningNumbers() {
        println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        println();
        return input;
    }

    @Override
    public String inputBonusNumber() {
        println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        println();
        return input;
    }

    @Override
    public void displayResult(List<Integer> matchResult, double rateOfReturn) {
        println("당첨 통계");
        println("---");
        println("3개 일치 (" + addCommas(Rank.FIFTH.getReward()) + "원) - " + matchResult.get(4) + "개");
        println("4개 일치 (" + addCommas(Rank.FOURTH.getReward()) + "원) - " + matchResult.get(3) + "개");
        println("5개 일치 (" + addCommas(Rank.THIRD.getReward()) + "원) - " + matchResult.get(2) + "개");
        println("5개 일치, 보너스 볼 일치 (" + addCommas(Rank.SECOND.getReward()) + "원) - " + matchResult.get(1) + "개");
        println("6개 일치 (" + addCommas(Rank.FIRST.getReward()) + "원) - " + matchResult.get(0) + "개");
        println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    private String input() {
        String input = readLine();
        println();
        return input;
    }

    public String addCommas(int number) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number);
    }
}
