//package lotto.domain;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//public class LottoTest {
//
//    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
//    @Test
//    void createLottoByOverSize() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void createLottoByDuplicatedNumber() {
//        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("로또의 범위가 1~45가 아니면 예외가 발생")
//    @Test
//    void createLottoByCorrectRange() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 60)))
//                .isInstanceOf(IllegalArgumentException.class);
//
//    }
//
//    @DisplayName("입력한 로또 번호를 잘 Get하는지 확인")
//    @Test
//    void setLottoNumbers() {
//        // given
//        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
//        Lotto lotto = new Lotto(lottoNumbers);
//
//        // when
//        List<Integer> getNumbers = lotto.getNumbers();
//
//        // then
//        Assertions.assertThat(lotto.getNumbers()).isEqualTo(getNumbers);
//    }
//
//    @DisplayName("보너스 번호가 로또 번호와 중복이 되면 예외 발생")
//    @Test
//    void bonusNumberMustNotOverlapLottoNumbers() {
//        // given
//        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
//        int bonusNumber = 6;
//
//        // when, then
//        assertThatThrownBy(() -> lotto.setBonusNumber(bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("보너스 번호의 범위가 1~45가 아니면 예외 발생")
//    @Test
//    void createBonusNumberByCorrectRange() {
//        // given
//        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
//        int bonusNumber = 50;
//
//        // when, then
//        assertThatThrownBy(() -> lotto.setBonusNumber(bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @DisplayName("보너스 번호 설정")
//    @Test
//    void setBonusNumber() {
//        // given
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add(4);
//        numbers.add(5);
//        numbers.add(6);
//        Lotto lotto = new Lotto(numbers);
//        int bonus = 10;
//
//        // when
//        lotto.setBonusNumber(bonus);
//
//        // then
//        assertThat(lotto.getBonusNumber).isEqualTo(bonus);
//    }
//}
