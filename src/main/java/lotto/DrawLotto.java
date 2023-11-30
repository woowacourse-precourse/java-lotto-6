package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class DrawLotto {

	public List<Integer> getNumbers() {
		List<Integer> winnigNumbers = new ArrayList<>();
		System.out.println("당첨 번호를 입력해 주세요.");
    	StringTokenizer st = new StringTokenizer(Console.readLine(), ",");
    	for(int i=0; i<6; i++) {
    		winnigNumbers.add(Integer.parseInt(st.nextToken())); 
    	}
    	return winnigNumbers;
    }
	
	public List<Integer> getBonusNumber(){
		System.out.println("보너스 번호를 입력해 주세요.");
		List<Integer> bonusNumber = new ArrayList<>();
		int bonusNum = Integer.parseInt(Console.readLine());
		bonusNumber.add(bonusNum);
		return bonusNumber;
	}
}
