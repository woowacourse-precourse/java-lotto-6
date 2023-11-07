package dto;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoConfig;

public class CommonNumberDTO {
    private List<Integer> numbers;

    public CommonNumberDTO(List<Integer> numbers) {
        verify(numbers);
        this.numbers = numbers;
    }

    private void verify(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LottoConfig.START_NUM || number > LottoConfig.END_NUM) {
                throw new IllegalArgumentException("[ERROR] 로또 번호로 적합하지 않은 숫자입니다.");
            }
        });

        List<Integer> uniqueNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 가질 수 없습니다.");
            }
            uniqueNumbers.add(number);
        });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
