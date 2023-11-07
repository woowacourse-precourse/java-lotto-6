package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    public int money;
    public int lottoCount;
    public List<Lotto> userLotto;
    public double returnRate;

    public UserData(){
        inputMoney();
        setLottoCount();

        setUserLotto();
    }

    public void inputMoney(){
        int rawMoney = Integer.parseInt(Console.readLine());
        validateMoney(rawMoney);
        money = rawMoney;
    }

    public void validateMoney(int raw){
        if(raw % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void setLottoCount(){
        lottoCount = money / 1000;
    }

    public Lotto getRandomLotto(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public void setUserLotto(){
        userLotto = new ArrayList<>(lottoCount);
        for(int i = 0; i<lottoCount; i++){
            userLotto.add(getRandomLotto());
        }
    }

    public void printUserLotto(){
        for(int i = 0;i<lottoCount;i++){
            userLotto.get(i).printLotto();
        }
    }
}
