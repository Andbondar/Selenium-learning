package Checks;

import java.util.List;

/**
 * Created by bondar on 4/14/2015.
 */
public class CompareArrays {
    //return boolean + print difference to console if it is present (size or specific element = 1st occurred difference)
    public static boolean compareArrayLists(List array1, List array2){
        if (array1.size() != array2.size()){
            System.out.println("Arrays sizes are not equal: " + array1.size() + " and " + array2.size() + " elements correspondingly.");
        }
        else { //print difference to console
            for (int i = 0; i < array1.size(); i++){
                if (!(array1.get(i).equals(array2.get(i)))){
                    System.out.println("Element " + array1.get(i) + "(#" + (i+1) + ") is not equal to element from source list " + array2.get(i));
                    System.out.println("First difference returned");
                    break;
                }
            }
        }
        return array1.equals(array2);
    }

}
