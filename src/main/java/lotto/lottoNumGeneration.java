package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class lottoNumGeneration {

	private static final int lottoNumberCount = 6;
	private static final int minLottoNumber = 1;
	private static final int maxLottoNumber = 45;

	public static List<Integer> generateLottoNumberList(){
		List<Integer> lottoNumberList = Randoms.pickUniqueNumbersInRange(minLottoNumber, maxLottoNumber, lottoNumberCount);
		Collections.sort(lottoNumberList);
		return lottoNumberList;
	}

	public static List<List<Integer>> generateLottoNumberLists(int purchasableLottoTickets){

		List<List<Integer>> lottoNumberLists = new ArrayList<>();

		for (int i = 0; i < purchasableLottoTickets; i++) {
			List<Integer> lottoNumberList = generateLottoNumberList();
			lottoNumberLists.add(lottoNumberList);
		}
		return lottoNumberLists;
	}
}
