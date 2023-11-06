package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import lotto.Application;

public class Lotto {
    private static List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
    }
    
    public void returnNumbers() {
    	System.out.println(this.numbers);
    	//return numbers;
    }
    
    private void validate(List<Integer> numbers) { //입력받은 당첨번호 유효성 검사. 6개인지, 1-45사이인지, 중복 없는지
    	validateSize(numbers);
    	validateRange(numbers);
    	validateDuplication(numbers);
    	this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
    	try {
    		if (numbers.size() != 6) {
                throw new IllegalArgumentException();
            }
		}catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 6개의 숫자를 입력해 주세요.");
			numbers = Application.inputNumbers();
			validate(numbers);
		}
    	
    }
    
    private void validateRange(List<Integer> numbers) {
    	
    	try {
    		for(int i = 0; i < numbers.size(); i++) {
    			if(numbers.get(i) < 1 || numbers.get(i) > 45 ) {
    				throw new IllegalArgumentException();
    			}
			}
		}catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 1-45의 숫자를 입력해 주세요.");
			numbers = Application.inputNumbers();
			validate(numbers);
		}
    }
    
    private void validateDuplication(List<Integer> numbers) {
    	Set<Integer> testDuplication = new HashSet<Integer>(6);
    	testDuplication.addAll(numbers);

    	try {
    		if (numbers.size() != testDuplication.size()) {
                throw new IllegalArgumentException();
            }
		}catch(IllegalArgumentException e) {
			System.out.println("[ERROR] 중복되지 않은 값을 입력해 주세요.");
			numbers = Application.inputNumbers();
			validate(numbers);
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
    	List<Integer> result = new ArrayList<>(5);
    	return result;
    }
    
    public double rateOfReturn(List<Integer> result, int purchase) { //수익률 계산해서 반환
    	return 0.1;
    }
}
