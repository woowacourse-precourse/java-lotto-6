package lotto.utils;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoNumRandomGeneratorTest {

    @Test
    public void 오름차순정렬테스트(){
        LottoNumRandomGenerator lottoNumRandomGenerator = new LottoNumRandomGenerator();

        List<Integer> numbers = lottoNumRandomGenerator.setRandomNum();

        for(int data:numbers){
            System.out.print(data+" ");
        }
    }

    @Test
    public void 로또번호생성테스트(){
        Amount amount=new Amount(10000,1000);
        LottoNumRandomGenerator lottoNumRandomGenerator = new LottoNumRandomGenerator();

        List<Lotto> result=lottoNumRandomGenerator.purchaseLottery(amount);

        Assertions.assertThat(result.size()).isEqualTo(amount.getCount());
    }
}
