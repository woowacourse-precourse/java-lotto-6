package lotto;

public class LottoService {
	InputValidator inputValidator = new InputValidator();

	public int getNumberOfLottoTickets(String cost) throws IllegalArgumentException{
		inputValidator.isComposedOfNumbers(cost);
		return 0;
	}
}
