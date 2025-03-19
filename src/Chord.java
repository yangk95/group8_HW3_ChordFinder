public class Chord {

    //an array of the 3 notes
    private String[] chordNotes;
    
    //constructor
    public Chord(String rootNote, String thirdNote, String fifthNote){
        this.chordNotes = new String[]{rootNote, thirdNote, fifthNote};
    }

    //checks if the chord is a real chord
    public boolean isValidChord(){
        
        return false;
    }
}
