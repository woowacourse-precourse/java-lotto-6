package controller;

import camp.nextstep.edu.missionutils.Console;
import validation.ValidationMan;

class InputMan {
    private ValidationMan validationMan = new ValidationMan();
    private final static int EXCEPTION_NUMBER = -1;
    int receiveMoney() {
        String money = Console.readLine();
        if(!validationMan.validateMoney(money))
        {
            return EXCEPTION_NUMBER;
        }
        return Integer.parseInt(money);
    }

    Integer[] receiveNumbers()
    {
        String[] cutNumbers = cutNumbers(Console.readLine());
        if(!validationMan.validateNumbers(cutNumbers))
        {
            return new Integer[]{EXCEPTION_NUMBER};
        }
        return arrayParseInt(cutNumbers);
    }

    private String[] cutNumbers(String userNumbers)
    {
        String[] cutNNumbers = userNumbers.split(",");
        for(int i = 0; i < cutNNumbers.length; i++)
        {
            cutNNumbers[i] = cutNNumbers[i].trim();
        }
        return cutNNumbers;
    }

    private Integer[] arrayParseInt(String[] cutNumbers)
    {
        Integer[] userNumbers = new Integer[cutNumbers.length];
        for(int i = 0; i < userNumbers.length; i++)
        {
            userNumbers[i] = Integer.parseInt(cutNumbers[i]);
        }
        return userNumbers;
    }

    int receiveBonusNumber()
    {
        String userBonusNumber = Console.readLine();
        if(!validationMan.valudateBonusNumber(userBonusNumber))
        {
            return EXCEPTION_NUMBER;
        }
        return Integer.parseInt(userBonusNumber);
    }

}
