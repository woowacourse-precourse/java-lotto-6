package Domain;

import java.util.regex.Pattern;

public class StartGame {

	public String InputMoney;
	public int LottoCount = 0;
	ConsleManager ConsleManager = null;

	public StartGame(ConsleManager _ConsleManager) {
		ConsleManager = _ConsleManager;
	}

	public boolean gameStart() {
		InputMoney = ConsleManager.readLine();
		if (true == lottoCount()) {
			outputLottoCountMessage();
			return true;
		}
		return false;
	}

	private boolean lottoCount() {
		if (true == chk_isDigit()) {
			LottoCount = Integer.parseInt(InputMoney);
			return chk_Unit();
		}
		return false;
	}

	public boolean chk_isDigit() {
		try {
			if (!Pattern.matches("^[0-9]*$", InputMoney)) {
				throw new IllegalArgumentException("[ERROR]구입금액을 숫자만로 입력해주세요.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR]구입금액을 숫자만로 입력해주세요.");
			return false;
		}
		return true;
	}

	public boolean chk_Unit() {
		try {
			if (0 != LottoCount % 1000) {
				throw new IllegalArgumentException("[ERROR]구입금액을 1,000단위로 입력해주세요.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR]구입금액을 1,000단위로 입력해주세요.");
			return false;
		}
		return true;
	}

	private void outputLottoCountMessage() {
		LottoCount = LottoCount / 1000;
		System.out.println("");
		System.out.println(LottoCount + "개를 구매했습니다.");

	}

	public int get_LottoCount() {
		return LottoCount;
	}
}
