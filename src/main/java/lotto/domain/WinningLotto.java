package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private static final String COMMA = ",";
    private Lotto lotto;
    private int bonus;

    public WinningLotto() {
    }

    public Lotto getLotto() {
        return lotto;
    }
    public Integer getBonus(){
        return bonus;
    }

    public void convertWinningLotto(String lottoStr) {
        LottoValidator.winningLottoValidator(lottoStr);

        List<Integer> lotto = new ArrayList<Integer>();

        String[] splitStr = lottoStr.split(",");
        Arrays.stream(splitStr).forEach(
                l -> lotto.add(Integer.parseInt(l))
        );
        this.lotto=  new Lotto(lotto);
    }

    public void convertWinningBonus(String bonus) {
        LottoValidator.inputWinningBonusValidator(lotto.getNumbers(), bonus);
        this.bonus=  Integer.parseInt(bonus);
    }






}
