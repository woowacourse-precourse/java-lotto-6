package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.DiviedThousandException;
import lotto.exception.InputMoneyZeroException;
import lotto.exception.InvalidInputNumFormatException;

import java.util.List;
import java.util.regex.Pattern;

public class User {
    private static final int ZERO = 0;
    private static final int LOTTOVALUE = 1000;

    private Integer money;

    private List<Lotto> lottos;

    public void inputMoney() {
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

    public Integer getMoney(){
        return this.money;
    }

    public Integer getLottoCount() {
        return this.money/1000;
    }

    private void validateValue(Integer money) {
        validateDivide(money);
        validateZero(money);
    }

    private void validateFormat(String money) {
        if (!Pattern.compile("\\d+").matcher(money).matches()) {
            throw new InvalidInputNumFormatException();
        }
    }

    private void validateDivide(Integer money) {
        if (money % LOTTOVALUE != ZERO) {
            throw new DiviedThousandException();
        }
    }

    private void validateZero(Integer money) {
        if (money == ZERO) {
            throw new InputMoneyZeroException();
        }
    }
}
