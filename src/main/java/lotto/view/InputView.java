package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.validator.InputViewValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final InputViewValidator inputViewValidator;

    public InputView(InputViewValidator inputViewValidator){
        this.inputViewValidator = inputViewValidator;
    }
    //구입금액입력
    public Long inputTotalAmount(){
        String string = Console.readLine();
        //validation
        Long totalAmount = Long.parseLong(string);
        return totalAmount;
    }
    //당첨번호
    public List<Integer> winnerNumbers(){
        String string = Console.readLine();
        //validation
        List<Integer> winnerNumberList = Arrays.stream(string.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winnerNumberList;
    }
    //보너스번호
    public Integer inputBonusNumber(){
        String string = Console.readLine();
        //validation
        Integer bonusNumber = Integer.parseInt(string);
        return bonusNumber;
    }
}
