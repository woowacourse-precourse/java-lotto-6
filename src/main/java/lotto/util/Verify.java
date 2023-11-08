package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Verify {

    public Verify(){}
    public static Integer verifyAmount(String input) throws IllegalArgumentException{
        Integer value;
        try{
            value = Integer.parseInt(String.valueOf(input));
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해야합니다.");
            throw new IllegalArgumentException();
        }
        if(value % 1000 != 0){ // 1000원으로 나누어 떨어지지 않는 경우
            System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return value;
    }

    public static List<Integer> verifyWinningNumbersStringToList(String input) throws IllegalArgumentException{
        input = input.replace(" ","");
        String[] numbers = input.split(",");
        List<Integer> inputList = new ArrayList<>();
        for(int i=0; i<numbers.length; i++){
            Integer number;
            try{
                number = Integer.parseInt(String.valueOf(numbers[i]));
            }
            catch (NumberFormatException e){
                System.out.println("[ERROR] 숫자를 입력해야합니다.");
                throw new IllegalArgumentException();
            }
            if(number<0 || number>46){
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
            inputList.add(number);
        }
        return inputList;
    }

    public static Integer verifyBonusNumber(String input) throws IllegalArgumentException{
        input = input.replace(" ","");
        Integer number;
        try{
            number = Integer.parseInt(String.valueOf(input));
        }
        catch (NumberFormatException e){
            System.out.println("[ERROR] 숫자를 입력해야합니다.");
            throw new IllegalArgumentException();
        }
        if(number<0 || number>46){
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return number;
    }
}
