package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import lotto.Application;

enum Index {
	THREE(3),
	FOUR(4),
	FIVE(5),
	FIVE_BONUS(7),
	SIX(6);

	public int value;

	Index(int i) {
		this.setValue(i);
	}
	
	public void setValue(int name) {
		this.value = name;
	}
	
	public static Index test(int n) {
		for(Index s : Index.values() ) {
			if(s.value == n) {
				return s;
			}
		}
		return null;
	}
}


public class Lotto {
    private static List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
    }
    
    public void returnNumbers() {
    	System.out.println(this.numbers);
    	//return numbers;
    }
    
    private void validate(List<Integer> numbers) throws IllegalArgumentException { //입력받은 당첨번호 유효성 검사. 6개인지, 1-45사이인지, 중복 없는지
    	try {
    		validateSize(numbers);
        	validateRange(numbers);
        	validateDuplication(numbers);
    	}catch(IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    		numbers = Application.inputNumbers();
			validate(numbers);
    	}
    	this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
    	if (numbers.size() != 6) {
    		throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해 주세요.");
    	}
    }

	private void validateRange(List<Integer> numbers) {
    	for(int i = 0; i < numbers.size(); i++) {
    		if(numbers.get(i) < 1 || numbers.get(i) > 45 ) {
    			throw new IllegalArgumentException("[ERROR] 1-45의 숫자를 입력해 주세요.");
    		}
		}
    }
    
    private void validateDuplication(List<Integer> numbers) {
    	Set<Integer> testDuplication = new HashSet<Integer>(6);
    	testDuplication.addAll(numbers);
    	if (numbers.size() != testDuplication.size()) {
    		throw new IllegalArgumentException("[ERROR] 중복되지 않은 값을 입력해 주세요.");
    	}
    }
    
    public static void validateBonus(int bonus) { //1-45사이인지, 중복 없는지
    	validateRange(bonus);
    	validateDuplication(bonus);
    }
    
    private static void validateRange(int bonus) {
    	try {
    		if(bonus < 1 || bonus > 45 ) {
    			throw new IllegalArgumentException();
    		}
		}catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 1-45의 숫자를 입력해 주세요.");
			validateBonus(Application.inputBonus());
		}
    }
    
    private static void validateDuplication(int bonus) {
    	try {
    		Set<Integer> testDuplication = new HashSet<Integer>(6);
        	testDuplication.addAll(numbers);
    		if(testDuplication.contains(bonus)) {
    			throw new IllegalArgumentException();
    		}
		}catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 당첨 번호와 다른 숫자를 입력해 주세요.");
			validateBonus(Application.inputBonus());
		}
    }

    public List<Integer> compare(List<List<Integer>> myLotto, int bonus) { //당첨번호와 발행된 로또 비교하여 당첨내역 반환
    	List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));
    	
    	for(List<Integer> lotto : myLotto) {
    		boolean b = lotto.contains(bonus);
    		lotto.retainAll(numbers);
    		int size = lotto.size();
    		
    		if(size < 3) {
    			continue;
    		}
    		if(size == 5 && b) {
    			size = 7;
    		}
    		int value = result.get(Index.test(size).ordinal());
    		result.set(Index.test(size).ordinal(), value + 1);
    	}
    	return result;
    }
    
    public void printResult(List<Integer> result) {
    	System.out.println("\n당첨 통계"
    			+"\n---"
    			+ "\n3개 일치 (5,000원) - "+ result.get(0) + "개"
    			+ "\n4개 일치 (50,000원) - "+ result.get(1) + "개"
    			+ "\n5개 일치 (1,500,000원) - "+ result.get(2) + "개"
    			+ "\n5개 일치, 보너스 볼 일치 (30,000,000원) - "+ result.get(3) + "개"
    			+ "\n6개 일치 (2,000,000,000원) - "+ result.get(4) + "개");	
    }
    
    public void rateOfReturn(List<Integer> result, int purchase) { //수익률 계산해서 반환
    	ArrayList<Integer> income = new ArrayList<>(Arrays.asList(5000, 50000, 1500000, 30000000, 2000000000));
    	double totalIncome = 0;
    	for(int i = 0; i < result.size(); i++) {
    		totalIncome = totalIncome + income.get(i)*result.get(i);
    	}
    	System.out.println("총 수익률은 " + String.format("%.2f", totalIncome/purchase*100)+"%입니다.");
    }
}
