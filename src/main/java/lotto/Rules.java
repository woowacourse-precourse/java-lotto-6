package lotto;


import java.util.ArrayList;

public class Rules {//예외처리
    //공통 예외처리
    // 공통1 - 입력값이 없을 경우
    static String input_is_null="[ERROR] 입력된 값이 없습니다.";
    public static boolean inputIsNull(String str){
        try{
            if(str.isBlank()){//입력값이 없을 경우
                throw new IllegalArgumentException(input_is_null);
            }

        }catch(IllegalArgumentException e){
            return true;
        }
        return false;
    }

    // 공통2 - 숫자가 아닌 문자가 포함되었을 경우
    static String not_number="[ERROR] 숫자가 아닌 문자가 포함되어 있습니다.";
    public static boolean notNumber(String str){
        try{
            if(!isNumeric(str))
                throw new IllegalArgumentException(not_number);
        }catch (IllegalArgumentException e){
            return true;
        }
        return false;
    }

    //정규식을 이용해 정수로만 이루어져있는지 판별
    static boolean isNumeric(String str){
        return str.matches("\\d+");
    }


    // 금액 예외처리
    // 금액1 - 금액 / 1000 의 나머지가 0이 아닐 경우
    static String remainder_is_not_0="[ERROR] 나머지가 0이 아닙니다.";
    public static boolean remainderIsNot0(long price){
        try{
            if(price%1000!=0)
                throw new IllegalArgumentException(remainder_is_not_0);
        }catch(IllegalArgumentException e){
            return true;
        }
        return false;
    }

    // 금액2 - 금액이 음수일 경우
    static String number_is_negative_number="[ERROR] 입력된 수가 0원 이하입니다.";
    public static boolean numberIsNegativeNumber(long price){
        try{
            if(price<=0)
                throw new IllegalArgumentException(number_is_negative_number);
        }catch(IllegalArgumentException e){
            return true;
        }
        return false;
    }


    // 번호 공통 예외처리
    // 번호1 - 번호가 1이상 45이하가 아닐 경우
    static String number_is_not_between_1and45="[ERROR] 번호는 1과 45 사이의 수이어야 합니다.";
    public static boolean numberIsNotBetween1And45(int number){
        try{
            if(number<1||number>45)
                throw new IllegalArgumentException(number_is_not_between_1and45);
        }catch(IllegalArgumentException e){
             return true;
        }

        return false;
    }

    // 번호2 - 중복된 수가 존재할 경우
    static String number_is_already_exist="[ERROR] 이미 존재하는 번호입니다.";
    public static boolean numberIsAlreadyExist(ArrayList<Integer> arrayList,int number){
        try{
            if(arrayList==null){
                throw new IllegalArgumentException(input_is_null);
            }
            if(arrayList.contains(number))
                throw new IllegalArgumentException(number_is_already_exist);
        }catch(IllegalArgumentException e){
            return true;
        }
        return false;
    }


    // 6개 번호 예외처리
    // 번호의 갯수가 6개가 아닐 경우
    static String amount_is_not_6="[ERROR] 번호가 6개가 아닙니다.";
    public static boolean amountIsNot6(String str){
        String[] arr=str.split(",");

        try{
            if(arr.length!=6)
                throw new IllegalArgumentException(amount_is_not_6);
        }catch (IllegalArgumentException e){
            return true;
        }
        return false;
    }

}

/*
입력한 데이터 형식이 잘못된 경우 : DataFormat Exception

try{
조건..?
}
catch(Exception e){
continue의 여부
}


*/