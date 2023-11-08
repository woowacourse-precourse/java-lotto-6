package lotto;

import Domain.GameManager;
import Domain.LottoContainer;

public class Application {
	public static void main(String[] args) {
		int MyLottoCount = 0;

		GameManager GameManager = new GameManager();		
		GameManager.gamePlay();
		
		MyLottoCount = GameManager.StartGame.get_LottoCount();
		LottoContainer LottoContainer = new LottoContainer(MyLottoCount);
		LottoContainer.makeMyLotto();
		LottoContainer.outputMyLotto();

		GameManager.firstInput();
		GameManager.seconedInput();
		GameManager.gameEnd(LottoContainer.get_MyLottos());		
	}
}
