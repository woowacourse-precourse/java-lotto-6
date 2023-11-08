package view;

import lotto.Lotto;
import lotto.LottoNumbers;


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
        System.out.println("3개 일치 (5,000원) - " + arr[0] + OUTPUT_COUNT);
        System.out.println("4개 일치 (50,000원) - " + arr[1] + OUTPUT_COUNT);
        System.out.println("5개 일치 (1,500,000원) - " + arr[2] + OUTPUT_COUNT);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + arr[3] + OUTPUT_COUNT);
        System.out.println("6개 일치 (2,000,000,000원) - " + arr[4] + OUTPUT_COUNT);
    }

    private static void rateOfReturn(int[] arr, int input) {
        float sum = (float) ((arr[0] * 5000) + (arr[1] * 50000) + (arr[2] * 1500000) + (arr[3] * 30000000) + (arr[4] * 2000000000)) / input;

        String result = String.format("%,.1f", sum);
        System.out.println(OUTPUT_RATE_START + result + OUTPUT_RATE_END);
    }
}
