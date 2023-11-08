package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoStart;
import lotto.object.Lotto;

public class Application {
	// 공통 변수
	public static int purchaseAmount;
	public static int ticketNumber;
	public static int bonusLotto;
	public static Lotto playerLotto;
	public static List<Lotto> lottoGroup = new ArrayList<Lotto>();

	// main 메소드
	public static void main(String[] args) {
		LottoStart.startGame();
	}
}
