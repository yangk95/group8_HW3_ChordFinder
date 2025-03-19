import java.util.HashMap;
import java.util.Map;

public class Chord {

    String rootNote;
    String thirdNote;
    String fifthNote;
    
    //constructor
    public Chord(String rootNote, String thirdNote, String fifthNote){
        this.rootNote = rootNote;
        this.thirdNote = thirdNote;
        this.fifthNote = fifthNote;
    }

    //we should change this to just return the chord name
    //but for the moment i have it return the notes for debugging
    @Override
    public String toString(){
        return rootNote + " " + thirdNote + " " + fifthNote;
    }

    //checks if the chord is a real chord
    public boolean isValidChord(){
        //gets distance in semi-tones for the 3 notes
        int distanceFromRootToThird = (getTone(this.thirdNote) - getTone(this.rootNote) + 12) % 12;
        int distanceFromThirdToFifth = (getTone(this.fifthNote) - getTone(this.thirdNote) + 12) % 12;
        
        //all cases where a real chord exists
        return (distanceFromRootToThird == 4 && distanceFromThirdToFifth == 3) || // Major 
               (distanceFromRootToThird == 3 && distanceFromThirdToFifth == 4) || // Minor 
               (distanceFromRootToThird == 3 && distanceFromThirdToFifth == 3) || // Diminished
               (distanceFromRootToThird == 4 && distanceFromThirdToFifth == 4);   // Augmented
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
