package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;

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
		while (!vaildMoney)inputMoney();
		lottoCnt = purchase / 1000;
		System.out.println("\n" + lottoCnt +"개를 구매했습니다.");
		lotto = new ArrayList<>(lottoCnt);
		run();
	}
	
	private void inputMoney() {
		String input = Console.readLine();
		int purchase = Integer.parseInt(input);
		try {
			isCorrectMoney(purchase);
		}
		catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 로또 1장의 가격은 1000원이므로, 구입 금액은 1000원의 배수여야 합니다.");
		}
	}
	
	private void isCorrectMoney(int n) throws IllegalArgumentException {
		if (n % 1000 == 0 && n >= 1000) {
			vaildMoney = true;
			return;
		}
		throw new IllegalArgumentException();
	}
	
	private void run() {
		createLotto();
		makeWinningNumber();
		finish();
	}
	
	private void createLotto() {
		for (int i=0; i<lottoCnt; i++) {
			makeNumbers();
		}
		printNumbers();
	}
	
	private void makeNumbers() {
		ArrayList<Integer> lst = new ArrayList<>(6);
		
		for (int i=0; i<6; i++) {
			int value = Randoms.pickNumberInRange(1,45);
			i += isContains(lst, value);
		}
		lotto.add(lst);
	}
	
	private int isContains(ArrayList<Integer> lst, int find) {
		if (!lst.contains(find)) {
			lst.add(find);
			return 0;
		}
		return -1;
	}
	
	private void printNumbers() {
		for (ArrayList<Integer> lst : lotto) {
			Collections.sort(lst);
			System.out.println("[" +  makeStr(lst) + "]");
		}
	}
	
	private String makeStr(ArrayList<Integer> lst) {
		return "";
	}
	
	private void makeWinningNumber() {
		
	}
	
	private void finish() {
		
	}
	
    public static void main(String[] args) {
    	Application game = new Application();
    	game.start();
    }
}