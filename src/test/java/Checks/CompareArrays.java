package Checks;

import java.util.List;

/**
 * Created by bondar on 4/14/2015.
 */
public class CompareArrays {
    //return boolean + print difference to console if it is present (size or specific element = 1st occurred difference)
    public static boolean compareListsByElements(List expectedList, List inputList){
        if (expectedList.size() != inputList.size()){
            System.out.println("Arrays sizes are not equal: " + expectedList.size() + " and " + inputList.size() + " elements correspondingly.");
            return false;
        }
        else { //print difference to console
            for (int i = 0; i < expectedList.size(); i++){

                if (!expectedList.contains(inputList.get(i))){
                    System.out.println("Element \"" + inputList.get(i) + "\"(#" + (i+1) + ") is absent in the expected array.");
                    System.out.println("First difference returned");
                    return false;
                }
            }
        }
        return true;
    }
}
