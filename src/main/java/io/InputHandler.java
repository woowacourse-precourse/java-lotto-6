package io;

import camp.nextstep.edu.missionutils.Console;
import verifier.BonusNumberVerifier;
import verifier.MoneyVerifier;
import verifier.Verifier;
import verifier.WinnerNumberVerifier;

public final class InputHandler {

    private static final Verifier moneyVerier = new MoneyVerifier();
    private static final Verifier bonusVerifier = new BonusNumberVerifier();
    private static final Verifier winnerNumberVerifier = new WinnerNumberVerifier();

    private InputHandler(){

    }

    public static int readMoney(){
        System.out.println("구입금액을 입력해 주세요");
        String input = Console.readLine();
        moneyVerier.check(input);
        return Integer.parseInt(input);
    }

}
