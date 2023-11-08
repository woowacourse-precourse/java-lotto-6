package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;

    // 생성자 1: 매개변수가 있는 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 생성자 2: 기본 생성자
    public Lotto() {
        numbers = new ArrayList<>();
    }

    // 당첨번호를 입력받아 리스트에 저장 | numbers 리스트 반환
    public void inputCorrectNumber() {
        String inputLottoNum = Console.readLine();
        String[] inputLottoNumberArray = inputLottoNum.split(",");

        for(String lottoNumber : inputLottoNumberArray){
            int number = Integer.parseInt(lottoNumber);
            numbers.add(number);
        }
        validate(numbers);
    }

    // 보너스 번호를 입력받아 저장 | int형 bonus 반환
    public void inputBonusNumber() {
        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 로또 번호는 숫자만 입력 해야합니다.");
            bonusNumber = Integer.parseInt(Console.readLine());
        }
        validateBonus(bonusNumber);
    }

    // numbers 리스트에 bonus 추가한 새로운 리스트 반환
    public  List<Integer> addCorrectWithBonusNumber() {
        List<Integer> correctLottoNumber = new ArrayList<>(numbers);
        correctLottoNumber.add(bonusNumber);
        return correctLottoNumber;
    }


    // 보너스 번호 입력 유효값 검사
    private void validateBonus(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException();
        }
    }
    // 당첨 로또 입력 유효값 검사
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        // 중복 검사
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size()<numbers.size())
            throw new IllegalArgumentException();
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
