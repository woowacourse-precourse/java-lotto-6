package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Integer> toList(String lottoString){
        List<Integer> list = new ArrayList<>();
        String[] lottoNums = lottoString.split(",");
        for(int i=0;i<lottoNums.length;i++){
            list.add(Integer.parseInt(lottoNums[i]));
        }
        return list;
    }
}
