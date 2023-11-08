package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;
import lotto.model.stublottonumbersgenerator.CustomLottoNumbersGeneratorStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoBuyerTest {
    private LottoNumbersGenerator numbersGenerator;
    private LottoBuyer lottoBuyer;

    @BeforeEach
    void setUp() {
        numbersGenerator = new CustomLottoNumbersGeneratorStub(List.of(1, 2, 3, 4, 5, 6));
        lottoBuyer = new LottoBuyer();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 100, 500, 750, 1250, 1500, 1750, -1000})
    void 로또_구매시_구입_금액이_1000원_단위가_아니면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() -> lottoBuyer.buyLotto(purchaseAmount, numbersGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
