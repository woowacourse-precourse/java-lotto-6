package service;

import lotto.Lotto;

import java.util.List;

import static constants.Constant.*;

public class OutputService {

    public static void printGeneratedLotto(Integer lottoCount,
                                    List<Lotto> lottoList) {
        System.out.println(lottoCount+PURCAHSED_STRING);

        for(Lotto lotto : lottoList){
            System.out.println(
                    LEFT_BRACKET+lotto.convertToString()+RIGHT_BRACKET);
        }

    }
}
