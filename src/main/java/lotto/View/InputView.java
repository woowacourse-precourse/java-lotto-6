package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constant.LottoConstant;
import lotto.Exception.InvalidInputException;
import lotto.Lotto;

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
            if(cost < 0)
            {
                throw new InvalidInputException("[ERROR] 금액은 양수여야합니다.");
            }
            if (cost % LottoConstant.TICKET_PRICE == 0)
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
        while (true)
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

    private Lotto getValidWinningLotteryNumber()
    {
        try
        {
            List<Integer> winningLotteryNumber = Arrays.stream(Console.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

            return new Lotto(winningLotteryNumber);
        }
        catch (NumberFormatException e)
        {
            throw new InvalidInputException("[ERROR] 입력된 당첨 번호에 숫자가 아닌 것이 있습니다.");
        }
    }

    public Lotto getWinningLotteryNumber()
    {
        while (true)
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

    private int getValidBonusWinningLotteryNumber(Lotto winningLotteryNumber) throws InvalidInputException
    {
        try
        {
            int bonusWinningNumber = Integer.parseInt(Console.readLine());

            if (bonusWinningNumber<LottoConstant.MINIMUM_NUMBER || bonusWinningNumber>LottoConstant.MAXIMUM_NUMBER)
                throw new InvalidInputException("[ERROR] 보너스 숫자의 값이 범위를 넘어갔습니다.");

            if (winningLotteryNumber.contains(bonusWinningNumber))
                throw new InvalidInputException("[ERROR] 보너스 숫자의 값이 기존 당첨 번호와 중복됩니다.");

            return bonusWinningNumber;
        }
        catch (NumberFormatException e)
        {
            throw new InvalidInputException("[ERROR] 보너스 숫자의 입력된 값이 숫자가 아닙니다.");
        }
    }

    public int getBonusWinningLotteryNumber(Lotto winningLotteryNumber)
    {
        while (true)
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
