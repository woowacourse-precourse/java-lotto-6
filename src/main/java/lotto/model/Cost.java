package lotto.model;

// 사용자로부터 입력 받은 로또 구입 금액을 관리하기 위한 클래스
public class Cost {
    private int value; // 사용자로부터 입력 받은 로또 구매 금액

    protected Cost(int value) {
        this.value = value;
    }

    protected int getValue() {
        return this.value;
    }
}