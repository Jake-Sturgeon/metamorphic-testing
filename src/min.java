import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class min {

    /*
    *
    *
    *  Therefore:
    *
    *
    *
    * */

    @Test
    void metaOneCategoryOne(){

        List<Integer> x = new LinkedList<Integer>();
        x.add(1);

        List<Integer> xPrime = new LinkedList<Integer>(x);
        xPrime.set(0, xPrime.get(0) + 1);

        assertIterableEquals(
                x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(LinkedList::new)),
                xPrime);

        int z = Collections.min(x);
        int zPrime = Collections.min(xPrime);

        assertEquals(z + 1, zPrime);

    }

    @Test
    void metaOneCategoryTwo(){

        Queue<Float> x = new PriorityQueue<Float>();
        x.add(1f);

        Queue<Float> xPrime = x.stream().map(el -> el + 1f ).collect(Collectors.toCollection(PriorityQueue::new));

        assertIterableEquals(
                x.stream().map(el -> el + 1f ).collect(Collectors.toCollection(PriorityQueue::new)),
                xPrime);

        float z = Collections.min(x);
        float zPrime = Collections.min(xPrime);

        assertEquals(z + 1, zPrime);

    }

    @Test
    void metaOneCategoryThree(){

        Set<Double> x = new HashSet<Double>();
        for(double i = 0; i < 500; i++)
            x.add(i);

        Set<Double> xPrime = x.stream().map(el -> el + 1.0 ).collect(Collectors.toCollection(HashSet::new));

        assertEquals(
                x.stream().map(el -> el + 1.0 ).collect(Collectors.toCollection(HashSet::new)),
                xPrime);

        double z = Collections.min(x);
        double zPrime = Collections.min(xPrime);

        assertEquals(z + 1, zPrime);


    }

    @Test
    void metaOneCategoryThreeAutomated(){

        Random rn = new Random();

        for(int c = 0; c < 1000; c++) {

            int num = rn.nextInt(10000) + 1;
            final double n = rn.nextDouble();

            Set<Double> x = new HashSet<Double>();
            for (double i = 0; i < num; i++)
                x.add(rn.nextDouble());

            Set<Double> xPrime = x.stream().map(el -> el + n).collect(Collectors.toCollection(HashSet<Double>::new));


            assertEquals(
                    x.stream().map(el -> el + n).collect(Collectors.toCollection(HashSet<Double>::new)),
                    xPrime);

            double z = Collections.min(x);
            double zPrime = Collections.min(xPrime);

            assertEquals(z + n, zPrime);

        }
    }


    /*
     *
     *
     *
     *
     * */

    @Test
    void metaTwoCategoryOne(){

        List<Integer> x = new LinkedList<Integer>();
        x.add(1);

        List<Integer> xPrime = x.stream().map(el -> -el).collect(Collectors.toCollection(LinkedList::new));

        // xPrime is now list of max(-x)
        xPrime = max(xPrime);

        int z = Collections.min(x);
        int zPrime = Collections.min(xPrime);

        assertEquals(-z, zPrime);

    }

    @Test
    void metaTwoCategoryTwo(){

        Queue<Float> x = new PriorityQueue<Float>();
        x.add(1f);

        Queue<Float> xPrime = x.stream().map(el -> -el).collect(Collectors.toCollection(PriorityQueue::new));

        // xPrime is now list of max(-x)
        xPrime = max(xPrime);


        float z = Collections.min(x);
        float zPrime = Collections.min(xPrime);

        assertEquals(-z , zPrime);


    }

    @Test
    void metaTwoCategoryThree(){

        Set<Double> x = new HashSet<Double>();
        for(double i = 0; i < 500; i++)
            x.add(i);

        Set<Double> xPrime = x.stream().map(el -> -el).collect(Collectors.toCollection(HashSet::new));

        // xPrime is now list of max(-x)
        xPrime = max(xPrime);


        double z = Collections.min(x);
        double zPrime = Collections.min(xPrime);

        assertEquals(-z, zPrime);

    }

    private static Set<Double> max(Set<Double> x) {
        Set<Double> temp = new HashSet<Double>();
        temp.add(Collections.max(x));

        return temp;
    }
    private static Queue<Float> max(Queue<Float> x) {
        Queue<Float> temp = new PriorityQueue<Float>();
        temp.add(Collections.max(x));

        return temp;
    }
    private static List<Integer> max(List<Integer> x) {
        List<Integer> temp = new LinkedList<Integer> ();
        temp.add(Collections.max(x));

        return temp;
    }

}