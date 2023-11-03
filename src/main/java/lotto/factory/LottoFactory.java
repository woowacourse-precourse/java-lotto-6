package lotto.factory;

import lotto.controller.Controller;
import lotto.dto.AmountDto;

public class LottoFactory {
	public Controller lottoController() {
		return new Controller( );
	}
	

}