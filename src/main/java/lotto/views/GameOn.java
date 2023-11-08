package lotto.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class GameOn {
    Scanner scan = new Scanner(System.in);

    public String showCase(){
        System.out.println("당첨번호를 입력해주세요.");
        String inputLine = Console.readLine();

        return inputLine;
    }

    public int moreCase(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputLine = Console.readLine();
        int input = Integer.parseInt(inputLine);

        return input;
    }
}
