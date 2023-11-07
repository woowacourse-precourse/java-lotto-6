package lotto;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

import java.util.Arrays;
import java.util.stream.Collectors;
public class Checker {
	private static final int LOTTO_PRICE = 1000;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
	
	public static int checkPayment(String str) {
		int payment = Integer.parseInt(str);
		if(payment <= 0 || payment % LOTTO_PRICE != 0) {
			throw new IllegalArgumentException();
		}
		return payment / LOTTO_PRICE;
	}
	
	public static List<Integer> checkWinningInput(String str) {
		List<String> obj = Arrays.asList(str.split(","));
		List<Integer> intObj = obj.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		Set<Integer> numSet = new HashSet<>(intObj);
		if(numSet.size()!= intObj.size()){
			throw new IllegalArgumentException();
        }
		for (int e : intObj) {
			if (e > MAX_LOTTO_NUMBER || e < MIN_LOTTO_NUMBER) {
				throw new IllegalArgumentException();
			}
		}
		return intObj;
	}

	public static int checkBonusInput(List<Integer> list,String str) {
		int bonusNumber = Integer.parseInt(str);
		if(bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException();
		}
		for (int e : list){
			if (e == bonusNumber) {
				throw new IllegalArgumentException();
			}
		}
		return bonusNumber;
	}


}
