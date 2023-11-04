package lotto.object;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

	private int lottoIndex = 0;
	private List<Integer> madeNumber = new ArrayList<>();
		
	public LottoNumber(int lottoIndex, List<Integer> madeNumber) {
		this.lottoIndex = lottoIndex;
		this.madeNumber = madeNumber;
	}
	
//	public String printLottoNumber() {
//		return String.format("%s", this.madeNumber);
//	}
	
}
