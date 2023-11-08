package Domain;

public class SeconedInput {
	ConsleManager ConsleManager = null;
	public String InputBonusNum;
	public Integer BonusNum = 0;

	public SeconedInput(ConsleManager _ConsleManager) {
		ConsleManager = _ConsleManager;
	}

	public boolean gameIng() {
		InputBonusNum = ConsleManager.readLine();
		if (true == chk_LottoLength_isDigit()) {
			return true;
		}
		return false;

	}

	private boolean chk_LottoLength_isDigit() {
		String[] InputStringAyy;
		try {
			InputStringAyy = InputBonusNum.split(",");
			if (InputStringAyy.length != 1) {
				throw new IllegalArgumentException("[ERROR]당첨 번호 입력 갯수는 1개여야합니다.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR]보너스 번호 입력 갯수는 1개여야합니다. 당첨번호를 다시 입려해주세요.");
			return false;
		}
		BonusNum = Integer.parseInt(InputStringAyy[0]);
		return true;
	}

	public Integer get_BonusNum() {
		return BonusNum;
	}
}
