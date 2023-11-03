package lotto.exception;

public class InputException {

    public void checkThousandUnit(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해주세요.");
        }
    }
    public int toInt(String amount) {
        if(!amount.matches("^[0-9]*$")){
            throw new NumberFormatException("[ERROR] 숫자를 입력해주세요.");
        }
        return Integer.parseInt(amount);
    }
}
