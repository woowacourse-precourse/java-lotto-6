package lotto.model;

import static lotto.util.LottoPrize.*;

// 로또 초기 구매 비용 및 상금 정보를 관리하기 위한 클래스
public class Profit {
    private final int PERCENTAGE_DIV = 100; // 수익률을 구하기 위한 상수값
    private final int LOTTO_PRIZE = 1_000; // 로또 가격
    private Cost cost; // 로또 구매 비용
    private Prize prize; // 상금

    public Profit(int cost) {
        this.cost = new Cost(cost);
        this.prize = new Prize();
    }

    // 로또 게임을 수행하면서 얻은 수익률을 반환
    protected double getProfit() {
        return prize.getMoney() / cost.getValue() * PERCENTAGE_DIV;
    }

    // 로또 구매량을 반환
    protected int getLottoCount() {
        return cost.getValue() / LOTTO_PRIZE;
    }

    // 등수를 기준으로 상금을 더함
    protected void addPrizeByGrade(int grade) {
        this.prize.addPrize(getPrize(grade));
    }
}
