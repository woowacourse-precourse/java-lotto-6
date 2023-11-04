package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class User {
    private static final int ZERO = 0;
    private static final int LOTTOVALUE = 1000;

    private Integer money;

    private List<Lotto> lottos;

    public void inputMoney(){
        String moneyStr = Console.readLine();
        validateFormat(moneyStr);
        Integer money = Integer.parseInt(moneyStr);
        validateValue(money);
        this.money = money;
        LottoGenerater lottoGenerater = new LottoGenerater();
        lottos = lottoGenerater.generateLottos(money);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private void validateValue(Integer money){
        validateDivide(money);
        validateZero(money);
    }

    private void validateFormat(String money){
        if (!Pattern.compile("\\d+").matcher(money).matches()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivide(Integer money){
        if (money % LOTTOVALUE != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateZero(Integer money) {
        if (money == ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
