import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class rotate {

    /*
    *
    *  length x' > length x
    *  Therefore:
    *
    *  length z' > length z
    *
    * */

    @Test
    void metaOneCategoryOne(){

        List<Integer> x = new ArrayList<Integer>();
        List<Integer> xCopy = new ArrayList<Integer>(x);

        int d = -0;

        int dPrime = d + x.size();

        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
        Collections.rotate(xCopy, dPrime);

        assertIterableEquals(x, xCopy);
    }

    @Test
    void metaOneCategoryTwo() {

        List<String> x = new LinkedList<String>();
        x.add("aaaaaaaaaa");
        List<String> xCopy = new LinkedList<String>(x);

        int d = Integer.MAX_VALUE;

        int dPrime = d + x.size();


        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
        Collections.rotate(xCopy, dPrime);

        assertIterableEquals(x, xCopy);

    }

    @Test
    void metaOneCategoryThree(){

        List<Character> x = new LinkedList<Character>();
        for(int i = 0; i < 500; i++)
            x.add('a');
        List<Character> xCopy = new LinkedList<Character>(x);

        int d = -Integer.MIN_VALUE;

        int dPrime = d + x.size();


        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
        Collections.rotate(xCopy, dPrime);

        assertIterableEquals(x, xCopy);


    }

    @Test
    void metaOneCategoryThreeAutomated(){

        Random rn = new Random();

        for(int c = 0; c < 1000; c++) {

            int num = rn.nextInt(100000) + 100;
            int d = rn.nextInt();

            List<Character> x = new LinkedList<Character>();
            for (int i = 0; i < num; i++)
                x.add((char)rn.nextInt());

            List<Character> xCopy = new LinkedList<Character>(x);

            int dPrime = d + x.size();


            //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
            Collections.rotate(x, d);
            //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
            Collections.rotate(xCopy, dPrime);

            assertIterableEquals(x, xCopy);
        }


    }


    /*
     *
     *  x'0, x'1, ..., x'n = x0 + 1, x1 + 1, ..., xn + 1
     *  Therefore:
     *
     *  z'0, z'1, ..., z'n = z0 + 1, z1 + 1, ..., zn + 1
     *
     *
     *  NOTE: This doesnt work on Category 2 due to it using type string
     *
     *
     * */

    @Test
    void metaTwoCategoryOne(){

        List<Integer> x = new ArrayList<Integer>();
        List<Integer> xPrime = new ArrayList<Integer>(x);
        xPrime.add(1);

        int d = -0;

        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x',d) due to inplace operations
        Collections.rotate(xPrime, d);

        assertTrue(x.size() < xPrime.size());

    }

    @Test
    void metaTwoCategoryTwo(){

        List<String> x = new ArrayList<String>();
        x.add("aaaaaaaaaa");
        List<String> xPrime = new ArrayList<String>(x);
        xPrime.add("aaaaaaaaaa");

        int d = Integer.MAX_VALUE;


        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x',d) due to inplace operations
        Collections.rotate(xPrime, d);

        assertTrue(x.size() < xPrime.size());

    }

    @Test
    void metaTwoCategoryThree(){

        List<Character> x = new LinkedList<Character>();
        for(int i = 0; i < 500; i++)
            x.add('a');
        List<Character> xPrime = new LinkedList<Character>(x);
        xPrime.add('a');

        int d = -Integer.MIN_VALUE;


        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x',d) due to inplace operations
        Collections.rotate(xPrime, d);


        assertTrue(x.size() < xPrime.size());
    }



}