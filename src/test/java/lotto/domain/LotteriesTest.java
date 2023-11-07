package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

class LotteriesTest {

    @ParameterizedTest(name = "사용자 로또 : {0}, 보너스 번호 : {1}, 예상 결과 : {2}")
    @ArgumentsSource(CalculateRanksArgumentsProvider.class)
    @DisplayName("사용자 로또와 구입한 로또를 비교하는 기능 테스트")
    void calculateRanksTest(final List<Integer> numbers, final int bonusNumber, final Rank expected) {
        // given
        NumbersGeneratorStrategy numbersGeneratorStrategy = () -> List.of(1, 2, 3, 4, 5, 6);
        LotteriesGenerator lotteriesGenerator = new LotteriesGenerator(numbersGeneratorStrategy);
        Lotteries lotteries = lotteriesGenerator.createByPurchaseCount(5);
        Lotto lotto = new Lotto(numbers);

        // when
        List<Rank> ranks = lotteries.calculateRanks(lotto, bonusNumber);

        // then
        assertThat(ranks).allMatch(rank -> rank.equals(expected));
    }
}