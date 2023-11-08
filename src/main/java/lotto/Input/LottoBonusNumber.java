package lotto.Input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoBonusNumber {
    private final Integer bonus;


    public LottoBonusNumber() {
        this.bonus = bonusNumber();
    }

    public Integer getBonus() {
        return bonus;
    }
    public Integer inputPrice(){
        return Integer.parseInt(readLine());
    }

    public Integer bonusNumber() {
        Integer bonus;
        while (true) {
            try {
                bonus = inputPrice();
                new LottoBonusNumberException(bonus);
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }
}
