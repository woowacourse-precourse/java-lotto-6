package lotto.Controller;

public class ExceptionController {

    public void moneyException(String money_str){
        if(!money_str.matches("\\d+")){
            throw new IllegalArgumentException();
        }else{
            int money = Integer.parseInt(money_str);
            if(money % 1000 != 0){
                throw new IllegalStateException();
            }
        }
    }

    // 로또번호는 6개 이어야 하고 각 로또번호는 1 ~ 45범위의 번호이어야 한다.(IllegalStateException)
    // 로또번호는 숫자이어야 한다.(IllegalArgumentException)
    public void numbersException(String[] inputNumbers){
        if(inputNumbers.length != 6) {
            throw new IllegalStateException();
        }
        else {
            for (String s : inputNumbers) {
                if (!s.matches("\\d+")) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void bonusNumberException(String bonus_number){
        if(!bonus_number.matches("[0-9]{1,2}")){
            throw new IllegalArgumentException();
        }else{
            int number = Integer.parseInt(bonus_number);
            if(!(number > 0 && number <= 45)){
                throw new IllegalStateException();
            }
        }
    }
}
