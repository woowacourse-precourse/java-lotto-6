package validator;

import camp.nextstep.edu.missionutils.Console;

public class Provider {
	
	public static String provideLotto() {
		return flexibleAcceptance_lotto(Console.readLine());
	}
	
	private static String flexibleAcceptance_lotto(String input) {
		return input.replace(" ", "");
    }
	
	public static String provideMoney() {
		return flexibleAcceptance_money(Console.readLine());
	}
	
	private static String flexibleAcceptance_money(String purchase_amount) {
		return purchase_amount.replace(" ", "").replace(".", "").replace(",", "");
	}
}
