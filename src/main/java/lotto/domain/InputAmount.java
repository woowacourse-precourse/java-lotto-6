package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.BitSet;
import lotto.Application;
import lotto.view.ErrorView;
import lotto.view.PrintView;

public class InputAmount {
    private static final int Lotto_Cost = 1000;
    private int Lottos;

    public  InputAmount(String Input_cash) {
        int refined_Input_cash = handlingNumber(Input_cash);
        //handlingPrice(refined_Input_cash);
        this.Lottos = refined_Input_cash;
    }

    public int Used_Lotto() {
        return Lottos / Lotto_Cost;
    }

    public static int handlingNumber(String Input_cash) throws IllegalArgumentException {
        while (true) {
            try {
                return Integer.parseInt(Input_cash);
            } catch (NumberFormatException e) {
                ErrorView.Not_Number_Error();
                Input_cash = PrintView.Input_Lotto_Buy();
            }
        }
    }
/*
    private void handlingPrice(int refinedInputCash) {
        Bigger_zero(refinedInputCash);
        //Multiple_1000(Input_first_cash);
    }

    private void Bigger_zero(int refined_Input_cash){
        while (refined_Input_cash < 1) {
            throw new IllegalArgumentException(ErrorView.Bigger_Zero_Error);
            String inputCash = PrintView.Input_Lotto_Buy();
            refined_Input_cash = handlingNumber(inputCash);
        }
    }
    */
}
