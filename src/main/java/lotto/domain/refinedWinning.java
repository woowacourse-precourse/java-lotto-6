package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class refinedWinning {
    private static List<String> check_winning = new ArrayList<>();
    public static void Input_Winning(String winning){
        String[] divide_winning = winning.split(",");
        check_winning = new ArrayList<String>(Arrays.asList(divide_winning));
        Is_it_Number();
    }

    public static void Is_it_Number(){
        String pattern = "^[0-9]*$";
        //boolean flag = true;
        for(int i=0; i< check_winning.size(); i++){
            if(check_winning.get(i).matches(pattern)==false){
                //flag = false;
                throw new IllegalArgumentException();
            }
        }
        //return flag;
    }

    public static List<Integer> change_winning(){
        List<Integer> changewinning = check_winning.stream().map(s->Integer.parseInt(s)).collect(Collectors.toList());
        return changewinning;
    }
}