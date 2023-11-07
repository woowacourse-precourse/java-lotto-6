package lotto.service;

import java.util.List;

public class CheckLottoService {
    private static final int plusRanking = 1;
    private static final int maintainRanking = 0;

    private int checkNumberInLotto(List<Integer> list, int number) {
        if(list.contains(number)){
            return plusRanking;
        }
        return maintainRanking;
    }
}
