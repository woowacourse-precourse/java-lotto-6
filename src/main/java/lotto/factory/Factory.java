package lotto.factory;

import lotto.controller.Controller;

public class Factory {
	public Controller lottoController() {
		return new Controller();
	}
}