package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Admin {
    private int count;
    public Admin() {
        this.count = count;
    }
    public Set<String> usernumbers(int numbers) {
       Set<String> numberall = new HashSet<>();
        for (int i = 0; i < numbers; i++) {
            System.out.println("6개 번호를 입력하세요");
            String usernumbers = Console.readLine();
            String[] inputArray = usernumbers.split(",");
            Set<String> set = new HashSet<>(List.of(inputArray));
            if (set.size() != 6) {
                throw new IllegalArgumentException("중복되지않는 6개 번호를 입력하세요");
            }
            numberall.addAll(set);
          }
        return numberall;
    }
    public int bounsnumber(){
        System.out.println("보너스 번호를 입력하세요");
        String bounsnumber = Console.readLine();
        return Integer.parseInt(bounsnumber);
    }

}
