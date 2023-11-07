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
	private boolean vaildMoney = false, validWinningNum = false, validBonusNum = false;
	private ArrayList<Integer> winningNumbers, rankCnt;
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
		ArrayList<String> stringN = new ArrayList<>();
		for (Integer n : lst) {
			stringN.add(n.toString());
		}
		String result = String.join(", ", stringN);
		return result;
	}
	
	private void makeWinningNumber() {
		winningNumbers = new ArrayList<>(7);
		while (!validWinningNum) {
			System.out.println("\n당첨 번호를 입력해 주세요.");
			winningNumber();
		}
			
		while (!validBonusNum) {
			System.out.println("\n보너스 번호를 입력해 주세요.");
			bonusNumber();
		}
	}
	
	private void winningNumber() {
		String str = Console.readLine();
		String[] parts = str.split(",");
		try {
			lenCheck(parts, 6);
			valueCheck(parts);
			isDuplicated(parts);
			validWinningNum = true;
		}
		catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 당첨 번호는 1~45 사이의 중복 없는 6개의 정수여야 합니다.");
		}
	}
	
	private void lenCheck(String[]s, int n) throws IllegalArgumentException{
		if (s.length != n)
			throw new IllegalArgumentException();
	}
	
	private void valueCheck(String []s) throws IllegalArgumentException {
		boolean isError = false;
		int num = 0;
		for (int i=0; i<s.length && isError == false &&num != -1; i++) {
			num = makeInteger(s[i]);
			isError = isRange(num);
		}
		if (isError == true)
			throw new IllegalArgumentException();
		if (num == -1)
			throw new IllegalArgumentException();
	}
	
	private int makeInteger(String v) {
		try {
			int n = Integer.parseInt(v);
			return n;
		}
		catch (NumberFormatException e) {
			return -1;
        }
	}
	
	private boolean isRange(int n) {
		return true;
	}
	
	private void isDuplicated(String[]s) {
		
	}

	
	private void bonusNumber() {
		
	}
	
	private void finish() {
		
	}
	
    public static void main(String[] args) {
    	Application game = new Application();
    	game.start();
    }
}