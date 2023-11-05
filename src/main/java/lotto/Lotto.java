package lotto;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private static List<Integer> numbers_refined;

    /*public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }*/
    
    public List<Integer> select_numbers() {
    	while(true) {
    		try {
	    		String selected=Console.readLine();
	    		validate(selected);
	    		break;
    		} catch(IllegalArgumentException e) {
    			e.printStackTrace();
    		}
    	}
    	return numbers_refined;
    }
    
    private void validate(String selected) {
        String result;
        result=flexibleAcceptance(selected);
    	convertToList(result);
    	validateEachElement();
    	correctlySixElements();
    }
    
    public String flexibleAcceptance(String input) {
    	input=input.replace(" ", "");
    	return input;
    }
    
    private void convertToList(String selected) {
    	String [] splitStrs=selected.split(",");
    	convertToInteger(splitStrs);
    }
    
    private void convertToInteger(String [] splitStrs) {
    	for(int i=0;i<splitStrs.length;i++) {
    		numbers_refined.add(naN(splitStrs[i]));
    	}
    	//this.numbers=Collections.sort(numbers);
    }

    private void correctlySixElements() {
    	if (numbers_refined.size() != 6) {
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
    		throw new IllegalArgumentException("[ERROR] 중복된 번호는 유효하지 않습니다");
    	}
    }

    private int naN(String str) {
    	int num;
    	try {
    		num=Integer.parseInt(str);
    	} catch(NumberFormatException e) {
    		throw new IllegalArgumentException("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)");
    	}
    	return num;
    }
    
    private void valueOutOfBoundary(int num) {
    	if(num<1||num>45) {
    		throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    	}
    }
}
