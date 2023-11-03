package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoStoreTest {
    private final int LOTTO_START_NUM = 1;
    private final int LOTTO_END_NUM = 45;
    private final int LOTTO_NUM_COUNT = 6;

    @DisplayName("로또를 사기 위한 금액이 숫자가 아니면 예외가 발생한다")
    @Test
    void validateMoneyInput() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        String englishInMoney = "100a";
        String koreanInMoney = "100ㅁ";
        String specialSignInMoney = "100%";

        //then
        assertThatThrownBy(() -> lottoStore.validateMoneyInput(englishInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.")
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> lottoStore.validateMoneyInput(koreanInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.")
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> lottoStore.validateMoneyInput(specialSignInMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또를 사기 위한 금액이 1000원 미만이면 예외가 발생한다")
    @Test
    void chargedMoneyLessThan1000() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        String money = "0";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);

        //then
        assertThatThrownBy(() -> lottoStore.validateChargedMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 부터입니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("로또를 사기 위한 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    @Test
    void chargedMoneyNotDivideBy1000() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        String money = "10001";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);

        //then
        assertThatThrownBy(() -> lottoStore.validateChargedMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000원 단위 입니다.")
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("올바른 금액 저장")
    @Test
    void chargeMoney() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        String money = "13000";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);
        lottoStore.validateChargedMoney();

        //then
        long moneyExpected = Long.parseLong(money);
        assertThat(lottoStore.getChargedMoney()).isEqualTo(moneyExpected);
    }

    @DisplayName("로또 구매 금액 조회")
    @Test
    void checkChargedMoney() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        String money = "13000";
        lottoStore.validateMoneyInput(money);
        lottoStore.chargeMoney(money);
        lottoStore.validateChargedMoney();

        long chargedMoney = lottoStore.getChargedMoney();

        //then
        long moneyExpected = Long.parseLong(money);
        assertThat(chargedMoney).isEqualTo(moneyExpected);
    }

    @DisplayName("로또 판매 갯수 계산")
    @Test
    void calculateLottoAmount() {
        //given
        LottoStore lottoStore = new LottoStore();
        final int LOTTO_PRICE = 1000;
        String money = "20000";

        //when
        lottoStore.getMoney(money);
        lottoStore.calculateLottoAmount();
        long lottoAmountExpected = lottoStore.getChargedMoney() / LOTTO_PRICE;

        //then
        assertThat(lottoStore.getLottoAmount()).isEqualTo(lottoAmountExpected);
    }

    @DisplayName("로또 번호 생성")
    @Test
    void generateUniqueSixLottoNumbers() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        List<Integer> lottoNumbers = lottoStore.generateLottoNumbers();

        //then
        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_NUM_COUNT);
        assertThat(lottoNumbers).allSatisfy(o -> assertThat(o).isBetween(LOTTO_START_NUM, LOTTO_END_NUM));
        assertThat(lottoNumbers).isSortedAccordingTo(Comparator.naturalOrder());

        Set<Integer> noDuplicatedNumber = new HashSet<>(lottoNumbers);
        assertThat(noDuplicatedNumber.size()).isEqualTo(LOTTO_NUM_COUNT);
    }

    @DisplayName("투입한 금액 만큼 로또가 생성")
    @Test
    void generateAllLottos() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        String money = "250000";
        lottoStore.getMoney(money);
        lottoStore.calculateLottoAmount();
        lottoStore.generateAllLottos();

        //then
        List<Lotto> lottoPapers = lottoStore.showLottoPapers();
        assertThat(lottoPapers.size()).isEqualTo(lottoStore.getLottoAmount());
    }
}