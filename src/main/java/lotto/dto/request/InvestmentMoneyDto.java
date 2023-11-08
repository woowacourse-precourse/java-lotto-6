package lotto.dto.request;

public class InvestmentMoneyDto {
    private final int investmentMoney;

    public InvestmentMoneyDto(int investmentMoney) {
        this.investmentMoney = investmentMoney;
    }

    public int getInvestmentMoney() {
        return investmentMoney;
    }
}
