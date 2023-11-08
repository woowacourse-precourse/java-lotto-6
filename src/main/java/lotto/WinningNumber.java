package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.PrintError;


public class WinningNumber {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_MIN = 1;

    private final String[] userInput;
    private final HashSet<Integer> numbers = new HashSet<>();

    public WinningNumber(String userInput){
        this.userInput = userInput.split(",");
        inputValidate(); //입력한 값에 대한 유효성 체크
        makeNumbers(); // 입력한 값 HashSet으로 변환
        numbersValidate(numbers); // HashSet에 대한 유효성 체크
    }

    private void numbersValidate(HashSet<Integer> numbers) {
        sizeValidate(numbers); // 로또의 길이가 6인가
        duplicateValidate(numbers); //로또의 중복이 있는가
    }

    private void inputValidate() {
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
            System.out.println(PrintError.rangeError());
            throw new IllegalArgumentException();
        }
    }

    private void decimalValidate(String[] userInput) {
        for(int i = 0; i < userInput.length; i++){
            decimalCheck(userInput[i]);
        }
    }

    private void decimalCheck(String temp) {
        if (!temp.matches("\\d+")){
            System.out.println(PrintError.decimalException());
            throw new IllegalArgumentException();
        }
    }

    public void makeNumbers(){
        for(int i = 0; i < userInput.length; i++){
            numbers.add(Integer.parseInt(userInput[i]));
        }
    }

    private void duplicateValidate(HashSet<Integer> numbers) {
        System.out.println(PrintError.duplicateError());
        if(numbers.size() != LOTTO_SIZE ) throw new IllegalArgumentException();

    }

    private void sizeValidate (HashSet<Integer> numbers) {
        System.out.println(PrintError.countERROR());
        if (numbers.size() != 6) throw new IllegalArgumentException();
    }

    public HashSet<Integer> getWinningNumber(){
        return numbers;
    }

}
