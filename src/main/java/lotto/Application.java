package lotto;

import java.util.List;

import lotto.Lotto;

public class Application {
    public static void main(String[] args) {

    	System.out.println("구매금액을 입력해 주세요.");
    	List<Integer>[] lotto = Lotto.make_lotto(Lotto.make_num());
    	
    	int num[] = Lotto.get_num();
    	int bonus = Lotto.get_bonus();
    
    	Lotto.compare_num(lotto, num);
    	Lotto.compare_bonus(lotto, bonus);
    }
}
