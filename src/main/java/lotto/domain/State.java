package lotto.domain;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class State {
    private final Map<Grade,Integer> gradeState;
    public State (){
        this.gradeState = Stream.of(
                new AbstractMap.SimpleEntry<>(Grade.FIRST, 0),
                new AbstractMap.SimpleEntry<>(Grade.SECOND, 0),
                new AbstractMap.SimpleEntry<>(Grade.THIRD, 0),
                new AbstractMap.SimpleEntry<>(Grade.FOURTH, 0),
                new AbstractMap.SimpleEntry<>(Grade.FIFTH, 0)
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
    public void setGradeState(Grade grade) {
        Integer currentState = gradeState.get(grade);
        gradeState.put(grade, currentState  + 1);
    }
    public Map<Grade, Integer> getGradeState(){
        return gradeState;
    }

}
