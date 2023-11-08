package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Input {
    public String purchasePrice() {
        String inputPrice = Console.readLine();
        return inputPrice;
    }
    public List<Integer> receiveWinningNumbers(){
        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumbers = Console.readLine();
        StringTokenizer st = new StringTokenizer(inputNumbers,",");
        while(st.hasMoreTokens()){
            String number = st.nextToken();
            Integer convertNumber = Integer.valueOf(number);
            winningNumbers.add(convertNumber);
        }
        return winningNumbers;
    }
    public int receiveBonusNumber(){
        String inputBonusNumber = Console.readLine();
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        return bonusNumber;
    }
}
