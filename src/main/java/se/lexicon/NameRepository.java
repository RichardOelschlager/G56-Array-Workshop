package se.lexicon;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        String[] empty = new String[0];
        NameRepository.names = empty;
     }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        String[] namesCopy = NameRepository.names;
        return namesCopy;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        for (String name : names){
            if (fullName.equalsIgnoreCase(name)) {
                return name;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        if(find(fullName) != null){
            String[] newArray = new String[names.length + 1];
            System.arraycopy(names, 0, newArray, 0, names.length);
            newArray[names.length] = fullName;
            return true;
        }
        return false;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        if (names == null || names.length == 0) {
            return new String[0];
        }

        int count = 0;
        for (String fullName : names) {
            String[] parts = fullName.split(" ");
            if (parts.length > 0 && parts[0].equals(firstName)) {
                count++;
            }
        }
        String[] matches = new String[count];
        int index = 0;
        for (String fullName : names) {
            String[] parts = fullName.split(" ");
            if (parts.length > 0 && parts[0].equals(firstName)) {
                matches[index] = fullName;
                index++;
            }
        }
        return matches;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {

        if (names == null || names.length == 0) {
            return new String[0]; // Return empty array if names is empty
        }

        // First, count matches
        int count = 0;
        for (String fullName : names) {
            String[] parts = fullName.split(" ");
            if (parts.length > 0 && parts[1].equals(lastName)) {
                count++;
            }
        }

        // Create result array of exact size
        String[] matches = new String[count];

        // Fill result array
        int index = 0;
        for (String fullName : names) {
            String[] parts = fullName.split(" ");
            if (parts.length > 0 && parts[1].equals(lastName)) {
                matches[index] = fullName;
                index++;
            }
        }

        return matches;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        if (names == null || names.length == 0) {
            return false;
        }

        for (String name : names) {
            if (name.equals(updatedName)) {
                return false;
            }
        }

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                names[i] = updatedName;
                return true;
            }
        }
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(String fullName) {
        if (names == null || names.length == 0) {
            return false;
        }
        int indexToRemove = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(fullName)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove == -1) {
            return false;
        }
        String[] newNames = new String[names.length - 1];
        int newIndex = 0;
        for (int i = 0; i < names.length; i++) {
            if (i != indexToRemove) {
                newNames[newIndex] = names[i];
                newIndex++;
            }
        }
        names = newNames;
        return true;
    }


}