package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static int input ;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        buyLotto();
        Lotto[] lottos = outputLottoNumber();
        String[] winning = winningNumber();
        int bonus = bonusNumber();
        compare(lottos, winning, bonus);
    }

    private static void buyLotto() {
        String str = "";

        try {
            System.out.println("구입금액을 입력해 주세요.");
            str = Console.readLine();
            exceptionMessage(str);
            input = Integer.parseInt(str);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyLotto();
        }
    }

    private static void exceptionMessage(String str) {
        if (!isDigit(str)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        } else if (!inputValidate(str)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요.");
        }
    }

    private static boolean isDigit(String str) {
        boolean isNumeric = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
                break;
            }
        }

        return isNumeric;
    }

    private static List<Integer> lottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    private static boolean inputValidate(String input) {
        return Integer.parseInt(input) % 1000 == 0;
    }

    private static Lotto[] outputLottoNumber() {
        int number = input / 1000;
        int i = 0;
        Lotto[] lottos = new Lotto[number];
        try {
            while (i < number) {
                lottos[i] = new Lotto(lottoNumber());
                i++;
            }

            System.out.println(number + "개를 구매했습니다.");
            for (Lotto lotto : lottos) {
                String str = lotto.length(lotto);
                System.out.println(str);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return lottos;
    }

    private static String[] winningNumber() {
        String str = "";
        String[] number;

        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            str = Console.readLine();
            if (!checkExpression(str)) throw new IllegalArgumentException("쉼표(,) 기준으로 구분합니다. 쉼표(,)를 넣어주세요.");

            number = str.split(",");

            if (!duplicateNumber(number)) {
                throw new IllegalArgumentException("이미 숫자가 존재합니다.");
            } else if (!checkLength(number)) {
                throw new IllegalArgumentException("6개 입력해주세요.");
            }
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumber();
        }

        return str.split(",");
    }

    private static boolean checkExpression(String str) {
        return str.contains(",");
    }

    private static boolean duplicateNumber(String[] str) {
        boolean flag = true;
        List<String> list = new ArrayList<>();

        for (String s : str) {
            if (list.contains(s)) {
                flag = false;
            } else {
                list.add(s);
            }
        }

        return flag;
    }

    private static boolean checkLength(String[] str) {
        return str.length == 6;
    }

    private static int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String str = Console.readLine();
        System.out.println();
        return Integer.parseInt(str);
    }

    private static void compare(Lotto[] lottos, String[] winning, int bonus) {
        try {
            int cnt = 0;
            int[] arr = new int[winning.length];
            for (int i = 0; i < winning.length; i++) {
                arr[i] = Integer.parseInt(winning[i]);
            }

            for (Lotto lotto : lottos) {
                List<Integer> list = lotto.size();

                for (Integer integer : list) {
                    for (int k : arr) {
                        if (integer == k) {
                            cnt++;
                        }
                    }
                }
                if (cnt >= 3) {
                    output(list, cnt, bonus);
                }
                cnt = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static void output(List<Integer> list, int cnt, int bonus) {
        int[] arr = new int[5];
        int correctLottoNumbers = 0;
        for (Integer integer : list) {
            if (integer == bonus) {
                correctLottoNumbers++;
            }
        }

        switch (cnt) {
            case 3 -> arr[0] = 1;
            case 4 -> arr[1] = 1;
            case 5 -> {
                if (correctLottoNumbers >= 1) {
                    arr[3] = 1;
                } else if (correctLottoNumbers == 0) {
                    arr[2] = 1;
                }
            }
            case 6 -> arr[4] = 1;
        }

        print(arr);
        rateOfReturn(arr, input);
    }

    private static void print(int[] arr) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + arr[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + arr[1]+ "개");
        System.out.println("5개 일치 (1,500,000원) - " + arr[2]+ "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + arr[3]+ "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + arr[4]+ "개");
    }

    private static void rateOfReturn(int[] arr, int input) {
        float sum = (float) ((arr[0] * 5000) + (arr[1] * 50000) + (arr[2] * 1500000) + (arr[3] * 30000000) + (arr[4] * 2000000000)) / input;

        String result = String.format("%,.1f", sum);
        System.out.println("총 수익률은 " + result + "% 입니다.");
    }

}
