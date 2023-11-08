package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("보유 중인 숫자와 당첨 번호를 비교하여 해당하는 점수를 반환한다.")
    @Test
    void getMatches() {
        // 변수 선언
        int[][] numbersList = {
                {1, 2, 3, 4, 5, 6},      // 6개 일치
                {1, 2, 3, 4, 5, 7},      // 5개 + 보너스 1개 일치
                {1, 2, 3, 4, 5, 30},     // 5개 일치
                {1, 2, 3, 4, 31, 32},    // 4개 일치
                {1, 2, 3, 33, 34, 35}    // 3개 일치
        };
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // 로또 생성
        List<Lotto> lottos = new ArrayList<>();
        for (int[] nums : numbersList) {
            List<Integer> lottoNumber = List.of(nums[0], nums[1], nums[2], nums[3], nums[4], nums[5]);
            Lotto lottoMaker = new Lotto(lottoNumber);

            lottos.add(lottoMaker);
        }

        // 일치 점수 구하기
        List<Integer> matchesList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matches = lotto.getPoint(winningNumbers);
            matchesList.add(matches);
        }

        // 예상한 값과 일치하는지 테스트
        List<Integer> expectedMatches = new ArrayList<>(List.of(7, 6, 5, 4, 3));
        assertEquals(expectedMatches, matchesList);
    }

}
