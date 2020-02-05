import sun.security.mscapi.KeyStore;

import java.math.BigDecimal;
import java.util.*;

public class main {

    static void filter(Collection<BigDecimal> numbers) throws MyException {

        try {
            BigDecimal[] bdArray = new BigDecimal[numbers.size()];
            bdArray = (BigDecimal[]) numbers.toArray(bdArray);
            quickSort(bdArray, 0, bdArray.length - 1);
            BigDecimal delta = bdArray[bdArray.length - 1].divide(bdArray[0], BigDecimal.ROUND_DOWN);
            Collection<BigDecimal> result = deleteElement(Arrays.asList(bdArray), delta);
            for (BigDecimal item : result) {
                System.out.println(item);
            }
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    static void quickSort(BigDecimal[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        BigDecimal temp = array[middle];
        int i = low, j = high;
        while (i <= j) {
            while (array[i].compareTo(temp) < 0) {
                i++;
            }
            while (array[j].compareTo(temp) > 0) {
                j--;
            }
            if (i <= j) {//меняем местами
                BigDecimal temp1 = array[i];
                array[i] = array[j];
                array[j] = temp1;
                i++;
                j--;
            }
        }
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }

    static Collection<BigDecimal> deleteElement(Collection<BigDecimal> collection, BigDecimal criteria) {
        Collection<BigDecimal> tempCollection = new ArrayList<>();
        for (BigDecimal item : collection) {
            if (item.compareTo(criteria) < 0) {

            } else {
                tempCollection.add(item);
            }
        }
        return tempCollection;
    }

    public static void main(String[] args) {
        Collection bigList = new ArrayList<BigDecimal>();
        bigList.add(new BigDecimal("10.26"));
        bigList.add(new BigDecimal("23.2357"));
        bigList.add(new BigDecimal("45.5890"));
        bigList.add(new BigDecimal("4.1234"));
        bigList.add(new BigDecimal("78.324687"));
        bigList.add(new BigDecimal("1023.124556"));

        filter(bigList);


    }

}


class MyException extends RuntimeException {
    public MyException(String msg) {
        super(msg);
    }
}