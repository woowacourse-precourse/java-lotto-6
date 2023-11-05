package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant.LottoConstant;
import lotto.Exception.InvalidInputException;
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
            if(cost % LottoConstant.TICKET_PRICE == 0)
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

    public int getCost() throws IllegalArgumentException
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

            if(winningLotteryNumber.size() != LottoConstant.LOTTO_NUMBER_LENGTH)
            {
                throw new InvalidInputException("[ERROR] 당첨 번호의 길이가 6이 아닙니다.");
            }

            if(winningLotteryNumber.stream()
                    .anyMatch(num -> num<LottoConstant.MINIMUM_NUMBER || num>LottoConstant.MAXIMUM_NUMBER))
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

    public List<Integer> getWinningLotteryNumber()
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

    private int getValidBonusWinningLotteryNumber(List<Integer> winningLotteryNumber) throws InvalidInputException
    {
        try
        {
            int bonusWinningNumber = Integer.parseInt(Console.readLine());

            if(bonusWinningNumber<LottoConstant.MINIMUM_NUMBER || bonusWinningNumber>LottoConstant.MAXIMUM_NUMBER)
                throw new InvalidInputException("[ERROR] 보너스 숫자의 값이 범위를 넘어갔습니다.");

            if(winningLotteryNumber.contains(bonusWinningNumber))
                throw new InvalidInputException("[ERROR] 보너스 숫자의 값이 기존 당첨 번호와 중복됩니다.");

            return bonusWinningNumber;
        }
        catch(NumberFormatException e)
        {
            throw new InvalidInputException("[ERROR] 보너스 숫자의 입력된 값이 숫자가 아닙니다.");
        }
    }

    public int getBonusWinningLotteryNumber(List<Integer> winningLotteryNumber)
    {
        while(true)
        {
            try
            {
                return getValidBonusWinningLotteryNumber(winningLotteryNumber);
            }
            catch (InvalidInputException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
