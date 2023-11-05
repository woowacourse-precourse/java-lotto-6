package lotto;

public class Money {
	private int money;

	public Money(String money){
		validate(money);
		this.money = Integer.parseInt(money);
	}

	private int validate(String input) {
		if (!input.matches("\\d+")) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해주세요.");
		}

		int pay = Integer.parseInt(input);

		if (pay < 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 0보다 큰 값이여야 합니다.");
		}

		if (pay % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
		}

		if(pay < 1000) {
			throw new IllegalArgumentException("[ERROR] 1000 이상의 숫자를 입력해주세요.");
		}
		return pay;
	}

	public int calculateLottoCount(){
		//이후에 Constant 추가
		return this.money/1000;
	}

	//test code 에서만 사용
	public int getMoney(){
		return this.money;
	}
}
