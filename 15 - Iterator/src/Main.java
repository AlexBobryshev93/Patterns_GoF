public class Main {
    public static void main(String[] args) {
        Iterable container = new StringArrayContainer(new String[]{"str1", "str2", "str5"});
        Iterator iterator = container.getIterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Iterable {
    Iterator getIterator();
}

class StringArrayContainer implements Iterable {
    private String[] strings;

    public StringArrayContainer(String[] strings) {
        this.strings = strings;
    }

    @Override
    public Iterator getIterator() {
        return new StringArrayIterator();
    }

    private class StringArrayIterator implements Iterator {
        private int index;

        @Override
        public boolean hasNext() {
            if (index < strings.length) return true;
            return false;
        }

        @Override
        public Object next() {
            return strings[index++];
        }
    }
}