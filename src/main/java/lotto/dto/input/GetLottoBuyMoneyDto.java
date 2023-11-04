package lotto.dto.input;

public class GetLottoBuyMoneyDto {
    private final int buyMoney;

    public int getBuyMoney() {
        return buyMoney;
    }

    public GetLottoBuyMoneyDto(int buyMoney) {
        this.buyMoney = buyMoney;
    }

}
