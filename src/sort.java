import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class sort {

    /*
    *
    *  Categories: 1, 3, 6
    *
    *  Metamorphic Relation
    *  length(x) < length(x’)
    *
    *  So: z = Collection.sort(x), z’ = Collections.sort(x’)
    *  Therefore: length(z) < length(z’)
    *
    * */

    @Test
    void metaOneCategoryOne(){

        //x = []
        List<Integer> x = new ArrayList<Integer>();

        //x' = [] + [1]
        List<Integer> xPrime = new ArrayList<Integer>();
        xPrime.add(1);

        // See if length(x) < length(x’)
        assertTrue( xPrime.size() > x.size());

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        // See if length(z) < length(z’) now holds
        assertTrue( xPrime.size() > x.size());

    }

    /*
     *
     *  Categories: 2, 4, 7
     *
     *  Metamorphic Relation
     *  length(x) < length(x’)
     *
     *  So: z = Collection.sort(x), z’ = Collections.sort(x’)
     *  Therefore: length(z) < length(z’)
     *
     * */
    @Test
    void metaOneCategoryTwo(){

        // x = ["aaaaaaaaaa"]
        List<String> x = new ArrayList<String>();
        x.add("aaaaaaaaaa");

        // x' = ["aaaaaaaaaa"] + ["aaaaaaaaaa"]
        List<String> xPrime = new ArrayList<String>(x);
        xPrime.add("aaaaaaaaaa");

        // See if length(x) < length(x’)
        assertTrue( xPrime.size() > x.size());

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        // See if length(z) < length(z’) now holds
        assertTrue( xPrime.size() > x.size());

    }

    /*
     *
     *  Categories: 2, 5, 8
     *
     *  Metamorphic Relation
     *  length(x) < length(x’)
     *
     *  So: z = Collection.sort(x), z’ = Collections.sort(x’)
     *  Therefore: length(z) < length(z’)
     *
     * */
    @Test
    void metaOneCategoryThree(){


        //x = [1, 1, ...., 1]
        List<Double> x = new ArrayList<Double>();
        for(int i = 0; i < 500; i++)
            x.add(1.0);

        //x' = [1, 1, ...., 1] + [1]
        List<Double> xPrime = new ArrayList<Double>(x);
        xPrime.add(1.0);

        // See if length(x) < length(x’)
        assertTrue( xPrime.size() > x.size());

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        // See if length(z) < length(z’) now holds
        assertTrue( xPrime.size() > x.size());


    }


    /*
     *  Categories: 1, 3, 6
     *
     *  Metamorphic Relation:
     *
     *  x'0, x'1, ..., x'n = x0 + 1, x1 + 1, ..., xn + 1
     *  => X' = X + 1
     *
     *  So:
     *  z = Collection.sort(x), z’ = Collections.sort(x’):
     *
     *  Where:
     *  z'0, z'1, ..., z'n = z0 + 1, z1 + 1, ..., zn + 1
     *  => Z' = Z + 1
     *
     *  Therefore: z’ == z + 1
     *
     * */

    @Test
    void metaTwoCategoryOne(){

        // X = []
        List<Integer> x = new ArrayList<Integer>();

        // X' = [] + 1 = []
        //implicit assumption that empty element + 1 is the empty element
        List<Integer> xPrime = new ArrayList<Integer>(x);


        // See if X' == X + 1
        assertIterableEquals(
                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
                xPrime);

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        // See if Z' == Z + 1 now holds
        assertIterableEquals(
                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
                xPrime);

    }

    /*
     *
     *  ===========NOTE: THIS WILL NOT WORK DUE TO CATEGORY 5 USING STRINGS=================
     *
     *  = However, concatenating an "a" could be treated as the same operation?
     *  = So was implemented but commented out
     *
     *  Categories: 2, 4, 7
     *
     *  Metamorphic Relation:
     *
     *  x'0, x'1, ..., x'n = x0 + 1, x1 + 1, ..., xn + 1
     *  => X' = X + 1
     *
     *  So:
     *  z = Collection.sort(x), z’ = Collections.sort(x’):
     *
     *  Where:
     *  z'0, z'1, ..., z'n = z0 + 1, z1 + 1, ..., zn + 1
     *  => Z' = Z + 1
     *
     *  Therefore: z’ == z + 1
     *
     *
     * ===========NOTE: THIS WILL NOT WORK DUE TO CATEGORY 5 USING STRINGS=================
     * */
    @Test
    void metaTwoCategoryTwo(){
//        List<String> x = new ArrayList<String>();
//        x.add("aaaaaaaaaa");
//
//        //implicit assumption that empty element + 1 is the empty element
//        List<String> xPrime = new ArrayList<String>(x);
//        for(int i = 0; i < xPrime.size(); i++)
//            xPrime.set(i, xPrime.get(i) + "a");
//
//        System.out.println(xPrime);
//
//        // Map x to x + 1
//        assertIterableEquals(
//                x.stream().map(el -> el + "a" ).collect(Collectors.toCollection(ArrayList::new)),
//                xPrime);
//
//        Collections.sort(x);
//        Collections.sort(xPrime);
//
//        // Map z to z + 1
//        assertIterableEquals(
//                x.stream().map(el -> el + "a" ).collect(Collectors.toCollection(ArrayList::new)),
//                xPrime);

    }

    /*
     *  Categories: 2, 5, 8
     *
     *  Metamorphic Relation:
     *
     *  x'0, x'1, ..., x'n = x0 + 1, x1 + 1, ..., xn + 1
     *  => X' = X + 1
     *
     *  So:
     *  z = Collection.sort(x), z’ = Collections.sort(x’):
     *
     *  Where:
     *  z'0, z'1, ..., z'n = z0 + 1, z1 + 1, ..., zn + 1
     *  => Z' = Z + 1
     *
     *  Therefore: z’ == z + 1
     *
     *
     *
     * */
    @Test
    void metaTwoCategoryThree(){

        // X = [1.0, 1.0, ..., 1.0]
        List<Double> x = new ArrayList<Double>();
        for(int i = 0; i <10; i++)
            x.add(1.0);
        // X' = [1.0 + 1, 1.0 + 1, ..., 1.0 + 1]
        List<Double> xPrime = new ArrayList<Double>(x);
        for(int i = 0; i <xPrime.size(); i++)
            xPrime.set(i, xPrime.get(i) + 1);


        // See if X' == X + 1
        assertIterableEquals(x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)), xPrime);

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        // See if Z' == Z + 1 now holds
        assertIterableEquals(x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)), xPrime);

    }



}