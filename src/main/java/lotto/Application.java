package lotto;
import java.util.ArrayList;
import java.util.List;

import lotto.domain.LottoStart;
import lotto.object.LottoNumber;


public class Application {
	// 공통 변수
	public static int purchaseAmount;
	public static int ticketNumber;
	public static List<Integer> playerNumber = new ArrayList<>();
	public static int bonusNumber;
	public static List<LottoNumber> lottoList = new ArrayList<LottoNumber>();
	public static List<Integer> computerNumber = new ArrayList<>();
	
	// main 메소드
    public static void main(String[] args) {
    	LottoStart.startGame();    	
    }    	
}
