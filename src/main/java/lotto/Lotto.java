package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public static List<Lotto> buyLottoTickets(long purchaseAmount){
        if(purchaseAmount%1000!=0){
            throw new IllegalArgumentException("ERROR");
        }
        List<Lotto> buyLottoTickets = new ArrayList<>();
        int purchasesNum = (int) (purchaseAmount/1000);
        while(purchasesNum!=0){
            buyLottoTickets.add(getRandomNumLotto());
            purchasesNum --;
        }
        return buyLottoTickets;
    }

    private static Lotto getRandomNumLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto randomNumLotto = new Lotto(numbers);
        return  randomNumLotto;
    }
}
