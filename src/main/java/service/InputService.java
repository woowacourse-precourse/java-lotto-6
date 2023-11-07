package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static constants.Constant.*;

public class InputService {

    public Integer inputPurchasePrice(){
        System.out.println(PURCAHSE_PRICE_STRING);
        return Integer.parseInt(Console.readLine());
    }



}
