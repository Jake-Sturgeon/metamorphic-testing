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
    *  length x' > length x
    *  Therefore:
    *
    *  length z' > length z
    *
    * */

    @Test
    void metaOneCategoryOne(){


        List<Integer> x = new ArrayList<Integer>();

        List<Integer> xPrime = new ArrayList<Integer>();
        xPrime.add(1);

        assertTrue( xPrime.size() > x.size());

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        assertTrue( xPrime.size() > x.size());

    }

    @Test
    void metaOneCategoryTwo(){

        List<String> x = new ArrayList<String>();
        x.add("aaaaaaaaaa");

        List<String> xPrime = new ArrayList<String>(x);
        xPrime.add("aaaaaaaaaa");
        assertTrue( xPrime.size() > x.size());

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        assertTrue( xPrime.size() > x.size());

    }

    @Test
    void metaOneCategoryThree(){

        List<Double> x = new ArrayList<Double>();
        for(int i = 0; i < 500; i++)
            x.add(1.0);

        List<Double> xPrime = new ArrayList<Double>(x);
        xPrime.add(1.0);

        assertTrue( xPrime.size() > x.size());

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        assertTrue( xPrime.size() > x.size());


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

        //implicit assumption that empty element + 1 is the empty element
        List<Integer> xPrime = new ArrayList<Integer>(x);


        // Map x to x + 1
        assertIterableEquals(
                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
                xPrime);

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        // Map z to z + 1
        assertIterableEquals(
                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
                xPrime);

    }

    @Test
    void metaTwoCategoryTwo(){

//        List<String> x = new ArrayList<String>();
//        x.add("aaaaaaaaaa");
//
//        //implicit assumption that empty element + 1 is the empty element
//        List<String> xPrime = new ArrayList<String>(x);
//        for(int i = 0; i <xPrime.size(); i++)
//            xPrime.set(i, xPrime.get(i) + 1);
//
//        System.out.println(xPrime);
//
//        // Map x to x + 1
//        assertIterableEquals(
//                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
//                xPrime);
//
//        Collections.sort(x);
//        Collections.sort(xPrime);
//
//        // Map z to z + 1
//        assertIterableEquals(
//                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
//                xPrime);

    }

    @Test
    void metaTwoCategoryThree(){

        List<Double> x = new ArrayList<Double>();
        for(int i = 0; i <10; i++)
            x.add(1.0);

        List<Double> xPrime = new ArrayList<Double>(x);
        for(int i = 0; i <xPrime.size(); i++)
            xPrime.set(i, xPrime.get(i) + 1);


        // Map x to x + 1
        assertIterableEquals(
                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
                xPrime);

        //Implicit assumption the z = Collections.sort(x) due to inplace operations
        Collections.sort(x);
        //Implicit assumption the z' = Collections.sort(x') due to inplace operations
        Collections.sort(xPrime);

        // Map z to z + 1
        assertIterableEquals(
                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(ArrayList::new)),
                xPrime);

    }



}