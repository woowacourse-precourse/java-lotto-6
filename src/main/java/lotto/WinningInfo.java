//WinningInfo.java
package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lotto.Enum.Prize;

public class WinningInfo {
	private WinningNumbers winningNumbers;
	private BonusNumber bonusNumber;

	public WinningInfo(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public WinningNumbers getWinningNumbers() {
		return this.winningNumbers;
	}

	public BonusNumber getBonusNumber() {
		return this.bonusNumber;
	}
}
