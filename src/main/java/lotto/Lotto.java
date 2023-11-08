package lotto;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { //생성자
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
        }

        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자이어야 합니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void validateBonus(int bonus) { // 보너스 번호 확인
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자이어야 합니다.");
        }

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복되어서는 안됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static List<Lotto> buyLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>(); //로또 객체의 목록을 담기 위한 ArrayList 생성

        //구매한 로또 개수만큼 숫자 뽑아내기
        for (int i = 0; i < numberOfLotto; i++) {
            // 1~45 까지의 수 랜덤 뽑기
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            // ImmutableList 를 ArrayList 로 변환하여 수정이 가능한 리스트로 처리해야함
            // Radom.pickUniqueNumbersInRange 를 통해 생성된 ImmutableList 를 ArrayList 로 변환하여 정렬할 수 있도록 수정

            Lotto lotto = new Lotto(numbers);  // 뽑은 숫자를 가진 Lotto 클래스 객체 lotto 생성
            Collections.sort(numbers); // 로또 번호를 오름차순으로 정렬
            lottos.add(lotto); // lottoes 배열에 개별 lotto 들을 추가
        }
        return lottos;
    }

    public boolean hasDuplicateNumber(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    public static List<Integer> parseNumbers(String input) {
        String[] numbersStr = input.split(",");
        List<Integer> numbers = new ArrayList<>(); // 자료형은 정수형 ArrayList
        for (String number : numbersStr) {
            numbers.add(parseInt(number.trim()));
        }
        return numbers;
    }
}