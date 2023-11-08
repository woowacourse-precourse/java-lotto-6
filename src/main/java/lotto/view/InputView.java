package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class InputView {
    public int moneyInput() {
        int money = 0;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(readLine().trim());
            isCorrectMoney(money);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 구입금액은 1,000원 단위로 입력해주세요.");
            moneyInput();
        }
        return money;
    }

    public int calculateLottoNum(int money) {
        return money / 1000;
    }

    public Lotto answerInput() {
        List<Integer> convertAnswer = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lotto = null;
        try {
            String[] answer = readLine().split(",");
            StringToInt(answer, convertAnswer);
            lotto = new Lotto(convertAnswer);
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 당첨번호는 6자리여야 하며 중복되지 않아야 합니다.");
            answerInput();
        }
        return lotto;
    }

    private void StringToInt(String[] strList, List<Integer> intList) {
        for (String s : strList) {
            intList.add(Integer.valueOf(s));
        }
    }

    private void isCorrectMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int bonusInput(List<Integer> answers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = 0;
        try {
            bonus = Integer.parseInt(readLine().trim());
            isOrigin(answers, bonus);
            inRange(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스번호는 당첨번호와 중복되지 않아야 하며 1~45 사이 숫자만 가능합니다.");
            bonusInput(answers);
        }
        return bonus;
    }

    private void isOrigin(List<Integer> answers, int bonus) {
        if (answers.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void inRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
    }

}
