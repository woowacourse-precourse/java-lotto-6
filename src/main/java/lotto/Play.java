package lotto;

public class Play {

    private int cost;

    public Play(int cost) {
        this.cost = cost;
        // 구매 금액이 1000원으로 나누어 떨어지지 않는 경우 예외 발생
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
