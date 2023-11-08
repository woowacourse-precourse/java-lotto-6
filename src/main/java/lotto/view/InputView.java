package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.WinningLotto;

public class InputView {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money;
        try {
            String input = Console.readLine();
            validateNumber(input);
            money = Integer.parseInt(input);
            validateInputMoneyUnit(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            money = getMoney();
        }
        return money;
    }

    public Lotto getInputAnswerLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lotto;
        try {
            String[] inputAnswer = Console.readLine().split(",");
            List<Integer> numbers = getValidatedNumbers(inputAnswer);
            lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lotto = getInputAnswerLotto();
        }
        return lotto;
    }

    public List<Integer> getValidatedNumbers(String[] inputAnswer){
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputAnswer) {
            validateNumber(input);
            numbers.add(Integer.parseInt(input));
        }
        return numbers;
    }

    public WinningLotto getWinningLotto(){
        Lotto inputAnswerLotto = getInputAnswerLotto();
        return getBonusNumber(inputAnswerLotto);
    }

    public WinningLotto getBonusNumber(Lotto lotto){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        WinningLotto winningLotto;
        try{
            validateNumber(input);
            winningLotto = new WinningLotto(lotto,Integer.parseInt(input));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            winningLotto = getBonusNumber(lotto);
        }
        return winningLotto;
    }

    public void validateInputMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        }
    }

    public void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력형식은 숫자이여야 합니다.");
        }
    }
}
