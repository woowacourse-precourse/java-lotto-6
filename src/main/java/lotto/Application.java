package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static final int NUM_OF_LOTTO_NUMBERS = 6;

    public static int strToNum(String inp) {
        int num;

        try {
            num = Integer.parseInt(inp);
        }
        catch (NumberFormatException exp){
            throw new IllegalArgumentException();
        }

        return num;
    }

    public static int isBuyingValid(String inp) {
        int paying = strToNum(inp);

        if ((paying % 1000) != 0) {
            throw new IllegalArgumentException();
        }

        return paying % 1000;
    }

    public static int buying() {
        String inp;
        int lottoCount;

        System.out.println("구입금액을 입력해 주세요.");

        inp = camp.nextstep.edu.missionutils.Console.readLine();
        lottoCount = isBuyingValid(inp);
        
        System.out.printf("\n%d개를 구매했습니다.\n", lottoCount);
    
        return lottoCount;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoCount;
        
        lottoCount = buying();

    }
}
