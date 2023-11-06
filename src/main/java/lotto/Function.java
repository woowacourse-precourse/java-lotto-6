package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Function {
	
	protected int inputMoney() {
		String inputMoney="";
		boolean check= true;
		System.out.println("구입금액을 입력해 주세요.");
		while(check) {
			try {
				inputMoney= Console.readLine();
				check= validateMoney(inputMoney);
				break;
			}catch(IllegalArgumentException e) {
				System.out.print(e.getMessage());
			}
		}
		return Integer.parseInt(inputMoney);
	}
	
	private boolean validateMoney(String money) {
		boolean check= false;
		String RECEX="[0-9]+";
			if(!money.matches(RECEX)) {
				check= true;
				throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
			}
			if(Integer.parseInt(money)%1000!= 0) {
				check= true;
				throw new IllegalArgumentException("[ERROR] 로또 구입 금액의 단위는 1,000원 입니다.");
			}
		return check;
	}
	
	protected ArrayList<Integer> inputWinningNumber(){
		boolean check= true;
		String[] inputWinningValue= new String[6];
		System.out.println("당첨 번호를 입력해 주세요.");
		while(check) {
			try {
				inputWinningValue= Console.readLine().split(",");
				check= validateWinningNumber(inputWinningValue);
				break;
			}catch(IllegalArgumentException e) {
				System.out.print(e.getMessage());
			}
		}		
		ArrayList<Integer> winningNumbers= new ArrayList<Integer>();
		winningNumbers= conversionToInt(inputWinningValue);
		return winningNumbers;
	}
	
	private ArrayList<Integer> conversionToInt(String[] list) {
		ArrayList<Integer> winningNumbers= new ArrayList<Integer>();
		for(int i= 0; i<list.length; i++) {
			winningNumbers.add(Integer.parseInt(list[i]));
		}
		return winningNumbers;
	}
	
	private boolean validateWinningNumber(String[] winningNum) {
		boolean check= false;
		for(int i= 0; i<winningNum.length; i++) {
			if(winningNum[i].getClass()!= String.class) {
				check= true;
				throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
			}
			if(winningNum.length!= 6 ) {
				check= true;
				throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입해 주세요.");
			}
			if(Integer.parseInt(winningNum[i])<0 || Integer.parseInt(winningNum[i])>45) {
				check= true;
				throw new IllegalArgumentException("[ERROR] 1에서 45사이의 숫자를 입력해 주세요.");
			}
		}
		return check;
	}
	
	protected int bonusNumber() {
		System.out.println("보너스 번호를 입력해 주세요.");
		boolean check= true;
		String bonusNumber= "";
		while(check){
			try {
				bonusNumber= Console.readLine();
				check= validateBonusNumber(bonusNumber);
				break;
			}catch(IllegalArgumentException e) {
				System.out.print(e.getMessage());
			}
			
		}
		return Integer.parseInt(bonusNumber);
	}

	private boolean validateBonusNumber(String bonusNumber) {
		boolean check= false;
		String RECEX="[0-9]+";
		if(!bonusNumber.matches(RECEX)) {
			check= true;
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
		}
		if(Integer.parseInt(bonusNumber)>45 || Integer.parseInt(bonusNumber)<0) {
			check= true;
			throw new IllegalArgumentException("[ERROR] 1에서 45사이의 숫자를 입력해 주세요.");
		}
		return check;
	}

	protected ArrayList<Integer>[] publishNumbers(int count) {
		ArrayList<Integer>[] publishedNumbers= new ArrayList[count];
		System.out.println(count+"개를 구매했습니다. ");
		for(int i=0; i<count; i++) {
			publishedNumbers[i]=new ArrayList<Integer>();
			List<Integer> numbers= Randoms.pickUniqueNumbersInRange(1, 45, 6);
			Collections.sort(numbers);
			publishedNumbers[i].addAll(numbers);
			System.out.println(publishedNumbers[i]);
		}	
		return publishedNumbers;
	}
	
	protected int[] matchNumbers(ArrayList<Integer>[] numbers, ArrayList<Integer> winningNumber, int bonusNumber) {
		int[] matched= new int[7];
		for(ArrayList<Integer> num:numbers) {
			int count= eachMatchedNum(num, winningNumber);
			if(count==5) {
				count=bonusMatch(num, bonusNumber, count );
			}
			matched[count]+=1;
		}
		return matched;
	}
	private int eachMatchedNum(ArrayList<Integer> number,  ArrayList<Integer> winningNumber) {
		int count= 0;
		for(Integer num : winningNumber) {
			if(number.contains(num)) {
				count+=1;
			}
		}
		return count;
	}
	private int bonusMatch(ArrayList<Integer> number, int bonusNumber, int count) {
		if(number.equals(bonusNumber)) {
			count= 7;
		}
		return count;
	}
}
