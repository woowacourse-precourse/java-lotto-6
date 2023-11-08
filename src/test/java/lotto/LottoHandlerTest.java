package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
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

    @DisplayName("구매 금액을 입력 받아 구입 금액에 해당하는 로또를 발행한다. 공백 제거하는 경우")
    @Test
    void calculateLottoTicketCountRemoveSpaces() {
        // given
        String receivedPurchasePrice = " 1 0 0 0 ";

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
                .hasMessage("[ERROR] 1,000원 단위로만 입력해 주세요.");
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

    @DisplayName("당첨 번호를 입력 받아 Lotto 객체로 반환한다.")
    @Test
    void receiveWinningLottoRemoveSpaces() {
        // given
        String receivedWinningLotto = " 1 , 2 , 3 , 4 , 5 , 2 6 ";

        // when
        Lotto winningLotto = lottoHandler.receiveWinningLotto(receivedWinningLotto);

        // then
        assertThat(winningLotto.equals(new Lotto(List.of(1, 2, 3, 4, 5, 26)))).isTrue();
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
                .hasMessage("[ERROR] 6개의 숫자를 쉼표로 구분해서 입력해 주세요.");
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

    @DisplayName("입력 받은 보너스 번호를 정수로 반환한다.")
    @Test
    void receiveBonusNumberRemoveSpaces() {
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

    @DisplayName("로또와 당첨 로또를 비교하여 당첨 결과를 리턴한다.")
    @Test
    void calculateResult() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 41));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 43));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        //when
        Map<WinningKind, Integer> winningKinds = lottoHandler.winningResult(lottos, winningLotto, bonusNumber);

        //then
        assertThat(winningKinds.get(WinningKind.FIRST)).isEqualTo(1);
        assertThat(winningKinds.get(WinningKind.SECOND)).isEqualTo(1);
        assertThat(winningKinds.get(WinningKind.THIRD)).isEqualTo(2);
    }

    @DisplayName("당첨 번호와 발행된 로또 번호를 비교해서 당첨 결를 반환한다.")
    @Test
    void calculateWinning() {
        //given
        int winningNumberCount = 5;
        boolean bonusMatch = true;
        Map<WinningKind, Integer> winningResult = new HashMap<>();
        winningResult.put(WinningKind.FIFTH, 0);
        winningResult.put(WinningKind.FOURTH, 0);
        winningResult.put(WinningKind.THIRD, 0);
        winningResult.put(WinningKind.SECOND, 0);
        winningResult.put(WinningKind.FIRST, 0);

        //when
        lottoHandler.calculateWinning(winningNumberCount, bonusMatch, winningResult);

        //then
        assertThat(winningResult.get(WinningKind.SECOND)).isEqualTo(1);
    }


    @DisplayName("로또 번호와 당첨 번호를 비교해서 당첨 번호와 일치하는 숫자의 개수를 반환한다.")
    @Test
    void winningNumberCount() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 3, 5, 7, 8, 9));

        //when
        int winningNumberCount = lottoHandler.winningNumberCount(lotto, winningLotto);

        //then
        assertThat(winningNumberCount).isEqualTo(3);
    }

    @DisplayName("당첨 결과에 따른 수익을 계산한다.")
    @Test
    void calculateRevenue() {
        //given
        Map<WinningKind, Integer> winningResult = new HashMap<>();
        winningResult.put(WinningKind.FIFTH, 2);
        winningResult.put(WinningKind.FOURTH, 1);
        winningResult.put(WinningKind.THIRD, 3);
        winningResult.put(WinningKind.SECOND, 0);
        winningResult.put(WinningKind.FIRST, 0);

        //when
        int revenue = lottoHandler.calculateRevenue(winningResult);

        //then
        assertThat(revenue).isEqualTo(4560000);
    }

    @DisplayName("로또 개수와 수익으로 수익률을 계산한다. 반올림하는 경우")
    @Test
    void calculateRateOfReturnRounds() {
        //given
        int numberOfLotto = 3;
        int revenue = 1505000;

        //when
        double rateOfReturn = lottoHandler.calculateRateOfReturn(numberOfLotto, revenue);

        //then
        assertThat(rateOfReturn).isEqualTo(50166.7);
    }

    @DisplayName("로또 개수와 수익으로 수익률을 계산한다. 나누어떨어지는 경우")
    @Test
    void calculateRateOfReturnDivided() {
        //given
        int numberOfLotto = 5;
        int revenue = 5000;

        //when
        double rateOfReturn = lottoHandler.calculateRateOfReturn(numberOfLotto, revenue);

        //then
        assertThat(rateOfReturn).isEqualTo(100.0);
    }

    @DisplayName("금액을 입력 받아 쉼표로 단위를 구분해서 반환한다.")
    @Test
    void formatPrice() {
        //given
        int price = 1000000;

        //when
        String formattedPrice = lottoHandler.formatPrice(price);

        //then
        assertThat(formattedPrice).isEqualTo("1,000,000");
    }

    @DisplayName("입력 받은 값에 공백이 있으면 공백을 제거한다.")
    @Test
    void removeSpaces() {
        //given
        String inputValue = " 1, 2 , 3 4,5";

        //when
        String removedInputValue = lottoHandler.removeSpaces(inputValue);

        //then
        assertThat(removedInputValue).isEqualTo("1,2,34,5");
    }

}