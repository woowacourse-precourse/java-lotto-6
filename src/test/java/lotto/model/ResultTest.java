package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.dto.LottoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    @BeforeEach
    public void setUp() {
        winningNumber = WinningNumber.create("8,29,26,1,45,34");
        bonusNumber = BonusNumber.create("3", winningNumber);
    }

    @DisplayName("로또의 등수를 계산해준다.")
    @ParameterizedTest
    @MethodSource("lottoAndPrizeProvider")
    public void 로또의_등수를_계산해준다(Integer[] purchasedLotto, Integer prize) {
        //given
        Lotto lotto = new Lotto(List.of(purchasedLotto));
        LottoDto lottoDto = LottoDto.create(lotto);

        //when
        Result lottoResult = Result.calculate(lottoDto, winningNumber, bonusNumber);

        //then
        assertThat(lottoResult.getPrize()).isEqualTo(prize);
    }

    static Stream<Arguments> lottoAndPrizeProvider() {
        return Stream.of(
                Arguments.arguments(new Integer[]{34, 45, 1, 26, 8, 29}, 1), //1등
                Arguments.arguments(new Integer[]{34, 45, 1, 26, 8, 3}, 2),  // 2등
                Arguments.arguments(new Integer[]{34, 45, 1, 26, 8, 2}, 3),  // 3등
                Arguments.arguments(new Integer[]{34, 45, 1, 26, 12, 3}, 4),  // 4등
                Arguments.arguments(new Integer[]{34, 45, 1, 26, 15, 12}, 4),  //4등
                Arguments.arguments(new Integer[]{34, 44, 2, 26, 9, 29}, 5),  //5등
                Arguments.arguments(new Integer[]{34, 44, 2, 26, 3, 29}, 5),  //5등
                Arguments.arguments(new Integer[]{33, 44, 2, 26, 3, 29}, 0)  //0등
        );
    }
}
