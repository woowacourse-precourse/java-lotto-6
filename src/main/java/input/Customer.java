package input;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import value.LottoDefaultValue;
import value.LottoDefaultMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Customer {
    public List<Lotto> lottos;

    public Customer() {
        this.lottos = new ArrayList<Lotto>();
    }
    
    public int getDrawCount() {
        System.out.println(LottoDefaultMessage.TOTAL_SPENDING_AMOUNT_MONEY.getString());
        int money = ConvertInput.numInput(readLine());
        return money / LottoDefaultValue.LOTTO_PRICE.getNumber();
    }

    public void buyLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(LottoDefaultValue.LOTTO_VALUE_MIN.getNumber(),
                LottoDefaultValue.LOTTO_VALUE_MAX.getNumber(),
                LottoDefaultValue.LOTTO_NUMBER_COUNT.getNumber());
        System.out.println(lotto);
        lottos.add(new Lotto(lotto));
    }

    public Lotto getLotto(int i) {
        return lottos.get(lottos.size() - 1);
    }

    public void removeLotto() {
        System.out.println(lottos.size());
        lottos.remove(lottos.size() - 1);
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
