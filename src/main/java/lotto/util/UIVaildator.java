package lotto.util;

public class UIVaildator {
    public void vaildateInput(String inputMoney) {
        vaildateEmpty(inputMoney);
        vaildateInt(inputMoney);
    }
    public void vaildateEmpty(String inputMoney) {
        if(inputMoney.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다. 다시 입력해주세요.");
        }
    }
    public void vaildateInt(String inputMoney) {
        if(!inputMoney.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자가 아닌 값이 포함되어 있습니다. 다시 입력해주세요.");
        }
    }
}