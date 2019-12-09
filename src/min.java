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

        // X = [1]
        List<Integer> x = new LinkedList<Integer>();
        x.add(1);

        // X' = [1 + 1]
        List<Integer> xPrime = x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(LinkedList<Integer>::new));

        // see if X' = X + 1 holds
        assertIterableEquals(x.stream().map(el -> el + 1 ).collect(Collectors.toCollection(LinkedList<Integer>::new)), xPrime);

        int z = Collections.min(x);
        int zPrime = Collections.min(xPrime);

        // z' == z + 1
        assertEquals(z + 1, zPrime);

    }

    @Test
    void metaOneCategoryTwo(){

        // X = [0f, 1f, ..., 9999f]
        Queue<Float> x = new PriorityQueue<Float>();
        for(float i = 0; i < 10000; i++)
            x.add(i);

        // X' = [0f + 1, 1f + 1, ..., 9999f + 1]
        Queue<Float> xPrime = x.stream().map(el -> el + 1f ).collect(Collectors.toCollection(PriorityQueue<Float>::new));

        // see if X' = X + 1 holds
        assertIterableEquals(x.stream().map(el -> el + 1f ).collect(Collectors.toCollection(PriorityQueue<Float>::new)), xPrime);

        float z = Collections.min(x);
        float zPrime = Collections.min(xPrime);

        // z' == z + 1
        assertEquals(z + 1, zPrime);

    }

    @Test
    void metaOneCategoryThree(){

        // X = {0, 1, ..., 499}
        Set<Double> x = new HashSet<Double>();
        for(double i = 0; i < 500; i++)
            x.add(i);

        // X = {0 + 1, 1 + 1, ..., 499 + 1}
        Set<Double> xPrime = x.stream().map(el -> el + 1.0 ).collect(Collectors.toCollection(HashSet<Double>::new));

        // see if X' = X + 1 holds
        // Note assertEquals due to a set's iterator is not guaranteed
        assertEquals(x.stream().map(el -> el + 1.0 ).collect(Collectors.toCollection(HashSet<Double>::new)), xPrime);

        double z = Collections.min(x);
        double zPrime = Collections.min(xPrime);

        // z' == z + 1
        assertEquals(z + 1, zPrime);


    }

    @Test
    void metaOneCategoryThreeAutomated(){

        // Init a new random object
        Random rn = new Random();


        for(int c = 0; c < 1000; c++) {

            // The number of elements in the set
            int num = rn.nextInt(10000);

            // The number to add to X
            final double N = rn.nextDouble();

            // X = {x_1, x_2, ..., x_num}
            Set<Double> x = new HashSet<Double>();
            for (double i = 0; i < num; i++)
                x.add(rn.nextDouble());

            // X' = {x_1 + N, x_2  + N, ..., x_num + N}
            Set<Double> xPrime = x.stream().map(el -> el + N).collect(Collectors.toCollection(HashSet<Double>::new));

            // see if X' == X + N
            assertEquals(x.stream().map(el -> el + N).collect(Collectors.toCollection(HashSet<Double>::new)), xPrime);

            double z = Collections.min(x);
            double zPrime = Collections.min(xPrime);

            // z' == z + N
            assertEquals(z + N, zPrime);

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
        //X = [1]
        List<Integer> x = new LinkedList<Integer>();
        x.add(1);

        // X' = max(-X)
        List<Integer> xPrime = x.stream().map(el -> -el).collect(Collectors.toCollection(LinkedList::new));
        xPrime = max(xPrime);


        int z = Collections.min(x);
        int zPrime = Collections.min(xPrime);

        // See if -z == z' now holds
        assertEquals(-z, zPrime);

    }

    @Test
    void metaTwoCategoryTwo(){

        //X = [0f, 1f, ..., 9999f]
        Queue<Float> x = new PriorityQueue<Float>();
        for(float i = 0; i < 10000; i++)
            x.add(i);

        // X' = max(-X)
        Queue<Float> xPrime = x.stream().map(el -> -el).collect(Collectors.toCollection(PriorityQueue::new));
        xPrime = max(xPrime);


        float z = Collections.min(x);
        float zPrime = Collections.min(xPrime);

        // See if -z == z' now holds
        assertEquals(-z , zPrime);


    }

    @Test
    void metaTwoCategoryThree(){

        // X = [0, 2, ..., 499]
        Set<Double> x = new HashSet<Double>();
        for(double i = 0; i < 500; i++)
            x.add(i);

        // X' = max(-X)
        Set<Double> xPrime = x.stream().map(el -> -el).collect(Collectors.toCollection(HashSet::new));
        xPrime = max(xPrime);

        double z = Collections.min(x);
        double zPrime = Collections.min(xPrime);

        // See if -z == z' now holds
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