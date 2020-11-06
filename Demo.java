public class Demo {
    public static void main(String[] a) {
        SuperArray words = new SuperArray();
        //grouped to save vertical space
        words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");     
        words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
        words.add("una");    words.add("ebi");     words.add("toro"); 

        System.out.println(words);
        removeDuplicates(words);
        System.out.println(words);
    }

    public static void removeDuplicates(SuperArray s) {
        for (int i = s.size() - 1; i > 0; i--) {
            if (s.indexOf(s.get(i)) != i) {
                s.remove(i);
            }
        }
    }
}