package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MakeNumList {
    public List<Integer> makeList(String userNumber){
        String[] userList = userNumber.split(",");
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<userList.length;i++){
            numbers.add(Integer.parseInt(userList[i]));
        }
        return numbers;
    }
}
