package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {
    private int[] ints;

    public DynamicIntArray() {
    }

    public DynamicIntArray(int numOfElements) {
        this.ints = new int[numOfElements];
    }

    public void add(int i) {
        if (ints == null) {
            ints = new int[1];
            ints[0] = i;
        } else {
            int newCapacity = ints.length + 1;
            int[] newInts = new int[newCapacity];
            moveArray(ints, newInts);
            newInts[newInts.length - 1] = i;
            ints = newInts;
        }
    }


    public void remove(int i) {
        int newCapacity = ints.length - 1;
        int[] newInts = new int[newCapacity];
        int firstEmptyIndex = 0;

        for (int number : ints) {
            if (number != i) {
                newInts[firstEmptyIndex] = number;
                firstEmptyIndex++;
            }
        }
        ints = newInts;
    }

    public void insert(int index, int number) {
        int newCapacity = ints.length + 1;
        int[] newInts = new int[newCapacity];
        int actualIndex = 0;

        if (index > newCapacity) {
            newInts[newCapacity - 1] = number;
        }

        for (int i = 0; i < ints.length; i++) {

            if (i == index) {
                newInts[actualIndex] = number;
                actualIndex++;
            }
            newInts[actualIndex] = ints[i];
            actualIndex++;
        }

        ints = newInts;
    }

    @Override
    public String toString() {
        String intsToString = "";
        for (int number : ints) {
            intsToString += " " + number;
        }
        return intsToString;
    }

    private void moveArray(int[] from, int[] to) {
        for (int i = 0; i < from.length; i++) {
            to[i] = from[i];
        }
    }
}
