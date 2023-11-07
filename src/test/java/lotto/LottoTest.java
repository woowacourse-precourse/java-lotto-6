package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lotto.model.ComputePrize;
import lotto.model.GetLottoPurchase;
import lotto.model.Lotto;
import lotto.model.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("구입 금액에 맞는 숫자가 들어갔을 경우 성공")
    @ParameterizedTest
    @ValueSource(strings = {"15000","100000","5000"})
    void purchaseCostByCorrectNumber(String inputCost) {
        GetLottoPurchase getLottoPurchase = new GetLottoPurchase(inputCost);
        Assertions.assertThat(getLottoPurchase.getCost()).isEqualTo(Integer.parseInt(inputCost));
    }

    @DisplayName("중복되지 않는 보너스 번호가 들어갔을 경우 성공")
    @ParameterizedTest
    @ValueSource(ints = {7,8,9})
    void notDuplicateBonusNumber(int input) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lotto.checkBonus(input)).isFalse();
    }

    @DisplayName("각 등수가 잘 출력되는지 확인")
    @Test
    void correctPrizeEachLottoNumber() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 9, 10)));
        lottoList.add(new Lotto(List.of(1, 2, 3, 11, 12, 13)));
        lottoList.add(new Lotto(List.of(1, 2, 14, 15, 16, 17)));
        lottoList.add(new Lotto(List.of(1, 18, 19, 20, 21, 22)));
        lottoList.add(new Lotto(List.of(23, 24, 25, 26, 27, 28)));
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonus = 7;
        new ComputePrize(lotto, bonus);
        Assertions.assertThat(ComputePrize.match(lottoList.get(0))).isEqualTo(Prize.First);
        Assertions.assertThat(ComputePrize.match(lottoList.get(1))).isEqualTo(Prize.Second);
        Assertions.assertThat(ComputePrize.match(lottoList.get(2))).isEqualTo(Prize.Third);
        Assertions.assertThat(ComputePrize.match(lottoList.get(3))).isEqualTo(Prize.Fourth);
        Assertions.assertThat(ComputePrize.match(lottoList.get(4))).isEqualTo(Prize.Fifth);
        Assertions.assertThat(ComputePrize.match(lottoList.get(5))).isEqualTo(Prize.Miss);
        Assertions.assertThat(ComputePrize.match(lottoList.get(6))).isEqualTo(Prize.Miss);
        Assertions.assertThat(ComputePrize.match(lottoList.get(7))).isEqualTo(Prize.Miss);
    }

    @DisplayName("총 수익률이 제대로 출력되는지 확인")
    @Test
    void correctPrizePercent() {
        Map<Prize,Integer> result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize,0);
        }
        int cost = 5000;
        result.put(Prize.Fourth,1);
        result.put(Prize.Fifth,4);
        Assertions.assertThat(ComputePrizePercentTest.computePrizePercent(result, cost)).isEqualTo(1400.0);
    }
}