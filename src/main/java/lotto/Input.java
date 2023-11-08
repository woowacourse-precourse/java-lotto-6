package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {

    public int getInput(){

        String input="";
        do{
            input=Console.readLine();
        }while(!ErrorCheck.wonCheck(input));
        return Integer.parseInt(input);
    }

    public List<Integer> getWinningNumber(){

        List<Integer> ret = new ArrayList<>();
        do {
            ret.clear();
            String[] parts = Console.readLine().split(",");

            for (String part : parts) {
                ret.add(Integer.parseInt(part.trim()));
            }
        }while(!ErrorCheck.userLottoCheck(ret) || !ErrorCheck.isDuplicated(ret));
        return ret;
    }

    public int getBonusNumber(List<Integer> list){
        int ret=0;
        do{
            String input=Console.readLine();
            ret=Integer.parseInt(input);
        }while(!ErrorCheck.bonusNumCheck(ret) || !ErrorCheck.isBonusNumDuplicated(list,ret));
        return ret;
    }
}
