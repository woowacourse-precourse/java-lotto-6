package service;

import domain.Lotto;
import domain.Rank;
import domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ServiceTest {
    Service service = new Service();
    @DisplayName("입력을 유효성 검사 후 정수형의 돈으로 반환해준다.")
    @Test
    void getMoneyByUserInput() {
        assertThat(service.getMoneyByUserInput("10000")).isEqualTo(10000);
    }

    @DisplayName("로또를 생성한다.")
    @Test
    void generateLottoIsInstanceOfLottoClass() {
        List<Lotto> result = service.generateLottos(8);
        assertThat(result.get(0)).isInstanceOf(Lotto.class);
    }

    @DisplayName("입력값만큼 로또 티켓을 생성한다.")
    @Test
    void countGenerateLottos() {
        List<Lotto> result = service.generateLottos(8);
        assertThat(result).hasSize(8);
    }

    @DisplayName("구입 금액에 따른 로또 티켓량을 계산한다.")
    @Test
    void calculateNumberOfLottoTicket() {
        int result = service.calculateNumberOfLottoTicket(10000);
        assertThat(result).isEqualTo(10);
    }
    @DisplayName("입력한 번호를 가지고 정수형 리스트로 변환해준다.")
    @Test
    void generateListByUserInput() {
        Lotto result = service.generateLottoByUserInput("1,2,3,4,5,6");
        assertThat(result.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }
    @DisplayName("입력한 번호를 가지고 로또로 변환해준다.")
    @Test
    void generateLottoByUserInput() {
        Lotto result = service.generateLottoByUserInput("1,2,3,4,5,6");
        assertThat(result).isInstanceOf(Lotto.class);
    }

    @DisplayName("입력한 번호를 보너스 번호로 변환해준다.")
    @Test
    void getBonusNumberByUserInput() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumber result = service.generateWinningNumberWithBonusNumberByUserInput("7",lotto);
        assertThat(result.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("입력한 번호를 가지고 당첨 번호로 변환해준다.")
    @Test
    void generateWinningNumberWithBonusNumberByUserInput() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumber result = service.generateWinningNumberWithBonusNumberByUserInput("7",lotto);
        assertThat(result).isInstanceOf(WinningNumber.class);
    }

    @DisplayName("로또들과 당첨 번호를 비교하여 등수와 그에 해당하는 티켓수량을 가져온다.")
    @Test
    void getTicketRank() {
        List<Lotto> lottos = new ArrayList<Lotto>();
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(firstLotto,7);
        lottos.add(firstLotto);
        lottos.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));
        lottos.add(new Lotto(List.of(14, 15, 16, 17, 18, 19)));
        LinkedHashMap result = service.getLottoResult(lottos,winningNumber);
        assertThat(result.get(Rank.FIRST_PLACE)).isEqualTo(1);
    }

    @DisplayName("로또 결과를 가지고 총 수익을 계산해준다.")
    @Test
    void calculateSumOfPrizeMoney() {
        LinkedHashMap lottoResult = new LinkedHashMap<>();
        lottoResult.put(Rank.FIFTH_PLACE,1);
        lottoResult.put(Rank.FOURTH_PLACE,0);
        lottoResult.put(Rank.THIRD_PLACE,0);
        lottoResult.put(Rank.SECOND_PLACE,0);
        lottoResult.put(Rank.FIRST_PLACE,0);
        long sumOfPrizeMoney = service.calculateSumOfPrizeMoney(lottoResult);
        assertThat(sumOfPrizeMoney).isEqualTo(5000L);
    }
    @DisplayName("로또 결과와 구입 금액을 가지고 수익률을 계산해준다.")
    @Test
    void calculateRateOfReturn() {
        int inputMoney = 5000;
        LinkedHashMap lottoResult = new LinkedHashMap<>();
        lottoResult.put(Rank.FIFTH_PLACE,1);
        lottoResult.put(Rank.FOURTH_PLACE,0);
        lottoResult.put(Rank.THIRD_PLACE,0);
        lottoResult.put(Rank.SECOND_PLACE,0);
        lottoResult.put(Rank.FIRST_PLACE,0);
        float rateOfReturn = service.calculateRateOfReturn(lottoResult,inputMoney);
        assertThat(rateOfReturn).isEqualTo(100.0f);
    }

}
