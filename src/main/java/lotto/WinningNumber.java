package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WinningNumber {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_MIN = 1;


    PrintError printError = new PrintError();
    private final String[] userInput;
    private final HashSet<Integer> numbers = new HashSet<>();

    public WinningNumber(String userInput){
        this.userInput = ",".split(userInput);
        inputValidate(this.userInput); //입력한 값에 대한 유효성 체크
        makeNumbers(this.userInput); // 입력한 값 HashSet으로 변환
        numbersValidate(numbers); // HashSet에 대한 유효성 체크
    }

    private void numbersValidate(HashSet<Integer> numbers) {
        sizeValidate(numbers); // 로또의 길이가 6인가
        duplicateValidate(numbers); //로또의 중복이 있는가
    }

    private void inputValidate(String[] userInput) {
        decimalValidate(userInput); //입력한 값이 정수인가
        rangeValidation(userInput); //입력한 값의 범위가 유요한가
    }

    private void rangeValidation(String[] userInput) {
        for(int i = 0; i < userInput.length; i++){
            int tempNum = Integer.parseInt(userInput[i]);
            checkRange(tempNum);
        }
    }

    private void checkRange(int tempNum) {
        if((tempNum>LOTTO_MAX) && (tempNum <LOTTO_MIN)){
            throw new IllegalArgumentException(printError.rangeError());
        }
    }

    private void decimalValidate(String[] userInput) {
        for(int i = 0; i < userInput.length; i++){
            decimalCheck(userInput[i]);
        }
    }

    private void decimalCheck(String temp) {
        if (!temp.matches("\\d+")){
            throw new IllegalArgumentException(printError.decimalException());
        }
    }

    public void makeNumbers(String[] userInput){
        for(int i = 0; i < userInput.length; i++){
            numbers.add(Integer.parseInt(userInput[i]));
        }
    }

    private void duplicateValidate(HashSet<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE ) throw new IllegalArgumentException(printError.duplicateError());

    }

    private void sizeValidate (HashSet<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException(printError.countERROR());
    }

    public HashSet<Integer> getWinningNumber(){
        return numbers;
    }

}
