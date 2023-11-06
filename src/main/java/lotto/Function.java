package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Function {
	
	protected int inputMoney() {
		String inputMoney="";
		boolean check= true;
		while(check) {
			try {
				inputMoney= Console.readLine();
				check= validateMoney(inputMoney);
				break;
			}catch(IllegalArgumentException e) {
				System.out.print(e.getMessage());
			}
		}
		int money= Integer.parseInt(inputMoney);

		return money;
	}
	
	private boolean validateMoney(String money) {
		boolean check= false;
		String RECEX="[0-9]+";
			if(!money.matches(RECEX)) {
				check= true;
				throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
			}
			if(Integer.parseInt(money)%1000!= 0) {
				check= true;
				throw new IllegalArgumentException("[ERROR] 로또 구입 금액의 단위는 1,000원 입니다.");
			}
		return check;
	}
}
