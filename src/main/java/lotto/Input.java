package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {

    public int getInput(){
        String input=Console.readLine();
        ErrorCheck.wonCheck(input);
        int ret=Integer.parseInt(input);
        return ret;
    }

    public List<Integer> getWinningNumber(){
        String input=Console.readLine();

        List<Integer> ret = new ArrayList<>();
        String[] parts = input.split(",");

        for (String part : parts) {
            ret.add(Integer.parseInt(part.trim()));
        }
        return ret;
    }

    public int getBonusNumber(){
        String input=Console.readLine();
        int ret=Integer.parseInt(input);
        return ret;
    }
}
