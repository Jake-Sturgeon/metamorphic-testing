import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class rotate {

    /*
    *
    *  Category: 10, 12, 15, 19, 23
    *
    *
    *  d’ = d + length( X )
    *  So: z = Collection.min(x, d), z = Collection.min(x, d’)
    *
    *  Therefore: z == z’
    *
    * */

    @Test
    void metaOneCategoryOne(){

        // X = []
        List<Integer> x = new ArrayList<Integer>();

        // X' = []
        List<Integer> xCopy = new ArrayList<Integer>(x);

        //d = 0
        int d = -0;
        // d' = 0 + 0
        int dPrime = d + x.size();

        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
        Collections.rotate(xCopy, dPrime);

        // z == z'
        assertIterableEquals(x, xCopy);
    }

    /*
     *
     *  Category: 11, 13, 16, 20, 21
     *
     *
     *  d’ = d + length( X )
     *  So: z = Collection.min(x, d), z = Collection.min(x, d’)
     *
     *  Therefore: z == z’
     *
     * */
    @Test
    void metaOneCategoryTwo() {

        // X = ["aaaaaaaaaa"]
        List<String> x = new LinkedList<String>();
        x.add("aaaaaaaaaa");
        // X' = ["aaaaaaaaaa"]
        List<String> xCopy = new LinkedList<String>(x);

        // d = 2^32 - 1
        // 2147483647
        int d = Integer.MAX_VALUE;

        // d' = -2^32 + length( x )
        // -2147483648
        // Due to arithmetic overflow
        int dPrime = d + x.size();


        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
        Collections.rotate(xCopy, dPrime);

        // z == z'
        assertIterableEquals(x, xCopy);

    }

    /*
     *
     *  Category: 11, 14, 17, 19, 22
     *
     *
     *  d’ = d + length( X )
     *  So: z = Collection.min(x, d), z = Collection.min(x, d’)
     *
     *  Therefore: z == z’
     *
     * */
    @Test
    void metaOneCategoryThree(){

        // X = [a, a,..., a]
        List<Character> x = new LinkedList<Character>();
        for(int i = 0; i < 500; i++)
            x.add('a');

        // X' = [a, a,..., a]
        List<Character> xCopy = new LinkedList<Character>(x);


        // Due to two's complement representation of signed numbers
        // d = -Integer.MIN_VALUE
        // is == Integer.MIN_VALUE due to integer overflow of bitwise inversion and adding 1
        // Therefore: d = Integer.MIN_VALUE = -2147483648
        int d = -Integer.MIN_VALUE;

        // d' = Integer.MIN_VALUE + 500 = -2147483148
        int dPrime = d + x.size();

        //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
        Collections.rotate(x, d);
        //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
        Collections.rotate(xCopy, dPrime);

        // z == z'
        assertIterableEquals(x, xCopy);


    }

    /*
     *  ====== Automated ======
     *
     *
     *  Category: 11, 14, 17, 19, 22
     *
     *
     *  d’ = d + length( X )
     *  So: z = Collection.min(x, d), z = Collection.min(x, d’)
     *
     *  Therefore: z == z’
     *
     * */
    @Test
    void metaOneCategoryThreeAutomated(){

        // Init a new random object
        Random rn = new Random();

        for(int c = 0; c < 2; c++) {

            // The number of elements in the LinkedList

            // NOTE: Over 100 is considered large in the source code and will cause the rotation method
            // to split the list in 2
            int num = rn.nextInt(10000);

            // Pick a random distance to rotate the list. Range is all possible integers
            int d = rn.nextInt();

            // Add char to list
            // NOTE: any integer can represent a UNICODE character. If the UNICODE isnt used however. It sets the
            // char to ?
            List<Character> x = new LinkedList<Character>();
            for (int i = 0; i < num; i++)
                x.add((char)rn.nextInt());

            //Deep copy list
            List<Character> xCopy = new LinkedList<Character>(x);

            // d' == d + n
            int dPrime = d + x.size();


            //Implicit assumption the z = Collections.rotate(x,d) due to inplace operations
            Collections.rotate(x, d);
            //Implicit assumption the z' = Collections.rotate(x,d') due to inplace operations
            Collections.rotate(xCopy, dPrime);

            // z == z'
            assertIterableEquals(x, xCopy);
        }


    }

    /*
     *
     *  Category: 10, 12, 15, 19, 23
     *
     *  x’ = x.append(y): 	    where y is some arbitrary value
     *  length(x) < length(x’)
     *
     *  So: z = Collection.rotate(x), z’ = Collections.rotate(x’)
     *  Therefore: length(z) < length(z’)
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

        // z == z'
        assertTrue(x.size() < xPrime.size());

    }

    /*
     *
     *  Category: 11, 13, 16, 20, 21
     *
     *  x’ = x.append(y): 	    where y is some arbitrary value
     *  length(x) < length(x’)
     *
     *  So: z = Collection.rotate(x), z’ = Collections.rotate(x’)
     *  Therefore: length(z) < length(z’)
     *
     *
     * */
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

        // z == z'
        assertTrue(x.size() < xPrime.size());

    }

    /*
     *
     *  Category: 11, 14, 17, 19, 22
     *
     *  x’ = x.append(y): 	    where y is some arbitrary value
     *  length(x) < length(x’)
     *
     *  So: z = Collection.rotate(x), z’ = Collections.rotate(x’)
     *  Therefore: length(z) < length(z’)
     *
     *
     * */
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

        // z == z'
        assertTrue(x.size() < xPrime.size());
    }



}