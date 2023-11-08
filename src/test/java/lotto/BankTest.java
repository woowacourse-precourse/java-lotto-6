package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.ResultConstant;
import lotto.model.Bank;
import org.junit.jupiter.api.Test;

class BankTest {
    private Bank bank = new Bank();

    @Test
    void 로또_당첨_수익_계산_테스트(){
        List<Integer> rank = Arrays.asList(1,1,1,1,1);

        int profit = 0;
        profit += rank.get(LottoConstant.FIRST_PLACE.getIndex()) * LottoConstant.FIRST_PLACE.getPrize();
        profit += rank.get(LottoConstant.SECOND_PLACE.getIndex()) * LottoConstant.SECOND_PLACE.getPrize();
        profit += rank.get(LottoConstant.THIRD_PLACE.getIndex()) * LottoConstant.THIRD_PLACE.getPrize();
        profit += rank.get(LottoConstant.FOURTH_PLACE.getIndex()) * LottoConstant.FOURTH_PLACE.getPrize();
        profit += rank.get(LottoConstant.FIFTH_PLACE.getIndex()) * LottoConstant.FIFTH_PLACE.getPrize();

        assertThat(profit).isEqualTo(bank.getProfit(rank));
    }
}
