package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class LottoShopTest {

    @Test
    @DisplayName("생성기는 1부터 45까지의 랜덤한 숫자를 반환한다")
    void 로또숫자생성기_테스트() {
        //given
        Set<Integer> createdNumbers = new HashSet<>();
        int count = 0;

        //when
        while (createdNumbers.size() < 45 && count < 1000) {
            List<Integer> lottoNumbers = LottoShop.generateLottoNumber();
            lottoNumbers.forEach(num->createdNumbers.add(num));
            count++;
        }

        //then
        Assertions.assertThat(createdNumbers).contains(1,45);
        Assertions.assertThat(createdNumbers.size()).isEqualTo(45);
    }

    @RepeatedTest(1000)
    @DisplayName("생성기는 중복 숫자를 생성하지 않는다")
    void 로또숫자생성기_테스트2(){
        //given
        List<Integer> lottoNumbers = LottoShop.generateLottoNumber();

        //when
        long count = lottoNumbers.stream().distinct().count();

        //then
        Assertions.assertThat(count).isEqualTo(lottoNumbers.size());
    }

    @Test
    void 로또구매_테스트() {
        List<Lotto> sell = LottoShop.sell(10);
        Assertions.assertThat(sell.size()).isEqualTo(10);
    }
}
