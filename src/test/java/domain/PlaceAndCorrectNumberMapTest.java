package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaceAndCorrectNumberMapTest {

    @Test
    void 답을맞춘개수와_보너스여부에따른_Place값테스트(){
        Place first = PlaceAndCorrectNumberMap.whichPlace(6, false);
        Place second = PlaceAndCorrectNumberMap.whichPlace(5, true);
        Place third = PlaceAndCorrectNumberMap.whichPlace(5, false);
        Place forth = PlaceAndCorrectNumberMap.whichPlace(4, false);
        Place fifth = PlaceAndCorrectNumberMap.whichPlace(3, false);
        Place none1 = PlaceAndCorrectNumberMap.whichPlace(2, false);
        Place none2 = PlaceAndCorrectNumberMap.whichPlace(1, false);
        Place none3 = PlaceAndCorrectNumberMap.whichPlace(0, false);

        assertThat(Place.FIRST).isEqualTo(first);
        assertThat(Place.SECOND).isEqualTo(second);
        assertThat(Place.THIRD).isEqualTo(third);
        assertThat(Place.FORTH).isEqualTo(forth);
        assertThat(Place.FIFTH).isEqualTo(fifth);
        assertThat(Place.NONE).isEqualTo(none1);
        assertThat(Place.NONE).isEqualTo(none2);
        assertThat(Place.NONE).isEqualTo(none3);
    }

}