package view;

import domain.Coincide;
import domain.Lotto;
import domain.LottoNumbers;


import java.util.Collections;
import java.util.List;

public class outputView {
    private static final String OUTPUT_BUY = "개를 구매했습니다.";
    private static final String OUTPUT_RATE_START = "총 수익률은 ";
    private static final String OUTPUT_RATE_END = "% 입니다.";
    private static final String OUTPUT_COUNT = "개";
    private static final String OUTPUT_WINNING_STATISTICS = "당첨 통계";

    public outputView() {
    }

    public static Lotto[] outputLottoNumber(int input) {
        int number = input / 1000;
        Lotto[] lottos = new Lotto[number];

        try {
            for (int i = 0; i < number; i++) {
                lottos[i] = new Lotto(LottoNumbers.setLottoNumbers());
            }
            System.out.println(number + OUTPUT_BUY);

            for (Lotto lotto : lottos) {
                System.out.println(lotto.getLotto(lotto));
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lottos;
    }

    public static void compare(Lotto[] lottos, String[] winning, int bonus, int input) {
        try {
            int[] arr = makeArray(winning);
            getCnt(lottos, arr, bonus, input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[] makeArray(String[] winning) {
        int[] arr = new int[winning.length];

        for (int i = 0; i < winning.length; i++) {
            arr[i] = Integer.parseInt(winning[i]);
        }

        return arr;
    }

    private static void getCnt(Lotto[] lottos, int[] arr, int bonus, int input) {
        int cnt = 0;
        for (Lotto lotto : lottos) {
            List<Integer> list = lotto.size();

            for (int i : arr) {
                cnt += Collections.frequency(list, i);
            }

            if (cnt >= 3) {
                output(list, cnt, bonus, input);
            }
            cnt = 0;
        }
    }

    private static void output(List<Integer> list, int cnt, int bonus, int input) {
        int lottoNumbers = correctLottoNumbers(list, bonus);
        int[] arr = fillArray(lottoNumbers, cnt);

        print(arr);
        rateOfReturn(arr, input);
    }

    private static int correctLottoNumbers(List<Integer> list, int bonus) {
        int cnt = 0;

        for (Integer i : list) {
            if (i == bonus) {
                cnt++;
            }
        }

        return cnt;
    }

    private static int[] fillArray(int lottoNumbers, int cnt) {
        int[] arr = new int[5];

        switch (cnt) {
            case 3 -> arr[0] = 1;
            case 4 -> arr[1] = 1;
            case 5 -> {
                if (lottoNumbers == 0) arr[2] = 1;
                if (lottoNumbers >= 1) arr[3] = 1;
            }
            case 6 -> arr[4] = 1;
        }

        return arr;
    }

    private static void print(int[] arr) {
        System.out.println();
        System.out.println(OUTPUT_WINNING_STATISTICS);
        System.out.println("---");
        System.out.println(Coincide.FIVE.getMessage() + arr[0] + OUTPUT_COUNT);
        System.out.println(Coincide.FOUR.getMessage() + arr[1] + OUTPUT_COUNT);
        System.out.println(Coincide.THIRD.getMessage() + arr[2] + OUTPUT_COUNT);
        System.out.println(Coincide.SECOND.getMessage() + arr[3] + OUTPUT_COUNT);
        System.out.println(Coincide.FIRST.getMessage() + arr[4] + OUTPUT_COUNT);
    }

    private static void rateOfReturn(int[] arr, int input) {
        float sum = (float) ((arr[0] * Coincide.FIVE.getCountOfMoney()) + (arr[1] * Coincide.FOUR.getCountOfMoney()) + (arr[2] * Coincide.THIRD.getCountOfMoney()) + (arr[3] * Coincide.SECOND.getCountOfMoney()) + (arr[4] * Coincide.FIRST.getCountOfMoney())) / input;

        String result = String.format("%,.1f", sum);
        System.out.println(OUTPUT_RATE_START + result + OUTPUT_RATE_END);
    }
}
