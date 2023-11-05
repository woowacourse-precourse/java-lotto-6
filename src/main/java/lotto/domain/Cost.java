package lotto.domain;

// 사용자로부터 입력 받은 로또 구입 금액을 관리하기 위한 클래스
public class Cost {
    private int cost; // 사용자로부터 입력 받은 로또 구매 금액

    public Cost(String cost) {
        // checkValidation
        this.cost = Integer.parseInt(cost);
    }

    public int getCost() {
        return this.cost;
    }
}