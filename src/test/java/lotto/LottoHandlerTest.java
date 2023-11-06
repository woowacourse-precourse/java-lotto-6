package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoHandlerTest {

    private LottoHandler lottoHandler;

    @BeforeEach
    void setUp() {
        lottoHandler = new LottoHandler();
    }

    @DisplayName("구매 금액을 입력 받아 구입 금액에 해당하는 로또를 발행한다.")
    @Test
    void calculateLottoTicketCount() {
        // given
        String receivedPurchasePrice = "1000";

        // when
        int lottoTicket = lottoHandler.calculateLottoTicketCount(receivedPurchasePrice);

        // then
        assertThat(lottoTicket).isEqualTo(1);
    }

    @DisplayName("구매 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void calculateLottoTicketCountByNotDivisibleBy1000() {
        // given
        String receivedPurchasePrice = "1001";

        // when // then
        assertThatThrownBy(() -> lottoHandler.calculateLottoTicketCount(receivedPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000원 단위로만 입력해 주세요.");
    }

    @DisplayName("구매 금액에 문자를 입력하면 예외가 발생한다.")
    @Test
    void calculateLottoTicketCountByNotNumber() {
        // given
        String receivedPurchasePrice = "abc";

        // when // then
        assertThatThrownBy(() -> lottoHandler.calculateLottoTicketCount(receivedPurchasePrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해 주세요.");
    }

    @DisplayName("구매한 로또 개수를 받아 개수에 해당하는 로또들을 발행한다.")
    @Test
    void issueLottoNumbers() {
        // given
        int lottoTicket = 3;

        // when
        List<Lotto> lottos = lottoHandler.issueLottoNumbers(lottoTicket);

        // then
        assertThat(lottos.size()).isEqualTo(3);
    }

    @DisplayName("발행한 로또 번호는 오름차순으로 정렬되어 있다.")
    @Test
    void issueLottoNumberOrderByAsc() {
        // given
        int lottoTicket = 1;

        // when
        List<Lotto> lottos = lottoHandler.issueLottoNumbers(lottoTicket);

        // then
        List<Integer> lottoNumber = lottos.get(0).getNumbers();
        for (int i = 0; i < lottoNumber.size() - 1; i++) {
            assertThat(lottoNumber.get(i) < lottoNumber.get(i + 1)).isTrue();
        }
    }
    
    @DisplayName("당첨 번호를 입력 받아 Lotto 객체로 반환한다.")
    @Test
    void receiveWinningLotto() {
        // given
        String receivedWinningLotto = "1,2,3,4,5,6";
        
        // when
        Lotto winningLotto = lottoHandler.receiveWinningLotto(receivedWinningLotto);

        // then
        assertThat(winningLotto.equals(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isTrue();
    }

    @DisplayName("당첨 번호를 입력 받아 오름차순으로 정렬하여 Lotto 객체로 반환한다.")
    @Test
    void receiveWinningLottoOrderByNumbersAsc() {
        // given
        String receivedWinningLotto = "6,5,4,3,2,1";

        // when
        Lotto winningLotto = lottoHandler.receiveWinningLotto(receivedWinningLotto);

        // then
        assertThat(winningLotto.equals(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isTrue();
    }

    @DisplayName("입력 받은 당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void receiveWinningLottoByOverSize() {
        // given
        String receivedWinningLotto = "1,2,3,4,5,6,7";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveWinningLotto(receivedWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 6개의 숫자를 입력해 주세요.");
    }

    @DisplayName("입력 받은 당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void receiveWinningLottoByDuplicatedNumber() {
        // given
        String receivedWinningLotto = "1,2,3,4,5,5";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveWinningLotto(receivedWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
    }

    @DisplayName("입력 받은 당첨 번호가 1보다 작거나 45보다 크면 예외가 발생한다. 1보다 작은 경우")
    @Test
    void receiveWinningLottoByOutOfRangeNumberLessThan1() {
        // given
        String receivedWinningLotto = "0,2,3,4,5,6";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveWinningLotto(receivedWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요.");
    }

    @DisplayName("입력 받은 당첨 번호가 1보다 작거나 45보다 크면 예외가 발생한다. 45보다 큰 경우")
    @Test
    void receiveWinningLottoByOutOfRangeNumberGreaterThan45() {
        // given
        String receivedWinningLotto = "1,2,3,4,5,46";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveWinningLotto(receivedWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요.");
    }

    @DisplayName("입력 받은 당첨 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void receiveWinningLottoByString() {
        // given
        String receivedWinningLotto = "a,2,3,4,5,46";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveWinningLotto(receivedWinningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해 주세요.");
    }

    @DisplayName("입력 받은 보너스 번호를 정수로 반환한다.")
    @Test
    void receiveBonusNumber() {
        // given
        String receivedBonusNumber = "1";

        // when
        int bonusNumber = lottoHandler.receiveBonusNumber(receivedBonusNumber);

        // then
        assertThat(bonusNumber).isEqualTo(1);
    }

    @DisplayName("입력 받은 보너스 번호에 문자가 있으면 예외가 발생한다.")
    @Test
    void receiveBonusNumberByString() {
        // given
        String receivedBonusNumber = "a";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveBonusNumber(receivedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해 주세요.");
    }

    @DisplayName("입력 받은 보너스 번호가 1보다 작거나 45보다 크면 예외가 발생한다. 1보다 작은 경우")
    @Test
    void receiveBonusNumberByOutOfRangeNumberLessThan1() {
        // given
        String receivedBonusNumber = "0";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveBonusNumber(receivedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요.");
    }

    @DisplayName("입력 받은 보너스 번호가 1보다 작거나 45보다 크면 예외가 발생한다. 45보다 큰 경우")
    @Test
    void receiveBonusNumberByOutOfRangeNumberGreaterThan45() {
        // given
        String receivedBonusNumber = "46";

        // when // then
        assertThatThrownBy(() -> lottoHandler.receiveBonusNumber(receivedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요.");
    }

    @DisplayName("발행한 로또와 당첨 로또를 비교하여 당첨 결과를 리턴한다.")
    @Test
    void calculateWinningResult(){
        //given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(6, 12, 23, 34, 35, 45));
        lottos.add(lotto1);
        lottos.add(lotto2);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        //when
        Map<WinningKind, Integer> winningKinds = lottoHandler.calculateWinningResult(lottos, winningLotto, bonusNumber);

        //then
        assertThat(winningKinds.get(WinningKind.FIRST)).isEqualTo(1);
    }

}