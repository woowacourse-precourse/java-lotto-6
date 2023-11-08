package lotto;

public class userInputValidation {

	public static void userPurchaseAmountValidation(int userPurchaseAmount){
		if (userPurchaseAmount % 1000 != 0){
			System.out.println("[ERROR] 구입금액은 1000원 단위로만 입력해주세요.");
			throw new IllegalArgumentException();
		}
	}

	public static void userPurchaseAmountMinValidation(int userPurchaseAmount){
		if (userPurchaseAmount < 1000){
			System.out.println("[ERROR] 구입금액은 1000원 이상으로 입력해주세요.");
			throw new IllegalArgumentException();
		}
	}
}
