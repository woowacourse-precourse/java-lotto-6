package validator;

import static model.FixedValues.CREATOR;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;

public class Validator_Lotto {
	
	public Validator_Lotto() {}

	public Validator_Lotto(List<Integer> numbers) {
		correctlySixElements(numbers);
		validateEachElement(numbers);
	}
	
	private void correctlySixElements(List<Integer> numbers) {
    	if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호만 유효합니다");
        }
    }
    
    private void validateEachElement(List<Integer> numbers) {
    	for(int num:numbers) {
    		checkDuplicatedElements(num,numbers);
    		valueOutOfBoundary(num);
    	}
    }
    
    private void checkDuplicatedElements(int num,List<Integer> numbers) {
    	if(numbers.indexOf(num)!=numbers.lastIndexOf(num)) {
    		throw new IllegalArgumentException("[ERROR] 중복된 번호는 유효하지 않습니다");
    	}
    }
    
    private void valueOutOfBoundary(int num) {
    	if(num<1||num>45) {
    		throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    	}
    }
    
    public Lotto insertLottoNums(String selected) {
		List<Integer> numbers=convertToList(selected);

		return CREATOR.lottoCreator(numbers);
    }
    
    public List<Integer> convertToList(String selected) {
    	String [] splitStrs=selected.split(",");
    	
    	return convertToInteger(splitStrs);
    }
    
    private List<Integer> convertToInteger(String [] splitStrs) {
    	List<Integer> numbers=new ArrayList<Integer>();
    	
    	for(int i=0;i<splitStrs.length;i++) {
    		numbers.add(isInteger(splitStrs[i]));
    	}
    	return numbers;
    }

    private int isInteger(String str) {
    	int num;
    	try {
    		num=Integer.parseInt(str);
    	} catch(NumberFormatException e) {
    		//System.out.println("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)");
    		throw new IllegalArgumentException("[ERROR] 번호는 정수인 숫자만 유효합니다(공백 불가)");
    	}
    	return num;
    }
    
    public int bonusToInteger(String bonusStr) {
		int bonus=isInteger(bonusStr);
		valueOutOfBoundary(bonus);
		
		return bonus;
    }
    
    public void warning(IllegalArgumentException e) {
    	System.out.println(e.getMessage());
		e.printStackTrace();
    }
}
