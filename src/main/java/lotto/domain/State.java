package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class State {
    private List<Integer> gradeState;

    public State (){
        this.gradeState = List.of(0,0,0,0,0,0);
    }
    public void setGradeState(Integer grade) {
        Integer currentState = gradeState.get(grade);
        gradeState.set(grade, currentState + 1);
    }

    public List<Integer> getGradeState(){
        return gradeState;
    }

}
