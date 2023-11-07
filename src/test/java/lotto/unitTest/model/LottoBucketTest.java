package lotto.unitTest.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.LottoBucket;
import lotto.model.LottoCreator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

class LottoBucketTest {
    private static MockedStatic<LottoCreator> lottoCreator;

    @BeforeAll
    public static void setLottoCreator() {
        lottoCreator = mockStatic(LottoCreator.class);
    }

    @AfterAll
    public static void closeLottoCreator() {
        lottoCreator.close();
    }

    @ValueSource(ints = {1, 10})
    @ParameterizedTest
    void 로또_바구니의_로또_개수는_구입_개수와_같다(int purchasedLottoAmount) {
        LottoBucket lottoBucket = new LottoBucket(purchasedLottoAmount);

        assertThat(lottoBucket.getLottoAmount()).isEqualTo(purchasedLottoAmount);
    }

    @ParameterizedTest
    @CsvSource({"5, -1", "5, 5"})
    void 로또_바구니의_범위를_벗어난_로또를_꺼내면_예외를_발생시킨다(int lottoAmount, int index) {
        LottoBucket lottoBucket = new LottoBucket(lottoAmount);

        assertThatThrownBy(() -> lottoBucket.getLotto(index)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void 로또_바구니에서_꺼낸_로또는_자동생성된_로또다() {
        Lotto mockLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        given(LottoCreator.createRandomLotto()).willReturn(mockLotto);
        LottoBucket lottoBucket = new LottoBucket(1);

        assertThat(lottoBucket.getLotto(0)).isEqualTo(mockLotto);
    }

    @Test
    void 로또_바구니는_가지고있는_로또의_번호를_보여준다() {
        Lotto mockLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        given(LottoCreator.createRandomLotto()).willReturn(mockLotto);
        LottoBucket lottoBucket = new LottoBucket(1);

        assertThat(lottoBucket.getPublishedLotto().get(0)).isEqualTo(mockLotto.showNumbers());
    }
}