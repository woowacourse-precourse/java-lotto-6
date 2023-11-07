package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Collections;

import camp.nextstep.edu.missionutils.*;

public class Lotto {
	
	private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자만 가능합니다.");
        }
    }
    
    private int getUserPay() {
        System.out.println("구입금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        return purchaseAmount;
    }
    
    private List<Integer> drawLottoNumbers() {
        HashSet<Integer> lottoNumbers = new HashSet<>();
        
        while(lottoNumbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            lottoNumbers.add(randomNumber);
        }
        List<Integer> sortedLotto = new ArrayList<>(lottoNumbers);
        Collections.sort(sortedLotto);
        return sortedLotto;
    }
    
}
