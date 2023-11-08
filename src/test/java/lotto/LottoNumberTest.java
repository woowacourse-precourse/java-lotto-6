package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.userLotto.domain.Lotto;
import lotto.userLotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.winningLotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 한장을 뽑는다.")
    @Test
    void getRandomNumber(){
        List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);
        System.out.println(lottoNumbers);
    }
    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    @Test
    void sortRandomNumber(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort(Comparator.naturalOrder());
        System.out.println(lottoNumbers);
    }

    @DisplayName("구입 금액 만큼의 로또 수를 구한다..")
    @Test
    void getLottoCount(){
        int money = 5000;
        int lottoPrice = 1000;
        int lottoCount = money/lottoPrice;
        assertThat(lottoCount).isEqualTo(5);
    }

    @DisplayName("구입 금액 만큼 로또 번호를 뽑아 오름 차순으로 정렬 후 발행 한다..")
    @Test
    void createLottoNumberV2(){
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        lottoNumbers.sort(Comparator.naturalOrder());
        System.out.println(lottoNumbers);
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
    //
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
    @DisplayName("로또 번호가 1~45의 숫자가 아니면 예외를 발생한다.")
    @Test
    void createLottoOutOfRangeOneToFortyFive(){
        assertThatThrownBy(() -> new Lotto(List.of(0,2,3,4,5,6,50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 빈 값이면 예외를 발생한다.")
    @Test
    void createLottoEmpty(){
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 null이면 예외를 발생한다.")
    @Test
    void createLottoNull(){
        assertThatThrownBy(() -> new Lotto(List.of(null,null)))
                .isInstanceOf(NullPointerException.class);
    }
    @DisplayName("로또 번호를 몇개 맞췄는지 센다.")
    @Test
    void match(){
        //given
        // 손님 로또 번호 생성
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(10);
        arr2.add(20);
        arr2.add(30);
        arr2.add(40);
        arr2.add(41);
        arr2.add(42);
        Lotto lotto1 = new Lotto(arr);
        Lotto lotto2 = new Lotto(arr2);
        Lottos lottos = new Lottos(List.of(lotto1,lotto2));
        OutputView.printLottos(lottos);
        //당첨 번호 생성
        InputView.messageAskLottoNumber();
        String num = "1,2,3,6,7,10";
        //when
        LottoNumber lottoNumber = new LottoNumber(StringCalculator.withOutSpaceBarAndSplitAndPositives(num));
        //then
        System.out.println(lottoNumber.match(lotto1));
        System.out.println(lottoNumber.match(lotto2));

    }


}