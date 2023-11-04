package lotto.service;

import lotto.model.Investor;
import lotto.model.Lotto;
import lotto.model.Shop;
import java.util.List;

public class InvestorService {

    private final Investor investor;
    private final Shop lottoShop;

    private InvestorService(final Investor investor, final Shop lottoShop) {
        this.investor = investor;
        this.lottoShop = lottoShop;
    }

    public static InvestorService createDefault(final String investorInput) {
        Investor investor = Investor.createDefault(investorInput);
        Shop lottoShop = Shop.withOrderedMoney(investor.getInvestMoney());

        return new InvestorService(investor, lottoShop);
    }

    public List<Lotto> buyLottos() {
        return investor.buyLottosFromShop(lottoShop);
    }

    public void addProfit(final int money) {
        investor.addProfitMoney(money);
    }

    public double calculateProfitRate() {
        return investor.calculateProfitRate();
    }
}
