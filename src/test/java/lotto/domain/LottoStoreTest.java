package lotto.domain;

import lotto.view.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoStoreTest {
    private static final int LOTTO_START_NUM = 1;
    private static final int LOTTO_END_NUM = 45;
    private static final int LOTTO_NUM_COUNT = 6;
    private static final String ERROR_PHRASES = "[ERROR]";
    private static final int LOTTO_PRICE = 1000;

    @DisplayName("로또를 사기 위한 금액이 1000원 미만이면 예외가 발생한다")
    @Test
    void chargedMoneyLessThan1000() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        long money = 0;

        //then
        assertThatThrownBy(() -> lottoStore.validateChargedMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LESS_THAN_THOUSAND.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("로또를 사기 위한 금액이 1000원 단위가 아닐 경우 예외가 발생한다")
    @Test
    void chargedMoneyNotDivideBy1000() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        long money = 10001;

        //then
        assertThatThrownBy(() -> lottoStore.validateChargedMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DIVIDED_DISABLE.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("올바른 금액 저장")
    @Test
    void chargeMoney() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        long money = 13000;
        lottoStore.insertMoney(money);

        //then
        assertThat(lottoStore.getChargedMoney()).isEqualTo(money);
    }

    @DisplayName("로또 구매 금액 조회")
    @Test
    void checkChargedMoney() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        long money = 13000;
        lottoStore.insertMoney(money);

        long chargedMoney = lottoStore.getChargedMoney();

        //then
        assertThat(chargedMoney).isEqualTo(money);
    }

    @DisplayName("로또 판매 갯수 계산")
    @Test
    void calculateLottoAmount() {
        //given
        LottoStore lottoStore = new LottoStore();
        long money = 20000;

        //when
        lottoStore.insertMoney(money);

        //then
        assertThat(lottoStore.getChargedMoney() / LOTTO_PRICE).isEqualTo(20);
    }

    @DisplayName("로또 번호 생성")
    @Test
    void generateUniqueSixLottoNumbers() {
        //given
        LottoStore lottoStore = new LottoStore();

        //when
        Lotto lotto = lottoStore.generateLottoNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();

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
        long money = 250000;
        lottoStore.insertMoney(money);

        //then
        List<Lotto> lottoPapers = lottoStore.generateAllLottos();
        assertThat(lottoPapers.size()).isEqualTo(lottoStore.getChargedMoney() / LOTTO_PRICE);
    }
}