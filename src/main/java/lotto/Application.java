package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

class IllegalArgumentException extends Exception{
	public IllegalArgumentException() {
	}
}

public class Application {
	private int lottoCnt, purchase;
	private boolean vaildMoney;
	private ArrayList<ArrayList<Integer>> lotto;
	public void start() {
		System.out.println("구입금액을 입력해 주세요.");	
		while (!vaildMoney)
			inputMoney();
		
		lottoCnt = purchase / 1000;
		System.out.println("\n" + lottoCnt +"개를 구매했습니다.");
		lotto = new ArrayList<>(lottoCnt);
		run();
	}
	
	private void inputMoney() {
	}
	
	private void run() {
		
	}
	
    public static void main(String[] args) {
    	Application game = new Application();
    	game.start();
    }
}