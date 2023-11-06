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
        String userInput;
        while (true) {
            userInput = Console.readLine();
            try {
                validateBonusNum(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.bonusNum = Integer.parseInt(userInput);
    }

    public Lotto getCilentLotto() {
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

    private void validateBonusNum(String userInput) {
        try{
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageConstant.NOT_INTEGER);
        }
        if (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 45) {
            throw new IllegalArgumentException(ErrorMessageConstant.BETWEEN_1_AND_45);
        }
        if (this.lotto.getNumbers().contains(Integer.parseInt(userInput))) {
            throw new IllegalArgumentException(ErrorMessageConstant.DUPLICATE);
        }
    }
}
