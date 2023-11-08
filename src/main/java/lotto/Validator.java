package lotto;

public class Validator {
    public static void buyCheck(String inputText){
        try{
            int price = Integer.parseInt(inputText);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수만 입력해 주세요.");
        }

    }
}
