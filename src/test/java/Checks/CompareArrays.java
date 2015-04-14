package Checks;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by bondar on 4/14/2015.
 */
public class CompareArrays {
    public static void compareArrayLists(String nonEqualMessage, ArrayList<String> array1, ArrayList<String> array2){
        boolean flag = array1.equals(array2);
        assertTrue(nonEqualMessage, flag);

        if (array1.size() != array2.size()){
            System.out.println("Arrays sizes are not equal: " + array1.size() + " and " + array2.size() + " elements correspondingly.");
        }
        else { //print difference to console
            for (int i = 0; i < array1.size(); i++){
                if (!(array1.get(i).equals(array2.get(i)))){
                    System.out.println("Element " + array1.get(i) + "(#" + (i+1) + ") is not equal to element from source category list " + array2.get(i));
                    System.out.println("First difference returned");
                    break;
                }
            }
        }
    }
}
