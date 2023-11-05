package lotto.views;

public class Exceptions {
    public void exceptionNotInt() {
        System.out.println("[ERROR] 숫자로만 입력해 주세요.");
    }

    public void execptionNotPositive() {
        System.out.println("[ERROR] 양수로만 입력해 주세요.");
    }

    public void exceptionNotDivisible1000() {
        System.out.println("[ERROR] 로또 하나 당 금액은 1,000원 입니다. 1,000 단위로 작성해주세요. (ex. 13개 구입 시, 13000 으로 입력)\n");
    }
}
