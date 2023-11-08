package lotto.domain;

public class Game {

    public int countTickets(int money){
        validateDivisibleMoney(money);
        return money / 1000;
    }
    private static void validateDivisibleMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]1,000원 단위로만 입력가능합니다.");
        }
    }
}
