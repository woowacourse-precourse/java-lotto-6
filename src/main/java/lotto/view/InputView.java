package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private InputView(){}
    private static class InputViewHolder{
        private static final InputView inputView = new InputView();
    }
    public static InputView getInstance(){
        return InputViewHolder.inputView;
    }

    public int inputPayment(){
        String input = Console.readLine();
        validPayment(input);
        return Integer.parseInt(input);
    }

    private void validPayment(String input){
        try {
            int payment = Integer.parseInt(input);
            if(payment%1000!=0)
                throw new IllegalArgumentException();
        }catch (Exception e){
            throw new IllegalArgumentException("1000원 단위의 숫자로 입력해주세요");
        }
    }

    public List<Integer> inputNumbers(){
        String input = Console.readLine();
        validNumbers(input);
        return Arrays.stream(input.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private void validNumbers(String input){
        try {
            String[] stringNums = input.split(",");
            if(stringNums.length!=6)
                throw new IllegalArgumentException();
            for(String num : stringNums){
                validNumber(num);
            }
        }catch (Exception e){
            throw new IllegalArgumentException("1~45 사이의 숫자 6개를 ,으로 구분하여 입력해주세요");
        }
    }
    public int inputNumber(){
        String input = Console.readLine();
        validNumber(input);
        return Integer.parseInt(input);
    }

    private void validNumber(String input){
        try {
            int payment = Integer.parseInt(input);
            if(payment<1 || payment>45)
                throw new IllegalArgumentException();
        }catch (Exception e){
            throw new IllegalArgumentException("1~45 사이의 숫자로 입력해주세요");
        }
    }
}
