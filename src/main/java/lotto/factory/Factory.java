package lotto.factory;

import lotto.controller.Controller;
import lotto.dto.AmountDto;

public class Factory {
	public Controller lottoController() {
		return new Controller( );
	}
	

}