package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

//     도메인 로직 테스트 케이스
//     1. 입력된 금액에 맞춰 로또가 구매되었는가? (입력 금액에 맞춰 로또 구매 결정)
//     2. 당첨 내역이 올바르게 집계되었는가? (당첨 매뉴얼에 따라 결정)
//         - 6개 번호 일치 -> 1등
//         - 5개 번호 + 보너스 번호 일치 -> 2등
//         - 5개 번호 일치 -> 3등
//         - 4개 번호 일치 -> 4등
//         - 3개 번호 일치 -> 5등
//     3. 당첨 내역에 따른 수익률 계산 (당첨 내역과 입력금액에 대한 수익률 계산 방법에 따라 결정)

}