package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoException.InvalidInputException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView
{
    private int getValidCost()
    {
        try
        {
            int cost = Integer.parseInt(Console.readLine());
            if(cost % 1000 == 0)
            {
                return cost;
            }

            throw new InvalidInputException("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.");
        }
        catch (NumberFormatException e)
        {
            throw new InvalidInputException("[ERROR] 입력 횟수가 숫자가 아닙니다.");
        }
    }

    private int getCost() throws IllegalArgumentException
    {
        while(true)
        {
            try
            {
                return getValidCost();
            }
            catch (InvalidInputException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidWinningLotteryNumber()
    {
        try
        {
            List<Integer> winningLotteryNumber = Arrays.stream(Console.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            if(winningLotteryNumber.size() != 6)
            {
                throw new InvalidInputException("[ERROR] 당첨 번호의 길이가 6이 아닙니다.");
            }

            if(winningLotteryNumber.stream().anyMatch(num -> num<1 || num>45))
            {
                throw new InvalidInputException("[ERROR] 당첨 번호는 1~45 사이어야 합니다.");
            }

            Set<Integer> winningLotteryNumberSet = new HashSet<>(winningLotteryNumber);
            if(winningLotteryNumberSet.size() != winningLotteryNumber.size())
            {
                throw new InvalidInputException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다");
            }

            return winningLotteryNumber;
        }
        catch (NumberFormatException e)
        {
            throw new InvalidInputException("[ERROR] 입력된 당첨 번호에 숫자가 아닌 것이 있습니다.");
        }
    }

    private List<Integer> getWinningLotteryNumber()
    {
        while(true)
        {
            try
            {
                return getValidWinningLotteryNumber();
            }
            catch (InvalidInputException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
