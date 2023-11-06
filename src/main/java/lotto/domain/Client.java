package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant.ErrorMessageConstant;
import lotto.view.ErrorMessageView;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Client {
    private Lotto lotto;
    private int bonusNum;

    public Lotto getLotto() {
        return this.lotto;
    }

    public void setLotto() {
        this.lotto = getCilentLotto();
    }

    public int getBonusNum() {
        return this.bonusNum;
    }

    public void setBonusNum() {
        InputView.insertBonusNumber();
        String tmp;
        while (true) {
            tmp = Console.readLine();
            try {
                validateBonusNum(tmp);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.bonusNum = Integer.parseInt(tmp);
    }

    public Lotto getCilentLotto() {
        InputView.insertLottoNumber();
        String[] clientInput;
        while (true) {
            clientInput = Console.readLine().split(",");
            try {
                return new Lotto(Arrays.stream(clientInput)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
            } catch (NumberFormatException e){
                ErrorMessageView.notInteger();
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNum(String tmp) {
        try{
            Integer.parseInt(tmp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.NOT_INTEGER);
        }
        if (Integer.parseInt(tmp) < 1 || Integer.parseInt(tmp) > 45) {
            throw new IllegalArgumentException(ErrorMessageConstant.BETWEEN_1_AND_45);
        }
        if (this.lotto.getNumbers().contains(Integer.parseInt(tmp))) {
            throw new IllegalArgumentException(ErrorMessageConstant.DUPLICATE);
        }
    }
}
