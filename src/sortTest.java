import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class sortTest {

    @Test
    void sortTest(){
       double x =  Math.toRadians(60);

       double t = Math.PI - x ;

       double sutOrg = Math.sin(x);
       double sutTra = Math.sin(t);

       assertEquals(sutOrg,sutTra,"Relation: sin(x) = sin(π-x)");


    }

}