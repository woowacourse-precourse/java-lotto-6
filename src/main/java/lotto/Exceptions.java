package lotto;

import java.util.List;

public class Exceptions {

    public static boolean checkString(String input){
        try{
            Integer.parseInt(input);
        } catch(IllegalArgumentException e){
            System.out.println("[ERROR] 숫자만 입력하세요.");
            return true;
        }
        return false;
    }

    public static void checkSize(List<Integer> list){
        if(list.size() > 6){
            throw new IllegalArgumentException();
        }
    }

    public static void checkDuplicate(List<Integer> list, Integer eachNumber){
//        try{
//            if(list.contains(eachNumber)){
//                throw new IllegalArgumentException();
//            }
//
//        }catch(IllegalArgumentException e){
//            System.out.println("[ERROR] 중복된 숫자가 있습니다.");
//            return true;
//        }
//        return false;
        if(list.contains(eachNumber)){
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkDiv(Integer money){
        try {
            if (money % 1000 > 1 && money % 1000 <= 999) {
                throw new IllegalArgumentException("[ERROR]1000의 단위로 입력하세요.");
            }
        } catch (IllegalArgumentException e){
            return true;
        }
        return false;
    }
}
