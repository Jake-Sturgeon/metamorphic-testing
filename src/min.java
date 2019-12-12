import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class min {

    /*
    *
    *
    *  Category: 10, 31, 33
    *
    *  x'0, x'1, ..., x'n = x0 + 1, x1 + 1, ..., xn + 1
    *  => X' = X + 1
    *
    *  Where:
    *  z'0, z'1, ..., z'n = z0 + 1, z1 + 1, ..., zn + 1
    *  => Z' = Z + 1
    *
    *  Therefore: z’ == z + 1
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

    /*
     *
     *
     *  Category: 27, 33, 35
     *
     *  x'0, x'1, ..., x'n = x0 + 1, x1 + 1, ..., xn + 1
     *  => X' = X + 1
     *
     *  Where:
     *  z'0, z'1, ..., z'n = z0 + 1, z1 + 1, ..., zn + 1
     *  => Z' = Z + 1
     *
     *  Therefore: z’ == z + 1
     *
     * */
    @Test
    void metaOneCategoryTwo(){

        // X = [10000f, 9999ff, ..., 1f]
        Queue<Float> x = new PriorityQueue<Float>();
        for(float i = 10000; i > 0; i--)
            x.add(i);

        // X' = [10000f + 1, 9999ff + 1, ..., 1f + 1]
        Queue<Float> xPrime = x.stream().map(el -> el + 1f ).collect(Collectors.toCollection(PriorityQueue<Float>::new));

        // see if X' = X + 1 holds
        assertIterableEquals(x.stream().map(el -> el + 1f ).collect(Collectors.toCollection(PriorityQueue<Float>::new)), xPrime);

        float z = Collections.min(x);
        float zPrime = Collections.min(xPrime);

        // z' == z + 1
        assertEquals(z + 1, zPrime);

    }

    /*
     *
     *
     *  Category: 29, 32, 36
     *
     *  x'0, x'1, ..., x'n = x0 + 1, x1 + 1, ..., xn + 1
     *  => X' = X + 1
     *
     *  Where:
     *  z'0, z'1, ..., z'n = z0 + 1, z1 + 1, ..., zn + 1
     *  => Z' = Z + 1
     *
     *  Therefore: z’ == z + 1
     *
     * */
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

    /*
     *  ====== Automated Test ======
     *
     *  Category: 29, 32, 36
     *
     *  N => Random
     *  X => List of Doubles of a Random size
     *
     *  x'0, x'1, ..., x'n = x0 + N, x + N, ..., xn + N
     *  => X' = X + N
     *
     *  Where:
     *  z'0, z'1, ..., z'n = z0 + N, z1 + N, ..., zn + N
     *  => Z' = Z + N
     *
     *  Therefore: z’ == z + N
     *
     * */
    @Test
    void metaOneCategoryThreeAutomated(){

        // Init a new random object
        Random rn = new Random();


        for(int c = 0; c < 1000; c++) {

            // The number of elements in the set
            // do while loop prevents 0
            int num = 0;
            do {
                num = rn.nextInt(10000);
            } while(num == 0);

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
//            System.out.println(x);
            double z = Collections.min(x);
            double zPrime = Collections.min(xPrime);

            // z' == z + N
            assertEquals(z + N, zPrime);

        }
    }


    /*
     *
     *
     *  Category: 10, 31, 33
     *
     *  x'0, x'1, ..., x'n = -x0, -x1, ..., -xn
     *
     *  => X' = max(-X)    -->     assumption that max returns a collection of largest value in the collection
     *                     -->     e.g. X' = max(-[1,2,3]) = [-1]
     *  Where:
     *  z'0, z'1, ..., z'n = -z0, -z1, ..., -zn
     *  => Z' = -Z
     *
     *  Therefore: z’ == -z
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

    /*
     *
     *
     *  Category: 27, 33, 35
     *
     *  x'0, x'1, ..., x'n = -x0, -x1, ..., -xn
     *
     *  => X' = max(-X)    -->     assumption that max returns a collection of largest value in the collection
     *                     -->     e.g. X' = max(-[1,2,3]) = [-1]
     *  Where:
     *  z'0, z'1, ..., z'n = -z0, -z1, ..., -zn
     *  => Z' = -Z
     *
     *  Therefore: z’ == -z
     *
     * */
    @Test
    void metaTwoCategoryTwo(){

        // X' = [10000f, 9999ff, ..., 1f]
        Queue<Float> x = new PriorityQueue<Float>();
        for(float i = 10000; i > 0; i--)
            x.add(i);

        // X' = max(-X)
        Queue<Float> xPrime = x.stream().map(el -> -el).collect(Collectors.toCollection(PriorityQueue::new));
        xPrime = max(xPrime);

        float z = Collections.min(x);
        float zPrime = Collections.min(xPrime);

        // See if -z == z' now holds
        assertEquals(-z , zPrime);


    }

    /*
     *
     *
     *  Category: Category: 29, 32, 36
     *
     *  x'0, x'1, ..., x'n = -x0, -x1, ..., -xn
     *
     *  => X' = max(-X)    -->     assumption that max returns a collection of largest value in the collection
     *                     -->     e.g. X' = max(-[1,2,3]) = [-1]
     *  Where:
     *  z'0, z'1, ..., z'n = -z0, -z1, ..., -zn
     *  => Z' = -Z
     *
     *  Therefore: z’ == -z
     *
     * */
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

    // max: {Double} -> {Double}
    private static Set<Double> max(Set<Double> x) {
        // If the list is empty or has one element
        // then just return the original list
        if (x.size() <= 1)
            return x;

        //init temp collection and iterator
        Set<Double> temp = new HashSet<Double>();
        Iterator<Double> i = x.iterator();

        //find max value in the collection
        double max = -Double.MAX_VALUE;
        while(i.hasNext()) {
            double n = i.next();
            if(n > max) {
                max = n;
            }
        }

        //return a collection of the max value
        temp.add(max);
        return temp;
    }

    // max: [Float] -> [Float]
    private static Queue<Float> max(Queue<Float> x) {
        // If the list is empty or has one element
        // then just return the original list
        if (x.size() <= 1)
            return x;

        //init temp collection and iterator
        Queue<Float> temp = new PriorityQueue<Float>();
        Iterator<Float> i = x.iterator();

        //find max value in the collection
        float max = -Float.MAX_VALUE;
        while(i.hasNext()) {
            float n = i.next();
            if(n > max) {
                max = n;
            }
        }

        //return a collection of the max value
        temp.add(max);
        return temp;
    }

    // max: {Integer} -> {Integer}
    private static List<Integer> max(List<Integer> x) {
//        List<Integer> temp = new LinkedList<Integer> ();
//        temp.add(Collections.max(x));

        // If the list is empty or has one element
        // then just return the original list
        if (x.size() <= 1)
            return x;

        //init temp collection and iterator
        List<Integer> temp = new LinkedList<Integer>();
        Iterator<Integer> i = x.iterator();

        //find max value in the collection
        int max = Integer.MIN_VALUE;
        while(i.hasNext()) {
            int n = i.next();
            if(n > max) {
                max = n;
            }
        }

        //return a collection of the max value
        temp.add(max);
        return temp;
    }

}