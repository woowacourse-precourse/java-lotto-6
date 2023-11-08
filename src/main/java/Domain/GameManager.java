package Domain;

import java.util.List;

public class GameManager {
	public ConsleManager ConsleManager = null;

	public enum GameLevels {
		START, FIRSTINPUT, SECONEDINPUT, END
	}

	public StartGame StartGame;
	public FisrtInput FisrtInput;
	public SeconedInput SeconedInput;
	public EndGame EndGame;
	public GameLevels GameLevel = GameLevels.START;
	public String InputMoney;

	public GameManager() {
		ConsleManager = new ConsleManager();
		StartGame = new StartGame(ConsleManager);
		FisrtInput = new FisrtInput(ConsleManager);
		SeconedInput = new SeconedInput(ConsleManager);
	}

	public void gamePlay() {		
		while (GameLevels.START == GameLevel) {	
			System.out.println("구입금액을 입력해 주세요.");
			if (true == StartGame.gameStart()) {
				GameLevel = GameLevels.FIRSTINPUT;
			}
		}
	}

	public void firstInput() {
		while (GameLevels.FIRSTINPUT == GameLevel) {
			System.out.println("당첨 번호를 입력해 주세요.");
			if (true == FisrtInput.gameIng()) {
				GameLevel = GameLevels.SECONEDINPUT;
			}
		}
	}

	public void seconedInput() {
		while (GameLevels.SECONEDINPUT == GameLevel) {
			System.out.println("보너스 번호를 입력해 주세요.");
			if (true == SeconedInput.gameIng()) {
				GameLevel = GameLevels.END;
			}
		}
	}

	public void gameEnd(List<List<Integer>> _MyLottos) {
		EndGame = new EndGame(_MyLottos);
		EndGame.gameIng(StartGame.get_LottoCount(), FisrtInput.get_WinningNum(), SeconedInput.get_BonusNum());
		EndGame.outPutMessage();
		EndGame.outPutRateReturnMessage(StartGame.get_LottoCount());
	}
}
