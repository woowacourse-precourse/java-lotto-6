package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Customer {
    private int buyMoney;
    private List<Lotto> lottos = new ArrayList<>();

    private Customer(){}

    public Customer(int buyMoney) {
        validate(buyMoney);
        lottos = buyLotto(buyMoney);
        this.buyMoney = buyMoney;
    }

    public void showMyLotto() {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto myLotto : lottos) {
            System.out.println(myLotto);
        }
    }

    public int getBuyMoney() {
        return buyMoney;
    }

    private void validate(int num) {
        if(num % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 한다.");
    }

    private List<Lotto> buyLotto(int buyMoney) {
        List<Lotto> tempLotto = new ArrayList<>();
        for (int i = 0; i < buyMoney / 1000; i++) {
            tempLotto.add(new Lotto(lottoGenerator()));
        }
        return tempLotto;
    }

    private List<Integer> lottoGenerator() {
        int lottoSize = 6;
        List<Integer> tempNum = new ArrayList<>();
        while(lottoSize > 0){
            int pick = Randoms.pickNumberInRange(1, 45);
            if(tempNum.contains(pick)) continue;

            tempNum.add(pick);
            lottoSize--;
        }
        tempNum.sort(Comparator.comparingInt(Integer::intValue));
        return tempNum;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
