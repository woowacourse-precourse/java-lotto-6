package lotto.dto.request;

public class InvestMoneyDto {
    private final int investMoney;

    public InvestMoneyDto(int investMoney) {
        this.investMoney = investMoney;
    }

    public int getInvestMoney() {
        return investMoney;
    }
}
