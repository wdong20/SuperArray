public class SuperArray {
    private String[] data;
    private int size;

    public SuperArray() {
        data = new String[10];
        size = 0;
    }

    public SuperArray(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("initialCapacity of " + initialCapacity + " is invalid, initialCapacity must be >= 0");
        }

        data = new String[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean add(String element) {
        if (size == data.length) {
            resize();
        }
        data[size] = element;
        size++;

        return true;
    }

    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index of " + index + " is out of bounds, index must be between 0 and size inclusive");
        }

        if (size == data.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index of " + index + " is out of bounds, index must be between 0 and size-1 inclusive");
        }
        String out = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
            data[i] = null;
        }

        size--;

        return out;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index of " + index + " is out of bounds, index must be between 0 and size-1 inclusive");
        }
        return data[index];
    }

    public String set(int index, String element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index of " + index + " is out of bounds, index must be between 0 and size-1 inclusive");
        }
        String out = data[index];
        data[index] = element;
        return out;
    }

    private void resize() {
        String[] newData = new String[2 * (size + 1)];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        data = new String[10];
        size = 0;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }

        String out = "[";
        for (int i = 0; i < size - 1; i++) {
            out += data[i] + ", ";
        }
        out += data[size - 1] + "]";

        return out;
    }

    public boolean contains(String s) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(String s) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(s)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(String s) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    public String[] toArray() {
        String[] out = new String[size];
        for (int i = 0; i < size; i++) {
            out[i] = data[i];
        }
        return out;
    }

    public boolean equals(SuperArray other) {
        if (other.size != size) {
            return false;
        }
        
        for (int i = 0; i < size; i++) {
            if (!other.data[i].equals(data[i])) {
                return false;
            }
        }
        return true;
    }
}