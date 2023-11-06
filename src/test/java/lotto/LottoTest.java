package lotto;

import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinNum;
import lotto.enums.LottoEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.enums.LottoEnum.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("당첨결과값 확인")
    @Test
    void countResult() {
        // given
            // 내 로또번호 생성
            List<Integer> lottoList = Arrays.asList(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(lottoList);

            List<Integer> lottoList2 = Arrays.asList(1, 2, 3, 4, 5, 7);
            Lotto lotto2 = new Lotto(lottoList2);


            // 당첨번호, 보너스 번호 생성
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);// 당첨번호
            int bonusNum = 7;
            WinNum winNum = new WinNum(list, bonusNum);

        Result result = new Result();

        // when
        LottoEnum lottoEnum = lotto.countResult(winNum);
        LottoEnum lottoEnum2 = lotto2.countResult(winNum);
        result.resultCount(lottoEnum);
        result.resultCount(lottoEnum2);

        // then
        Assertions.assertThat(result.getCount(W1)).isEqualTo(1);
        Assertions.assertThat(result.getCount(W2)).isEqualTo(1);
    }
}