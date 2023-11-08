package domain;

import java.util.HashMap;
import java.util.Map;

public class PlaceAndCorrectNumberMap {
    public static final int CAN_SECOND = 5;
    private static Map<Double,Place> placeReturnMap = new HashMap<>(){{
       put(6D,Place.FIRST);
       put(5.5,Place.SECOND);
       put(5D,Place.THIRD);
       put(4D,Place.FORTH);
       put(3D,Place.FIFTH);
       put(2D,Place.NONE);
       put(1D,Place.NONE);
       put(0D,Place.NONE);
    }};

    public static Place whichPlace(int correctNumber,boolean bonusOn){
        Double convertCorrectNumber = 0.0;
        if(correctNumber == CAN_SECOND && bonusOn){
            convertCorrectNumber = 0.5;
        }
        convertCorrectNumber += correctNumber;
        return placeReturnMap.get(convertCorrectNumber);
    }

}
