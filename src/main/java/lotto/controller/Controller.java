package lotto.controller;

import lotto.service.Service;

public class Controller {
	
	Service service = new Service();

	public void gameSet() {
		service.initBuyer();
		service.buyLotteries();
		service.showBuyingResult();
	}
	
	public void gamePlay() {
		service.goLottoGame();
	}
	
	public void gameResult() {
		service.countEachRank();
		service.showResultStats();
	}

}
