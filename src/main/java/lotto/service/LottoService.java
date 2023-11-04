package lotto.service;

import camp.nextstep.edu.missionutils.Console;

public class LottoService {

    private static final Integer LOTTO_PRICE = 1000;

    public static void run() {
        System.out.println("구입금액을 입력해 주세요.");
        int tryNum;
        while (true) {
            try {
                tryNum = Integer.parseInt(Console.readLine());
                if (tryNum%LOTTO_PRICE==0){
                    break;
                }
                System.out.println("로또 구입 금액은 1000원의 양의 정수배만 입력 가능합니다.");
            } catch (NumberFormatException e) {
                System.out.println("로또 구입 금액은 1000원의 양의 정수배만 입력 가능합니다.");
            }
        }
    }
}
