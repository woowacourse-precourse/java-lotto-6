package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PickRandomNumbers {

    public PickRandomNumbers() {

    }

    private static List<Integer> lotto_number_list;

    private static final int min_lotto_number = 1;
    private static final int max_lotto_number = 45;
    private static final int pick_lotto_numbers = 6;

    public static List<Integer> pick_ticket() {
        lotto_number_list = Randoms.pickUniqueNumbersInRange(min_lotto_number,max_lotto_number,pick_lotto_numbers);
        List<Integer> ticket_numbers_List = new ArrayList<>(lotto_number_list);
        Collections.sort(ticket_numbers_List);
        return ticket_numbers_List;
    }

}
