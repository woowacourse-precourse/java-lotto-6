package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class CorrectNum {
    private final List<Integer> correctNum = new ArrayList<>();

    public List<Integer> getCorrectNum() {
        return correctNum;
    }

    public CorrectNum(String s) {
        String correctString[] =correctStringArray(s);
        validateCorrectString(correctString);
        correctStringtoNum(correctString);
    }

    private String[] correctStringArray(String s){
        String correctString[] = s.split(",");
        return correctString;
    }
    private void correctStringtoNum(String[] correctString){

        for(int i = 0 ; i<correctString.length; i++){
            correctNum.add(Integer.parseInt(correctString[i]));
        }
    }
    private void validateCorrectString(String[] correctString){
        validateCorrectStringLength(correctString);

        for(int i = 0 ; i< correctString.length; i++) {
            String s = correctString[i];
            validateCorrectStringNum(s);
            validateCorrectStringRange(s);
        }
    }

    private void validateCorrectStringLength(String[] correctString) {
        if(correctString.length!=6){
            throw new IllegalArgumentException();
        }
    }


    private void validateCorrectStringRange(String s) {
        if(Integer.parseInt(s)<1 || Integer.parseInt(s)>45){
            throw new IllegalArgumentException();
        }
    }

    private void validateCorrectStringNum(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
