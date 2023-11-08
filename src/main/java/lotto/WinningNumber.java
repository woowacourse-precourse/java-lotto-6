package lotto;

import java.util.HashSet;
import java.util.Iterator;


public class WinningNumber {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_MIN = 1;

    private final String[] userInput;
    private final HashSet<Integer> numbers = new HashSet<>();

    public WinningNumber(String userInput){
        nullValidate(userInput);
        this.userInput = userInput.split(",");
        inputValidate(); //입력한 값에 대한 유효성 체크
        makeNumbers(); // 입력한 값 HashSet으로 변환
        numbersValidate(numbers); // HashSet에 대한 유효성 체크
    }

    private void numbersValidate(HashSet<Integer> numbers) {
        duplicateValidate(numbers); //로또의 중복이 있는가
        rangeValidation(numbers); //입력한 값의 범위가 유요한가

    }

    private void inputValidate() {
        decimalValidate(userInput); //입력한 값이 정수인가
        sizeValidate(userInput); // 로또의 길이가 6인가
    }

    private void nullValidate(String userInput) {
        if (userInput.isEmpty()){
            throw new IllegalArgumentException(PrintError.nullException());
        };
    }

    private void rangeValidation(HashSet<Integer> userInput) {
        Iterator<Integer> iterator =userInput.iterator();
        while(iterator.hasNext()){
            checkRange(iterator.next());
        }
    }

    private void checkRange(int tempNum) {
        if((tempNum>LOTTO_MAX) || (tempNum <LOTTO_MIN)){
            throw new IllegalArgumentException(PrintError.rangeError());
        }
    }

    private void decimalValidate(String[] userInput) {
        for(int i = 0; i < userInput.length; i++){
            decimalCheck(userInput[i]);
        }
    }

    private void decimalCheck(String temp) {
        if (!temp.matches("\\d+")){
            throw new IllegalArgumentException(PrintError.decimalException());
        }
    }

    public void makeNumbers(){
        for(int i = 0; i < userInput.length; i++){
            numbers.add(Integer.parseInt(userInput[i]));
        }
    }

    private void duplicateValidate(HashSet<Integer> numbers) {
        if(numbers.size() != LOTTO_SIZE ) {
            throw new IllegalArgumentException(PrintError.duplicateError());
        }

    }

    private void sizeValidate (String[] numbers) {
        if (numbers.length!= 6) {
            throw new IllegalArgumentException(PrintError.countERROR());
        }
    }

    public HashSet<Integer> getWinningNumber(){
        return numbers;
    }

}
