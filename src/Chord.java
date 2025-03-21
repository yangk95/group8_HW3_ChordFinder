import java.util.HashMap;
import java.util.Map;

public class Chord {

    String rootNote;
    String thirdNote;
    String fifthNote;
    String chordType; //added
    
    //constructor
    public Chord(String rootNote, String thirdNote, String fifthNote){
        this.rootNote = rootNote;
        this.thirdNote = thirdNote;
        this.fifthNote = fifthNote;
        this.chordType = determineChordType(); //added
    }

    //we should change this to just return the chord name
    //but for the moment i have it return the notes for debugging
    @Override
    p public String toString(){
        return isValidChord() ? rootNote + " " + chordType : rootNote + " unknown"; //updated
    }

    public boolean isValidChord() { //added
    	return chordType != null;
    }
    
    private String determineChordType() { //updated
        int rootToThird = getInterval(rootNote, thirdNote);
        int thirdToFifth = getInterval(thirdNote, fifthNote);

        if (rootToThird == 4 && thirdToFifth == 3) return "maj";
        if (rootToThird == 3 && thirdToFifth == 4) return "min";
        if (rootToThird == 3 && thirdToFifth == 3) return "dim";
        if (rootToThird == 4 && thirdToFifth == 4) return "aug";

        return null;
    }
    
    private int getInterval(String from, String to) {
        int fromTone = getTone(from);
        int toTone = getTone(to);
        if (fromTone == -1 || toTone == -1) return -1;
        return (toTone - fromTone + 12) % 12;
    }

    // Public helper for ChordFinder to validate notes
    public static boolean isValidNote(String note) {
        return noteToToneMap.containsKey(note);
    }

    //the following is a method and a map to get the tone of each note
    //this probally should be put in its own class but im lazy so im hiding it at the bottom
    public static int getTone(String note) {
        return noteToToneMap.getOrDefault(note, -1);
    }
    private static final Map<String, Integer> noteToToneMap = new HashMap<>();
    static {
        noteToToneMap.put("A", 0);
        noteToToneMap.put("A#", 1);
        noteToToneMap.put("Bb", 1);
        noteToToneMap.put("B", 2);
        noteToToneMap.put("Cb", 2);
        noteToToneMap.put("B#", 3);
        noteToToneMap.put("C", 3);
        noteToToneMap.put("C#", 4);
        noteToToneMap.put("Db", 4);
        noteToToneMap.put("D", 5);
        noteToToneMap.put("D#", 6);
        noteToToneMap.put("Eb", 6);
        noteToToneMap.put("E", 7);
        noteToToneMap.put("Fb", 7);
        noteToToneMap.put("E#", 8);
        noteToToneMap.put("F", 8);
        noteToToneMap.put("F#", 9);
        noteToToneMap.put("Gb", 9);
        noteToToneMap.put("G", 10);
        noteToToneMap.put("G#", 11);
        noteToToneMap.put("Ab", 11);
    }


}
