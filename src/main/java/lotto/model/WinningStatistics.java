package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningStatistics {
    private List<List<Integer>> lottoNumbers;
    private List<Integer> winningNumber;
    private int bonusNumber;
    int[] value = new int[]{0,0,0,0,0};

    public WinningStatistics(List<List<Integer>> lottoNumbers, String winningNumber, String bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumber = change(winningNumber);
        this.bonusNumber =  Integer.parseInt(bonusNumber);
    }

    public int[] calculate() {
        int[] test = new int[5];
        for(List<Integer> lottoNumber : lottoNumbers) {
            test = winningCheck(lottoNumber, winningNumber, bonusNumber);
        }
        return test;
    }

    public int[] winningCheck(List<Integer> lottoNumber, List<Integer> winningNumber, int bonusNumber) {
        int count = 0;
        boolean bonus = false;
        for (int number : lottoNumber) {
            if(winningNumber.contains(number)) {
                count++;
            }
            if(number == bonusNumber) {
                bonus = true;
            }
        }
        return staticsResult(count, bonus);
    }

    public int[] staticsResult(int count, boolean bonus) {
        if (count == 3) {
            value[0]++;
        } else if (count == 4) {
            value[1]++;
        } else if (count == 5 && !bonus) {
            value[2]++;
        } else if (count == 5 && bonus) {
            value[3]++;
        } else if (count == 6) {
            value[4]++;
        }
        return value;
    }

    public List<Integer> change(String winningNumber) {
        String[] winning = winningNumber.split(",");
        List<Integer> changeWinningNumber = new ArrayList<>();
        for(String a : winning) {
            changeWinningNumber.add(Integer.parseInt(a));
        }
        return changeWinningNumber;
    }
}
