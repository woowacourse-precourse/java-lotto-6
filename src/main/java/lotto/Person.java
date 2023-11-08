package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Person {
	private List<List<Integer>> lottoTicket = new ArrayList<>();
	private int pay;
	
	public void buyLotto(LottoMachine lottoMachine) {
		System.out.println("구입금액을 입력해주세요");
		pay = Integer.parseInt(Console.readLine());
		for(int i=0; i<pay/1000; i++) {
			List<Integer> numbers = lottoMachine.generateLottoTicket();
			lottoTicket.add(numbers);
		}
	}
	
	public void displayTicket() {
	    System.out.println(lottoTicket.size() + "개를 구매했습니다.");
	    for (List<Integer> ticket : lottoTicket) {
	    	ticket.sort(null);
	        System.out.println(ticket);
	    }
	}
	
	public int compareNum(List<Integer> ticket, List<Integer> winnigNumbers) {
		int count = 0;
		for(int number : ticket) {
			if(winnigNumbers.contains(number)) {
				count++;
			}
		}
		return count;
	}
	
	public int[] checkWinningNumber(DrawLotto drawLotto) {
		int result[] = new int[5];
		List<Integer> winningNumber = drawLotto.getNumbers();
    	List<Integer> bonusNumber = drawLotto.getBonusNumber();
    	for(List<Integer> ticket : lottoTicket) {
    		int count = compareNum(winningNumber, ticket);
    		boolean hasBonusNumber = ticket.containsAll(bonusNumber);
    		if(count == 3) {
    			result[0]++;
    		}
    		if(count == 4) {
    			result[1]++;
    		}
    		if(count == 5 && !hasBonusNumber) {
    			result[2]++;
    		}
    		if(count == 5 && hasBonusNumber) {
    			result[3]++;
    		}
    		if(count == 6) {
    			result[4]++;
    		}
    	}
    	return result;
    }
	
	public void displayResult(int[] count) {
		System.out.println("당첨 통계");
		System.out.println("---");
		System.out.println("3개 일치 (5,000원) - " + count[0] + "개");
		System.out.println("4개 일치 (50,000원) - " + count[1] + "개");
		System.out.println("5개 일치 (1,500,000원) - " + count[2] + "개");
		System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count[3] + "개");
		System.out.println("6개 일치 (2,000,000,000원) - " + count[4] + "개");
		System.out.println("총 수익률은 " + calculateProfit(count) + "%입니다.");
	}
	
	public double calculateProfit(int[] count) {
		int totalWinnings = count[0] * 5000 + count[1] * 50000 + count[2] * 1500000 + count[3] * 30000000 + count[4] * 2000000000;
		double profit = ((double)totalWinnings / pay) * 100;
		return profit;
	}
	
	public List<List<Integer>> getLottoTicket(){
		return lottoTicket;
	}
}
