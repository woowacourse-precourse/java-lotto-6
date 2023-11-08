package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Admin {
    private String[] winnumber;

    public Admin() {

        this.winnumber = winnumber;
    }
    public int[] winumbers() {
        System.out.println("6개 번호를 입력하세요");
        String usernumbers = Console.readLine();
        String[] inputArray = usernumbers.split(",");
        if (inputArray.length!= 6) {
            throw new IllegalArgumentException("중복되지않는 6개 번호를 입력하세요");
        }
        int[] intnumbers = new int[inputArray.length];
        for (int i = 0; i <inputArray.length ; i++) {
            intnumbers[i] = Integer.parseInt(inputArray[i]);
        }
        Arrays.sort(intnumbers);
        return intnumbers;
    }
    public int bounsnumber(){
        System.out.println("보너스 번호를 입력하세요");
        String bounsnumber = Console.readLine();
        return Integer.parseInt(bounsnumber);
    }

}
