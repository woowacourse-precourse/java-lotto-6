package lotto;

import static lotto.constant.LottoConstant.FIFTH_PLACE;
import static lotto.constant.LottoConstant.FIRST_PLACE;
import static lotto.constant.LottoConstant.FOURTH_PLACE;
import static lotto.constant.LottoConstant.SECOND_PLACE;
import static lotto.constant.LottoConstant.THIRD_PLACE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.constant.RuleConstant;
import lotto.model.Bank;
import org.junit.jupiter.api.Test;

class BankTest {
    private Bank bank = new Bank();

    @Test
    void 로또_당첨_수익_계산_테스트(){
        int profit = 0;
        List<Integer> rank = Arrays.asList(1,1,1,1,1);
        profit += rank.get(FIRST_PLACE.getIndex()) * FIRST_PLACE.getPrize();
        profit += rank.get(SECOND_PLACE.getIndex()) * SECOND_PLACE.getPrize();
        profit += rank.get(THIRD_PLACE.getIndex()) * THIRD_PLACE.getPrize();
        profit += rank.get(FOURTH_PLACE.getIndex()) * FOURTH_PLACE.getPrize();
        profit += rank.get(FIFTH_PLACE.getIndex()) * FIFTH_PLACE.getPrize();

        assertThat(profit).isEqualTo(bank.getProfit(rank));
    }

    @Test
    void 로또_당첨_수익률_계산_테스트(){
        int count = 10;
        int profit = 0;
        List<Integer> rank = Arrays.asList(0,1,2,3,4);
        profit += rank.get(FIRST_PLACE.getIndex()) * FIRST_PLACE.getPrize();
        profit += rank.get(SECOND_PLACE.getIndex()) * SECOND_PLACE.getPrize();
        profit += rank.get(THIRD_PLACE.getIndex()) * THIRD_PLACE.getPrize();
        profit += rank.get(FOURTH_PLACE.getIndex()) * FOURTH_PLACE.getPrize();
        profit += rank.get(FIFTH_PLACE.getIndex()) * FIFTH_PLACE.getPrize();

        double profitRate = profit / (count * RuleConstant.LOTTO_PRICE.getValue());
        profitRate *= RuleConstant.PERCENTAGE_NUMBER.getValue();
        profitRate = Math.round(profitRate * 10) / 10.0;

        assertThat(profitRate).isEqualTo(bank.getFormatProfitRate(count, profit));
    }
}
