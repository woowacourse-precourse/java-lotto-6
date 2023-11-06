package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class InputNumbers {

	private Lotto lotto;
	
    public List<Integer> select_numbers() {
    	List<Integer> numbers;
    	while(true) {
    		try {
	    		String selected=Console.readLine();
	    		numbers=convertToList(selected);
	    		lotto=new Lotto(numbers);
	    		break;
    		} catch(IllegalArgumentException e) {
    			e.printStackTrace();
    		}
    	}
    	//Collections.sort(numbers_refined);
    	return numbers;
    }
    
    public int select_bonus() {
    	int bonus;
    	while(true) {
    		try {
	    		String bonusStr=Console.readLine();
	    		bonus=naN(bonusStr);
	    		lotto.valueOutOfBoundary(bonus);
	    		break;
    		} catch(IllegalArgumentException e) {
    			e.printStackTrace();
    		}
    	}
    	return bonus;
    }
    
    /*public void forTest(List<Integer> test_input) {
    	if (test_input.size() != 6) {
    		System.out.println("[ERROR] 6개의 번호만 유효합니다");
            throw new IllegalArgumentException("[ERROR] 6개의 번호만 유효합니다");
        }
    	for(int num:test_input) {
    		if(test_input.indexOf(num)!=test_input.lastIndexOf(num)) {
    			System.out.println("[ERROR] 중복된 번호는 유효하지 않습니다");
        		throw new IllegalArgumentException("[ERROR] 중복된 번호는 유효하지 않습니다");
        	}
    		valueOutOfBoundary(num);
    	}
    }
    
    public List<Integer> forMyTest(String test_input) {
    	validate(test_input);
    	return numbers_refined;
    }*/
    
    /*private void validate(String selected) {
        String result;
        result=flexibleAcceptance(selected);
    	convertToList(result);
    	validateEachElement();
    	correctlySixElements();
    }*/
    
    private String flexibleAcceptance(String input) {
    	input=input.replace(" ", "");
    	return input;
    }
    
    private List<Integer> convertToList(String selected) {
    	selected=flexibleAcceptance(selected);
    	String [] splitStrs=selected.split(",");
    	
    	return convertToInteger(splitStrs);
    }
    
    private List<Integer> convertToInteger(String [] splitStrs) {
    	List<Integer> numbers=new ArrayList<Integer>();
    	
    	for(int i=0;i<splitStrs.length;i++) {
    		numbers.add(naN(splitStrs[i]));
    	}
    	return numbers;
    }

    /*private void correctlySixElements() {
    	if (numbers_refined.size() != 6) {
    		System.out.println("[ERROR] 6개의 번호만 유효합니다");
            throw new IllegalArgumentException("[ERROR] 6개의 번호만 유효합니다");
        }
    }
    
    private void validateEachElement() {
    	for(int num:numbers_refined) {
    		checkDuplicatedElements(num);
    		valueOutOfBoundary(num);
    	}
    }
    
    private void checkDuplicatedElements(int num) {
    	if(numbers_refined.indexOf(num)!=numbers_refined.lastIndexOf(num)) {
    		System.out.println("[ERROR] 중복된 번호는 유효하지 않습니다");
    		throw new IllegalArgumentException("[ERROR] 중복된 번호는 유효하지 않습니다");
    	}
    }*/

    private int naN(String str) {
    	int num;
    	try {
    		num=Integer.parseInt(str);
    	} catch(NumberFormatException e) {
    		System.out.println("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)");
    		throw new IllegalArgumentException("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)");
    	}
    	return num;
    }
    
    /*private void valueOutOfBoundary(int num) {
    	if(num<1||num>45) {
    		System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    		throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    	}
    }*/
}
