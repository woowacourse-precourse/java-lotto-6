package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		long numberOfLottoTickets = 3L;
		List<Lotto> lottos = lottoService.issueLottos(numberOfLottoTickets);

		assertEquals(3, lottos.size());
	}

	@DisplayName("로또 번호 오름차순 정렬 테스트")
	@Test
	void issueLottoTest2() {
		long numberOfLottoTickets = 100L;
		List<Lotto> lottos = lottoService.issueLottos(numberOfLottoTickets);

		for (Lotto lotto : lottos) {
			assertTrue(isSortedInAscendingOrder(lotto.getNumbers()));
		}
	}

	@DisplayName("입력받은 번호로 사용자 로또 발급하는 메서드 테스트")
	@Test
	void issueUserLottoTest() {
		String inputNumbers = "1,6,5,21,40,39";
		Lotto userLotto = lottoService.issueUserLotto(inputNumbers);

		assertThat(userLotto.getNumbers()).containsExactly(1, 6, 5, 21, 40, 39);
	}

	@DisplayName("컴퓨터 로또, 사용자 로또, 보너스 숫자를 받아" +
			"몇 등에 몇 개 당첨되었는지 구하는 메서드 테스트")
	@ParameterizedTest
	@CsvSource({"1,2,3,4,5,6,7,1", "1,2,3,4,5,7,6,2", "1,2,3,4,5,8,9,3",
			"1,2,3,4,8,9,10,4", "1,2,3,8,9,10,11,5"})
	void getWinningResultTest(int first, int second, int third, int fourth,
							  int fifth, int sixth, int bonus, int rank) {
		Lotto computer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
		List<Lotto> computers = new ArrayList<>();
		computers.add(computer);

		Lotto user = new Lotto(List.of(first, second, third, fourth, fifth, sixth));
		List<Integer> result = lottoService.getWinningResult(computers, user, bonus);

		assertEquals(1, result.get(rank));
	}

	@DisplayName("내가 산 로또의 개수와 당첨금액을 받아 수익률을 구하는 메서드 테스트")
	@Test
	void getProfitRateTest1() {

	}

	@DisplayName("수익률은 소수점 둘째 자리에서 반올림되는지 확인하는 테스트")
	@Test
	void getProfitRateTest2() {

	}

	private boolean isSortedInAscendingOrder(List<Integer> numbers) {
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i - 1) > numbers.get(i)) {
				return false;
			}
		}
		return true;
	}
}
