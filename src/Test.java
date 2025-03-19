import java.util.Set;

public class Test {
    public static void main(String[] args) {
        ChordFinder cf = new ChordFinder();

        //same example that is used in the pdf, and return all the same chords
        Set<Chord> mySet = cf.getAllChords("B", "D#", "G");
        System.out.println(mySet);
    }
}
