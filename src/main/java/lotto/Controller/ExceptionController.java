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

}
