package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호중 1~45 범위 외의 숫자가 존재하면 예외가 발생한다.")
    @Test
    void lottoNumberOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3개 당첨 테스트.")
    @Test
    void 로또결과_테스트_3개() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성

        List<Integer> lottoNum = List.of(1, 2, 3, 10, 11, 12);
        List<Integer> winningNum = List.of(1, 2, 3, 4, 6, 7);
        Integer bonus = 8;

        assertThat(new Lotto(lottoNum)
                .getLottoResult(winningNum, bonus))
                .isEqualTo(LottoResult.MATCH3);
    }

    @DisplayName("4개 당첨 테스트.")
    @Test
    void 로또결과_테스트_4개() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성

        List<Integer> lottoNum = List.of(1, 2, 3, 4, 11, 12);
        List<Integer> winningNum = List.of(1, 2, 3, 4, 6, 7);
        Integer bonus = 8;

        assertThat(new Lotto(lottoNum)
                .getLottoResult(winningNum, bonus))
                .isEqualTo(LottoResult.MATCH4);
    }

    @DisplayName("5개 당첨 테스트.")
    @Test
    void 로또결과_테스트_5개() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성

        List<Integer> lottoNum = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningNum = List.of(1, 2, 3, 4, 6, 7);
        Integer bonus = 10;

        assertThat(new Lotto(lottoNum)
                .getLottoResult(winningNum, bonus))
                .isEqualTo(LottoResult.MATCH5);

    }

    @DisplayName("5개 + 보너스 번호 당첨 테스트.")
    @Test
    void 로또결과_테스트_5개_보너스() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성

        List<Integer> lottoNum = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winningNum = List.of(1, 2, 3, 4, 6, 7);
        Integer bonus = 7;

        assertThat(new Lotto(lottoNum)
                .getLottoResult(winningNum, bonus))
                .isEqualTo(LottoResult.MATCH5_AND_BONUS);

    }

    @DisplayName("6개 당첨 테스트.")
    @Test
    void 로또결과_테스트_6개() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성

        List<Integer> lottoNum = List.of(1, 2, 3, 4, 6, 7);
        List<Integer> winningNum = List.of(1, 2, 3, 4, 6, 7);
        Integer bonus = 8;

        assertThat(new Lotto(lottoNum)
                .getLottoResult(winningNum, bonus))
                .isEqualTo(LottoResult.MATCH6);

    }

    @DisplayName("로또 객체의 정보를 정상적으로 표시하는지 테스트합니다..")
    @Test
    void toString_테스트() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    // 아래에 추가 테스트 작성 가능
}