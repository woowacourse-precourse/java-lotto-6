package lotto;

import lotto.Constant.LottoConstant;
import lotto.Exception.InvalidInputException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_LENGTH)
        {
            throw new InvalidInputException("[ERROR] 당첨 번호의 길이가 6이 아닙니다.");
        }

        if (numbers.stream()
                .anyMatch(num -> num<LottoConstant.MINIMUM_NUMBER || num>LottoConstant.MAXIMUM_NUMBER))
        {
            throw new InvalidInputException("[ERROR] 당첨 번호는 1~45 사이어야 합니다.");
        }

        Set<Integer> winningLotteryNumberSet = new HashSet<>(numbers);
        if (winningLotteryNumberSet.size() != numbers.size())
        {
            throw new InvalidInputException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다");
        }
    }

    public int compare(Lotto lotto)
    {
        int cnt = 0;
        for(int number : numbers)
        {
            if(lotto.contains(number))
            {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean contains(int number)
    {
        return numbers.contains(number);
    }

    @Override
    public String toString()
    {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
