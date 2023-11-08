package lotto.domain;

import lotto.exception.ExceptionMessage;
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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_SIZE_LOTTO_NUMBER.getDesc());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATION_LOTTO_NUMBER.getDesc());
    }

    @DisplayName("로또 번호에 최대 로또 번호 보다 큰 번호가 포함되면 예외가 발생한다.")
    @Test
    void createLottoByExceedMaxNumber() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER.getDesc());
    }

    @DisplayName("로또 번호에 최소 로또 번호 보다 작은 번호가 포함되면 예외가 발생한다.")
    @Test
    void createLottoByUnderMinNumber() {
        // given
        List<Integer> numbers = List.of(1, 0, 3, 4, 5, 10);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_RANGE_LOTTO_NUMBER.getDesc());
    }

    @DisplayName("타겟 로또와 비교해 일치하는 번호 개수를 찾는다.")
    @Test
    void findMatchingNumberCountByTargetLotto() {
        //given
        final int predictionMatchingNumberCount = 5;
        final List<Integer> originLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        final List<Integer> targetLottoNumbers = List.of(2, 3, 4, 5, 6, 7);

        Lotto originLotto = createLottoBy(originLottoNumbers);
        Lotto targetLotto = createLottoBy(targetLottoNumbers);

        //when
        int matchingNumberCount = originLotto.getMatchingNumberCount(targetLotto);

        //then
        assertThat(matchingNumberCount).isEqualTo(predictionMatchingNumberCount);
    }

    @DisplayName("로또에 보너스 번호가 포함되어 있는지를 확인한다.")
    @Test
    void isContainBonusNumber() {
        //given
        final int bonusNumber = 1;
        final List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        Lotto lotto = createLottoBy(lottoNumbers);

        //when
        boolean isContainBonusNumber = lotto.isContainBonusNumber(bonusNumber);

        //then
        assertThat(isContainBonusNumber).isTrue();
    }

    private Lotto createLottoBy(List<Integer> numbers) {
        return new Lotto(numbers);
    }

}