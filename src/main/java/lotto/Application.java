package lotto;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {    	
        // TODO: 프로그램 구현
    	Function function= new Function();
    	int money= function.inputMoney();
    	ArrayList<Integer>[] publishedNumbers= function.publishNumbers(money/1000);
    	
    	ArrayList<Integer> winningNumber= function.inputWinningNumber();
    	int bonusNumver= function.bonusNumber();
    	int[] matched= function.matchNumbers(publishedNumbers, winningNumber, bonusNumver);
    	function.showWinningDetails(matched);
    	function.showRateOfReturn(matched, money);
    	
    }
}
