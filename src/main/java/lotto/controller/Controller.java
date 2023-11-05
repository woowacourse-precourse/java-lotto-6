package lotto.controller;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
	String money;
	boolean tfCheck;
	int checkMoney;
	
	public Controller() {}
	
	public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
	}

	public void start() {
		System.out.println("구입금액을 입력해 주세요.");
		howMoney();
	}
	
	//금액 입력
	public int howMoney() {
		money = Console.readLine();
		for(int i = 0; i <money.length() ; i++) {
			checkMoney();
		}
		if(tfCheck = true) {
			checkMoney = Integer.parseInt(money);
		}
		
		return checkMoney;
	}
	
	//금액이 숫자인지 체크
	public boolean checkMoney() {
		if(money.matches(".*[0-9].*")) {
			tfCheck = true;
		}
		
		return tfCheck;
	}
	

}
