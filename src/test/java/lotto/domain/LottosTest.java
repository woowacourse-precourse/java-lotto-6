package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import lotto.Dto.BoughtLottosDto;
import lotto.constant.constants.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    @DisplayName("로또 모음에 생성자 확인")
    void createNewLottos() {
        assertThatCode(Lottos::new).doesNotThrowAnyException();
    }


    @Test
    @DisplayName("로또 모음에 정확한 수의 로또가 들어 갔는지 확인")
    void Given_lottos_When_addThreeLotto_Then_lottosSizeIsThree() {
        // given
        Lottos lottos = new Lottos();
        // when
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        // then
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 모음이 Dto로 변환된 값과 일치하는지 확인")
    void Given_Lotts_When_UseToDto_Then_ValueOfLottosDtoIsSameAsLottos() {
        // given
        Lottos lottos = new Lottos();
        // when
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        BoughtLottosDto boughtLottosDto = lottos.toDto();
        // then
        assertThat(boughtLottosDto.getMyLottos()).isEqualTo(
                List.of(List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또 모음,우승 로또가 주어졌을 때 로또 모음에서 우승 로또와 일치하는 개수를 잘 반환하는지 확인")
    void Given_LottosAndList_When_AddedThreeLottoAndCaculatedMatched_ThenMatchedNumberIsThree() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lottos lottos = new Lottos();
        Lotto winningLotto = new Lotto(list);
        Integer bonusNumber = 7;

        // when
        lottos.add(new Lotto(list));
        lottos.add(new Lotto(list));
        lottos.add(new Lotto(list));
        int matched = lottos.calculateMatched(winningLotto, bonusNumber, Prize.SIX_MATCHED);
        // then
        assertThat(matched).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 모음,우승 로또,보너스 수가 주어졌을 때 로또 모음에서 우승 로또의 5개 수+보너스 번호가 일치하는 개수를 잘 반환하는지 확인")
    void Given_LottosAndListAndBonusNumber_When_CaculatedMatched_ThenMatchedNumberIsSix() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lottos lottos = new Lottos();
        Lotto winningLotto = new Lotto(list);
        Integer bonusNumber = 7;

        // when
        List<Integer> list2 = List.of(1, 2, 3, 4, 5, 7);
        lottos.add(new Lotto(list2));
        lottos.add(new Lotto(list2));
        lottos.add(new Lotto(list2));
        int matched = lottos.calculateMatched(winningLotto, bonusNumber, Prize.FIVE_AND_BONUS_MATCHED);
        // then
        assertThat(matched).isEqualTo(3);
    }
}
