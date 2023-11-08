package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;
import lotto.service.LottoService;
import lotto.validation.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private InputValidator inputValidator;
    private LottoService lottoService;

    @BeforeEach
    public void setUp() {
        this.inputValidator = new InputValidator();
        this.lottoService = new LottoService();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개가 안되면 예외가 발생한다.")
    @Test
    void createLottoByLowSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호 중 중복되는 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateDuplicateNumber() {
        //given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = "2";

        //then
        assertThatThrownBy(() -> inputValidator.validateDuplicateNumber(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호와 보너스 번호는 1~45 사이의 범위를 벗어나면 예외가 발생한다.")
    @Test
    void validateRangeOfNumber() {
        //given
        String lottoNumber = "1,22,44,2,16,49";
        String bonusNumber = "-1";

        //then
        assertThatThrownBy(() -> inputValidator.validateLottoNumberOfRange(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateBonusNumberOfRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호는 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateNumberic() {
        //given
        String lottoNumber = "a,b,44,2,16,49";
        String bonusNumber = "c";

        //then
        assertThatThrownBy(() -> inputValidator.validateLottoNumbericInput(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateBonusNumberic(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 쉼표로 구분되어 있지 않으면 예외가 발생한다.")
    @Test
    void validateSeparateNumber() {
        //given
        String lottoNumber = "1,22:44,2,16,49";

        //then
        assertThatThrownBy(() -> inputValidator.validateLottoNumbericInput(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 두개 이상 입력되면 예외가 발생한다.")
    @Test
    void validateTwoBonusNumber() {
        //given
        String bonusNumber = "1,2";

        //then
        assertThatThrownBy(() -> inputValidator.validateBonusNumberic(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validateDividePrice() {
        assertThatThrownBy(() -> inputValidator.validateLottoSheets("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 1등 당첨")
    @Test
    void validateHitCount() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(3, 4, 5, 6, 10, 12));
        UserLotto userLotto = new UserLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        lottos.add(lotto1);
        lottos.add(lotto2);
        //when
        EnumMap<LottoRank, Integer> lottoResult = lottoService.getLottoResult(lottos, userLotto);
        Integer firstWinnerCount = lottoResult.get(LottoRank.FIRST);

        //then
        Assertions.assertThat(firstWinnerCount).isEqualTo(1);
    }

    @DisplayName("로또 1등 1장일 때 구매 금액 수익률")
    @Test
    void validateRatioOfPrice() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        UserLotto userLotto = new UserLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        lottos.add(lotto);

        //when
        EnumMap<LottoRank, Integer> lottoResult = lottoService.getLottoResult(lottos, userLotto);
        double ratio = lottoService.calculatePrizeRatio(lottoResult, 1000);

        //then
        Assertions.assertThat(ratio).isEqualTo(200000000.0);
    }
}