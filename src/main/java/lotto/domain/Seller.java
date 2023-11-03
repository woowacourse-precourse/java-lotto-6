package lotto.domain;

public class Seller {
    public static int lottoTicket(String deposit) {
        int amount = Integer.parseInt(deposit);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 나누어지는 금액을 입력해주세요.");
        }
       return amount;
    }

    public static int getTicket(int amount) {
        return amount / 1000;
    }
}
