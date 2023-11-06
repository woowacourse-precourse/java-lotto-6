package lotto.model;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoService {
	//1000단위의 정수당 한개의 Lotto 객체 리스트
	public static List<Lotto> createObjectPerThousandUnits(int inputData){
		int playerInputThousands = inputData/1000;
		List<Lotto> lotto_list = new ArrayList<Lotto>();
		for(int i=1;i<=playerInputThousands;i++) {
			Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
			lotto_list.add(lotto);
		}
		return lotto_list;
	}
	
	
}
