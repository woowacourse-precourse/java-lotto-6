package lotto;

import static lotto.view.OutputView.BONUS_COUNT;
import static lotto.view.OutputView.PRIZE;
import static lotto.view.OutputView.WINNING_COUNT;

import java.util.Arrays;
import java.util.List;

//어떤 Prize 를 몇 개 가지고 있냐가 중요해...
//OutputView 에서도 List<Integer> 값만 가지고 있으면 되거든...
public enum WinningPrize {
    FIRST_PLACE("6개 일치",Arrays.asList(6, 0,2000000000)),

    //5개 번호 + 보너스 번호
    SECOND_PLACE("5개 일치",Arrays.asList(5,1,30000000)),

    //5개 번호
    THIRD_PLACE("5개 일치",Arrays.asList(5,0,1500000)),
    FOURTH_PLACE("4개 일치",Arrays.asList(4,0,50000)),
    FIFTH_PLACE("3개 일치",Arrays.asList(3,0,5000));


// 순서는 winningCount, bonusCount, prize
    private final String description;
    private List<Integer> countAndPrize;

    WinningPrize(String description, List<Integer> countAndPrize) {
        this.description = description;
        this.countAndPrize = countAndPrize;
    }

    //Enum 주입
    public static WinningPrize findByCount(int winningCount) {
        return Arrays.stream(WinningPrize.values())
                .filter(winningPrize -> winningPrize.hasCount(winningCount))
                .findAny()
                .orElse(null);
    }

    public boolean hasCount(int winningCount) {
        return countAndPrize.stream()
                .anyMatch(pay -> pay.equals(winningCount));
    }

    public String getDescription() {
        return description;
    }

    public List<Integer> getCountAndPrize() {
        return countAndPrize;
    }

    public int getWinningCount() { return countAndPrize.get(WINNING_COUNT); }
    public int getBonusCount() {
        return countAndPrize.get(BONUS_COUNT);}
    public int getPrize() {
        return countAndPrize.get(PRIZE);}
}
