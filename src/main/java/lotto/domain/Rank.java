package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rank {
    static public List<Integer> rank(List<List<Integer>> win) {
        List<Integer> ranklist = Arrays.asList(0, 0, 0, 0, 0, 0);
        int winprice = 0;
        for (int i = 0; i < win.size(); i++) {
            if (win.get(i).get(0) == 6) {ranklist.set(0, ranklist.get(0) + 1);winprice += 2000000000;}
            if (win.get(i).get(0) == 5 && win.get(i).get(1) == 1)
            {ranklist.set(1, ranklist.get(1) + 1);winprice += 30000000;}
            if (win.get(i).get(0) == 5) {ranklist.set(2, ranklist.get(2) + 1);winprice += 1500000;}
            if (win.get(i).get(0) == 4) {ranklist.set(3, ranklist.get(3) + 1);winprice += 50000;}
            if (win.get(i).get(0) == 3) {ranklist.set(4, ranklist.get(4) + 1);winprice += 5000;}
        }
        ranklist.set(5, winprice);
        return ranklist;
    }
}