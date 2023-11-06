package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int totalPrice = Integer.parseInt(readLine());

        int[] winNumber  = new int[7];
        String[] winNumberString = readLine().split(",");

        for (int i = 0; i < 6; i++){
            winNumber[i] = Integer.parseInt(winNumberString[i].trim());
        }

        int bonusNumber = Integer.parseInt(readLine());
        winNumber[6] = bonusNumber;

        System.out.println("당첨번호: "+ winNumber);


    }
}
