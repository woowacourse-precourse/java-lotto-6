package lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer money;
    private List<Integer> inputLottoNumber;
    private Integer bonusNumber;

    public User(Integer money, List<Integer> inputLottoNumberList, Integer bonusNumber) {
        this.money = money;
        this.inputLottoNumber = inputLottoNumberList;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getInputLottoNumber() {
        return inputLottoNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public Integer getMoney() {
        return money;
    }
}
