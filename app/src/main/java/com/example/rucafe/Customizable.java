package com.example.rucafe;

/**
 * The interface represents a container for adding and removing objects.
 * @author Alark Patel, Nicolas Ku
 *
 */
public interface Customizable {
        /**
         * Adds object extending Customizable.
         * @param obj Object to be added
         * @return true if added, false otherwise.
         */
        boolean add(Object obj);
        /**
         * Removes object extending Customizable.
         * @param obj object to be removed.
         * @return true if removed, false otherwise.
         */
        boolean remove(Object obj);
}
