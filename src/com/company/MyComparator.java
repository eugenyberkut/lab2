package com.company;

import java.util.Comparator;

/**
 * Created by Eugeny on 25.09.2016.
 */
public class MyComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getName().compareTo(o1.getName());
    }
}
