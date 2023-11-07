package lotto.model;

import java.util.ArrayList;

public class CorrectNum {
    public ArrayList<Integer> correctNum = new ArrayList<>();

    public CorrectNum(String s) {
        String correctString[] =correctStringArray(s);
    }

    public String[] correctStringArray(String s){
        String correctString[] = s.split(",");
        return correctString;
    }
}
