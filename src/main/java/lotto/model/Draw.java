package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Draw {

    private List<Integer> drawed =  new ArrayList<>();
    public Draw() {
    }
    public Draw(List<Integer> ticket) {
        this.drawed = ticket;
    }
    @Override
    public String toString() {
        return ""+drawed;
    }
    // 방법이 생각안나서 임시로 만듦 => 리팩토링 꼭 해야됨
    public List<Integer> returnprint() {
        List<Integer> output = new ArrayList<>();
        for (int i : drawed) output.add(i);
        return output;
    }
}
