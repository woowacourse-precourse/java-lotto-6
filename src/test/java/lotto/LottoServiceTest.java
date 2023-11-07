package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoServiceTest {

	LottoService lottoService;

	@BeforeEach
	void setup() {
		lottoService = new LottoService();
	}

	@DisplayName("매개변수로 돈을 받아 몇 개의 로또를 구매했는지 구하는 메서드 테스트")
	@Test
	void getNumberOfLottoTicketsTest() {
		String cost1 = "1000";
		String cost2 = "10000";
		String cost3 = "20000";
		String cost4 = "24000";
		String cost5 = "30000";

		assertEquals(1L, lottoService.getNumberOfLottoTickets(cost1));
		assertEquals(10L, lottoService.getNumberOfLottoTickets(cost2));
		assertEquals(20L, lottoService.getNumberOfLottoTickets(cost3));
		assertEquals(24L, lottoService.getNumberOfLottoTickets(cost4));
		assertEquals(30L, lottoService.getNumberOfLottoTickets(cost5));
	}

	@DisplayName("구입 금액에 해당하는 만큼 로또가 발행되는 메서드 테스트")
	@Test
	void issueLottosTest1() {

	}

	@DisplayName("로또 번호 오름차순 정렬 테스트")
	@Test
	void issueLottoTest2() {

	}

	@DisplayName("입력받은 번호로 사용자 로또 발급하는 메서드 테스트")
	@Test
	void issueUserLottoTest() {

	}

	@DisplayName("컴퓨터 로또, 사용자 로또, 보너스 숫자를 받아" +
			"몇 등에 몇 개 당첨되었는지 구하는 메서드 테스트")
	@Test
	void getWinningResultTest() {

	}

	@DisplayName("내가 산 로또의 개수와 당첨금액을 받아 수익률을 구하는 메서드 테스트")
	@Test
	void getProfitRateTest1() {

	}

	@DisplayName("수익률은 소수점 둘째 자리에서 반올림되는지 확인하는 테스트")
	@Test
	void getProfitRateTest2() {

	}
}
