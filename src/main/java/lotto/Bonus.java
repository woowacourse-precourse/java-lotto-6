package lotto;

import java.util.ArrayList;
import java.util.List;

public class Bonus {

    public final int minInRange = 1;
    public final int maxInRange = 45;
    public final int LottoNumberSize = 6;
    public final int bonusNumberSize = 1;
    private List<Integer> bonusNumber;

    public Bonus() {
        this.bonusNumber = new ArrayList<>();
    }

    public void inputBonusNumber(List<Integer> bonusNumber) {
        System.out.println("\n보너스 번호를 입력해주세요.");
        validateOfBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getBonusNumber() {
        return bonusNumber;
    }

    private void validateOfBonusNumber(List<Integer> bonusNumber) {
        Errors errors = new Errors();

        while (true) {
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
    }
}