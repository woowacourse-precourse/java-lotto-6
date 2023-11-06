package lotto.object;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

	private int lottoIndex = 0;
	private List<Integer> computerNumber = new ArrayList<Integer>();
	
	public LottoNumber(int lottoIndex, List<Integer> madeNumber) {
		this.lottoIndex = lottoIndex;
		this.computerNumber = madeNumber;
	}
	
	public List<Integer> getComputerNumber() {
		return this.computerNumber;
	}
	
//	public String printLottoNumber() {
//		return String.format("%s", this.madeNumber);
//	}
	
}
