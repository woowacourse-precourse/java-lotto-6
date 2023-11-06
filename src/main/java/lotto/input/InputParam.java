package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputParam {
    public int inputMoney(){
        int money = Integer.parseInt(readLine());
        return money;
    }

    public int[] inputLottoNumbers(){
        String[] split = readLine().split(",");
        int[] inputNumbers=new int[split.length];
        for (int i = 0; i < split.length; i++) {
            inputNumbers[i] = Integer.parseInt(split[i]);
        }
        return inputNumbers;
    }

    public int inputBonusNumber(){
        int n = Integer.parseInt(readLine());
        return n;
    }
}
