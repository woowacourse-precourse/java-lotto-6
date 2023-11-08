package lotto;

import static lotto.settings.ErrorMessage.INVALID_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("로또 번호가 모두 올바르게 입력된 경우 예외없이 저장된다.")
    @Test
    void createCorrectLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 35, 5, 6, 7));
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByUngerRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 0, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getMessage());
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 46, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_RANGE.getMessage());
    }

    // 당첨번호와 보너스번호를 설정합니다
    Lotto winningLotto = new Lotto(List.of(1, 4, 5, 7, 17, 26));
    int bonusNumer = 16;

    @DisplayName("산 로또와 당첨 번호가 몇개 맞는지 세서 반환해준다.")
    @Test
    void compareLottoNumbers() {
        //when
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 7));
        //then
        assertThat(winningLotto.matching(buyLotto)).isEqualTo(5);
    }

    @DisplayName("3개보다 못맞추면 0등을 반환해준다.")
    @Test
    void findRanNONE() {
        //when
        Lotto buyLotto = new Lotto(List.of(11, 26, 34, 5, 6, 37));
        int correctNumber = winningLotto.matching(buyLotto);
        //then
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(0);
    }

    @DisplayName("3개를 맟추면 5등을 반환해준다.")
    @Test
    void findRankFIFTH() {
        //when
        Lotto buyLotto = new Lotto(List.of(11, 26, 4, 5, 6, 37));
        int correctNumber = winningLotto.matching(buyLotto);
        //then
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(5);
    }

    @DisplayName("4개를 맟추면 4등을 반환해준다.")
    @Test
    void findRankFOURTH() {
        //when
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 37));
        int correctNumber = winningLotto.matching(buyLotto);
        //then
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(4);
    }

    @DisplayName("5개를 맟추고 보너스 점수를 못맞추면 3등을 반환해준다.")
    @Test
    void findRankTHIRD() {
        //when
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 6, 7));
        int correctNumber = winningLotto.matching(buyLotto);
        //then
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(3);
    }

    @DisplayName("5개를 맟추고 보너스 점수를 맞추면 2등을 반환해준다.")
    @Test
    void findRankSECOND() {
        //when
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 16, 7));
        int correctNumber = winningLotto.matching(buyLotto);
        //then
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(2);
    }

    @DisplayName("6개를 맟추면 1등을 반환해준다.")
    @Test
    void findRankFIRST() {
        //when
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 7, 17));
        int correctNumber = winningLotto.matching(buyLotto);
        //then
        assertThat(buyLotto.findRank(correctNumber,bonusNumer)).isEqualTo(1);
    }


    @DisplayName("로또번호에 보너스번호가있는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,true","2,false"})
    void hasBonusNumber(int bonusNumber, boolean expected) {
        //when
        Lotto buyLotto = new Lotto(List.of(1, 26, 4, 5, 7, 17));
        //then
        assertThat(buyLotto.has(bonusNumber)).isEqualTo(expected);
    }

    @DisplayName("산 로또의 번호를 오름차순으로 ','로 구분하여 문자열로 변경해준다.")
    @Test
    void listToAscendingString() {
        //given
        Lotto buyLotto = new Lotto(List.of(1, 4, 3, 6, 7, 2));
        //when
        String stringBuyLotto = buyLotto.listToAscendingString();
        //then
        assertThat(stringBuyLotto).isEqualTo("1, 2, 3, 4, 6, 7");
    }
}