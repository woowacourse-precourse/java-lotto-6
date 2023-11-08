package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EndGame {

	List<List<Integer>> MyLottos = new ArrayList<List<Integer>>();
	int WinCount = 0;
	int matche3 = 0;
	int matche4 = 0;
	int matche5 = 0;
	int matchebonus = 0;
	int matche6 = 0;
	List<Integer> WinLottoCount = new ArrayList<Integer>();

	public EndGame(List<List<Integer>> _MyLottos) {
		MyLottos = _MyLottos;
	}

	public boolean gameIng(int _LottoCount, List<Integer> _WinningNum, int _BonusNum) {
		System.out.println("");
		System.out.println("당첨 통계");
		System.out.println("---");

		for (int i = 0; i < _LottoCount; i++) {
			WinCount = 0;
			calculateWinCount(i, _WinningNum, _BonusNum);
		}
		calculateMatch();

		return true;
	}

	private void calculateWinCount(int _i, List<Integer> _WinningNum, int _BonusNum) {
		for (int i = 0; i < _WinningNum.size(); i++) {
			if (_WinningNum.contains(MyLottos.get(_i).get(i))) {
				++WinCount;
			}
		}

		if (5 == WinCount) {
			if (_WinningNum.contains(_BonusNum)) {
				WinCount = 99;
			}
		}
		WinLottoCount.add(WinCount);
	}

	private void calculateMatch() {
		matche3 = Collections.frequency(WinLottoCount, 3);
		matche4 = Collections.frequency(WinLottoCount, 4);
		matche5 = Collections.frequency(WinLottoCount, 5);
		matchebonus = Collections.frequency(WinLottoCount, 99);
		matche6 = Collections.frequency(WinLottoCount, 6);
	}

	public void outPutMessage() {
		System.out.println("3개 일치 (5,000원) - " + matche3 + "개");
		System.out.println("4개 일치 (50,000원) - " + matche4 + "개");
		System.out.println("5개 일치 (1,500,000원) - " + matche5 + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchebonus + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + matche6 + "개");
	}

	public void outPutRateReturnMessage(int _LottoCount) {
		double Momey = (_LottoCount * 1000);
		double RateReturn = (matche3 * 5000 + matche4 * 50000 + matche5 * 1500000 + matchebonus * 30000000
				+ matchebonus * 2000000000) / Momey * 100;
		System.out.println("총 수익률은 " + String.format("%.1f", RateReturn) + "%입니다.");
	}
}
