package lotto.dto;

import java.util.List;

public class WinningNumbersRequestDto {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }
    
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
