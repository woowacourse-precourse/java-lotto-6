package lotto;

public class LottoService {
	InputValidator inputValidator = new InputValidator();
	Long money;

	public int getNumberOfLottoTickets(String cost) throws IllegalArgumentException {
		inputValidator.isComposedOfNumbers(cost);

		money = Long.parseLong(cost);
		inputValidator.isMultiplesOfThousand(money);
		return 0;
	}
}
