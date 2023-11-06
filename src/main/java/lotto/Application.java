package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int[] lottoNum(int num) {

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] lottoNumsStr = readLine().split(",");

        //int형 배열 생성
        int[] lottoNums = new int[lottoNumsStr.length];
        for (int i = 0; i < lottoNumsStr.length; i++) {
            lottoNums[i] = Integer.parseInt(lottoNumsStr[i]);
        }

        if (lottoNums.length != 6) {
            throw new IllegalArgumentException("[Error] 6개의 숫자를 입력하세요.");
        }
        return lottoNums;
    }

    public static int bonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusStr = readLine();
        int bonus = Integer.parseInt(bonusStr);

        return bonus;
    }

    public static int inputMoney() {
        // 1. lotto input
        System.out.println("구입금액을 입력해 주세요.");

        int lottoInput = Integer.parseInt(readLine());
        if(lottoInput % 1000 != 0) {
            new IllegalArgumentException("[Error] 1,000원 단위로 입력하세요.");
        }
        int num = lottoInput / 1000;
        System.out.println(num + "개를 구매했습니다.");
        return num;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int num = inputMoney();
        lottoNum(num);
        bonusNum();








    }
}
