package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<Integer> lottoNum = getLotto();
    }
    
    public static List<Integer> getLotto() {
    	return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    
    public static List<Lotto> makeLotto(int count) {
    	List<Lotto> lottoRandomList = new ArrayList<Lotto>();
    	
    	for (int i = 0;i < count;i++) {
    		lottoRandomList.add(new Lotto(getLotto()));
    	}
    	
    	return lottoRandomList;
    }
    
    public static void printLottoList(List<Lotto> lottoList) {
    	for (Lotto lotto : lottoList) {
    		System.out.println(lotto.toString());
    	}
    }
    
    public static void printResult(List<Integer> lottoNum) {
    	System.out.println("당첨 통계");
    	System.out.println("---");
    	System.out.println();
    	
    	System.out.println("3개 일치 (5,000원) - " + num + "개");
    	System.out.println("4개 일치 (50,000원) - " + num + "개");
    	System.out.println("5개 일치 (1,500,000원) - " + num + "개");
    	System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + num + "개");
    	System.out.println("6개 일치 (2,000,000,000원) - " + num + "개");
    	System.out.println("총 수익률은 " + percentage + "%입니다.");
    }
}
