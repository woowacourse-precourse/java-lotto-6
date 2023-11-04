package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    //ToDO: 입력 검증

    public int getLottoPurchaseAmount(){
        String input = Console.readLine();
        int lottoPurchaseAmount = Integer.parseInt(input);

        return lottoPurchaseAmount;
    }

    public List<Integer> getLottoWinningNumbers(){
        String[] inputs = Console.readLine().split(",");
        List<Integer> lottoWinningNumbers = new ArrayList<>();

        for(String input : inputs) {
            lottoWinningNumbers.add(Integer.parseInt(input));
        }
        return lottoWinningNumbers;
    }

    public int getBonusNumber(){
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input);
        return bonusNumber;
    }


}
