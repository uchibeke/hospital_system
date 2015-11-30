/*
 * 
 */
package commands;

import java.util.LinkedList;
import containers.WardAccess;

// TODO: Auto-generated Javadoc
/**
 * Command to obtain the list of empty beds for the ward The list is accessible via the method
 * getEmptyBedsList.
 */
public class EmptyBedsCommand extends CommandStatus {
    /**
     * The list of the integer labels of the empty beds in the ward.
     */
    private LinkedList<Integer> emptyBedsList;

    /**
     * Obtain the list of empty beds for the ward and place the list in emptyBedsList.
     */
    public void findEmptyBedsList() {
        emptyBedsList = WardAccess.ward().availableBeds();
        successful = true;
    }

    /**
     * Return the list of the empty beds in the ward.
     *
     * @return return the list of the empty beds in the ward
     * @precond wasSuccessful()
     */
    public LinkedList<Integer> getEmptyBedsList() {
        if (!wasSuccessful())
            throw new RuntimeException("The method obtainEmptyBeds() must be "
                    + "invoked before this method");
        return emptyBedsList;
    }
}
