package lotto.util;

public class UIVaildator {
    public void vaildateInput(String inputValue1) {
        vaildateEmpty(inputValue1);
        vaildateInt(inputValue1);
    }
    public void vaildateInput(String inputValue1, String inputValue2) {
        vaildateEmpty(inputValue1, inputValue1);
        vaildateInt(inputValue1, inputValue1);
    }
    public void vaildateEmpty(String inputValue1) {
        if(inputValue1.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다. 다시 입력해주세요.");
        }
    }
    public void vaildateEmpty(String inputValue1, String inputValue2) {
        if(inputValue1.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 없습니다. 다시 입력해주세요.");
        }
    }
    public void vaildateInt(String inputValue1) {
        if(!inputValue1.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자가 아닌 값이 포함되어 있습니다. 다시 입력해주세요.");
        }
    }
    public void vaildateInt(String inputValue1, String inputValue2) {
        if(!inputValue1.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR] 입력 값에 숫자가 아닌 값이 포함되어 있습니다. 다시 입력해주세요.");
        }
    }
}