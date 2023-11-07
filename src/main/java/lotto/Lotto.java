package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

import camp.nextstep.edu.missionutils.*;

public class Lotto {
	
	private final List<Integer> numbers;
    
	public Lotto() {
	    numbers = new ArrayList<>();
	}
	
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자만 가능합니다.");
        }
    }
    
    public int getUserPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        
        if(purchaseAmount % 1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원단위로 입력하여야 합니다.");
        }
        
        System.out.println();
        return purchaseAmount;
    }
    
    public List<Integer> drawLottoNumbers() {
        HashSet<Integer> lottoNumbers = new HashSet<>();
        
        while(lottoNumbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            lottoNumbers.add(randomNumber);
        }
        List<Integer> sortedLotto = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLotto);
        return sortedLotto;
    }
    
    
    public void printPurchaseLottoNumbers() {
        int amount = getUserPurchaseAmount()/1000;
        System.out.println(amount+"개를 구매했습니다.");
        for(int i = 0; i < amount ; i++) {
            System.out.println(drawLottoNumbers());
        }
        
    }
    
    public List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        
        String getNumber = Console.readLine();
        String[] numberList = getNumber.split(",");
        
        List<Integer> winningNumber = new ArrayList<>();
        for (String numberValue : numberList) {
            int number = Integer.parseInt(numberValue.trim());
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winningNumber.add(number);
        }
        
        validate(winningNumber);
        
        return winningNumber;
    }
    
}
