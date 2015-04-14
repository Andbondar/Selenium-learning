package Checks;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bondar on 4/14/2015.
 */
public class CompareArrays {
    //return boolean + print difference to console if it is present (size or specific element = 1st occurred difference)
    public static boolean compareListsAsStringArrays(List<String> expectedList, List<String> inputList){
        String[] expectedArray = new String[expectedList.size()];
        String[] inputArray = new String[inputList.size()];
        expectedArray = expectedList.toArray(expectedArray);
        inputArray = inputList.toArray(inputArray);
        return compareStringArrays(expectedArray, inputArray);
    }

    public static boolean compareStringArrays(String[] expectedArray, String[] inputArray){
        if (expectedArray.length != inputArray.length){
            System.out.println("Arrays sizes are not equal: " + expectedArray.length + " and " + inputArray.length + " elements correspondingly.");
            return false;
        }
        else { //print difference to console
            for (int i = 0; i < expectedArray.length; i++){

                if (!Arrays.asList(expectedArray).contains(inputArray[i])){
                    System.out.println("Element \"" + inputArray[i] + "\"(#" + (i+1) + ") is absent in the expected array.");
                    System.out.println("First difference returned");
                    return false;
                }
            }
        }
        return true;
    }

}
