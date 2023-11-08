package Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FisrtInput {

	ConsleManager ConsleManager = null;
	public String InputWinningNum;
	public int WinningNumCount = 0;
	public List<Integer> WinningNum = new ArrayList<Integer>();
	public Set<Integer> numSet;

	public FisrtInput(ConsleManager _ConsleManager) {
		ConsleManager = _ConsleManager;
	}

	public boolean gameIng() {
		InputWinningNum = ConsleManager.readLine();
		if (true == chk_LottoLength_isDigit()) {
			numSet = new HashSet<>(WinningNum);
			if (true == Dhk_duplication()) {
				return true;
			}
		}
		return false;
	}

	private boolean chk_LottoLength_isDigit() {
		String[] InputStringAyy;
		try {
			InputStringAyy = InputWinningNum.split(",");
			if (InputStringAyy.length != 6) {
				throw new IllegalArgumentException("[ERROR]당첨 번호 입력 갯수는 6개여야합니다.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR]당첨 번호 입력 갯수는 6개여야합니다. 당첨번호를 다시 입력해주세요.");
			return false;
		}
		for (int i = 0; i < InputStringAyy.length; i++) {
			WinningNum.add(Integer.parseInt(InputStringAyy[i]));
		}
		return true;
	}

	public List<Integer> get_WinningNum() {
		return WinningNum;
	}

	public boolean Dhk_duplication() {
		try {
			if (numSet.size() != WinningNum.size()) {
				WinningNum.clear();
				numSet.clear();
				throw new IllegalArgumentException("[ERROR]당첨 번호에 중복이있습니다.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR]당첨 번호에 중복이있습니다. 당첨번호를 다시 입력해주세요.");
			return false;
		}

		return true;
	}

}
