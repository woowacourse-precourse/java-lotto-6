package lotto;

import java.util.ArrayList;
import java.util.List;

public class Bonus {

    private final Lotto lotto;
    private final Money money;
    private List<Integer> bonusNumber;

    static final int minInRange = 1;
    static final int maxInRange = 45;
    static final int LottoNumberSize = 6;
    static final int bonusNumberSize = 1;

    public Bonus(Lotto lotto, Money money) {
        this.bonusNumber = new ArrayList<>();
        this.lotto = lotto;
        this.money = money;
    }

    public void inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해주세요.");
        validateOfBonusNumber();
    }

    public List<Integer> getBonusNumber() {
        return this.bonusNumber;
    }

    private List<Integer> validateOfBonusNumber() {
        Errors errors = new Errors();

        boolean validInputBonusNumber = false;
        while (!validInputBonusNumber) {
            try {
                errors.checkErrorsOfInputBonusNumber(bonusNumber);
            } catch (NumberFormatException e) {
                System.out.println("[Error] 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해주세요.");
                bonusNumber.clear();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
                bonusNumber.clear();
            }
        }
        bonusNumber = this.bonusNumber;
        return bonusNumber;
    }
}