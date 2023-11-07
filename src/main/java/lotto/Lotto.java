package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    // 생성자 1: 매개변수가 있는 생성자
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 생성자 2: 기본 생성자
    public Lotto() {
        System.out.println("");
        System.out.println("당첨 번호를 입력해 주세요.");

        String inputLottoNum = Console.readLine();
       String[] inputLottoNumberArray = inputLottoNum.split(",");

        List<Integer> numbers = new ArrayList<>();
       for(String lottoNumber : inputLottoNumberArray){
           int number = Integer.parseInt(lottoNumber);
           numbers.add(number);
       }
        validate(numbers);
        this.numbers = numbers;
    }

    // 보너스 번호를 입력받아 당첨 번호 리스트에 추가
    public List<Integer> bonusNumber() {
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        validateBonus(bonus);
        numbers.add(bonus);

        return numbers;
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
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}
