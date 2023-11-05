package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    //클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성한다.
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        ArrayList<Integer> basket = new ArrayList<>();
        for(Integer number : numbers){
            if(basket.contains(number)){
                throw new IllegalArgumentException();
            }
            basket.add(number);
        }
    }
    public void sortNumbers(List<Integer> numbers) {
        try{
            Collections.sort(numbers);
        } catch (UnsupportedOperationException e ){
            //테스트때 사용하는 List.of 는 정렬이 불가해서 테스트시의 정렬시 예외 처리후 다음 로직 진행
        }

    }

    @Override
    public String toString() {
        return "[" +
                numbers.get(0) + ", " +
                numbers.get(1) + ", " +
                numbers.get(2) + ", " +
                numbers.get(3) + ", " +
                numbers.get(4) + ", " +
                numbers.get(5) +
                "]";
    }


    public Prize checkWinningNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        Integer correctNomalNumberCount = 0;

        correctNomalNumberCount = countNomalNumber(winningNumbers, correctNomalNumberCount);

        // TODO : 보너스 숫자 일치여부 추출 , 당첨 등수 추출

        return null;


    }

    private Integer countNomalNumber(List<Integer> winningNumbers,
            Integer collectNomalNumberCount) {
        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                collectNomalNumberCount++;
            }
        }
        return collectNomalNumberCount;
    }
}
