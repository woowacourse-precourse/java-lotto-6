package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView
{
    private int getCost() throws IllegalArgumentException
    {
        while(true)
        {
            try
            {
                int cost = Integer.parseInt(Console.readLine());
                if(cost % 1000 != 0)
                {
                    System.out.println("[Error] 금액은 1000으로 나누어 떨어져야 합니다.");
                    continue;
                }

                return cost;
            }
            catch (NumberFormatException e)
            {
                System.out.println("[ERROR] 입력 횟수가 숫자가 아닙니다.");
            }
        }
    }
}
