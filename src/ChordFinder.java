// Group Members: Dustin M., Riley S.

import java.util.HashSet;
import java.util.Set;

public class ChordFinder{

    //this takes space-separated notes, returns Set<String> of chord names
    public Set<String> getChordName(String chordInput) {
        if (chordInput == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        String[] notes = chordInput.trim().split("\\s+");
        if (notes.length != 3) {
            throw new IllegalArgumentException("Input must contain exactly three notes.");
        }

        //checks each note
        for (String note : notes) {
            if (!Chord.isValidNote(note)) {
                throw new IllegalArgumentException("Invalid note: " + note);
            }
        }

        Set<Chord> validChords = getAllChords(notes[0], notes[1], notes[2]);
        Set<String> chordNames = new HashSet<>();

        for (Chord chord : validChords) {
            chordNames.add(chord.toString()); //this assumes toString() returns "C min", "G maj", etc.
        }

        return chordNames;
    }

    

    //this returns a set of all valid chords from 3 notes
    public Set<Chord> getAllChords(String firstNote, String secondNote, String thirdNote){
        Set<Chord> returnSet = new HashSet<>();
        Set<Chord> tempSet = new HashSet<>();

        //adds all possible chords
        tempSet.add(new Chord(firstNote, secondNote, thirdNote));
        tempSet.add(new Chord(firstNote, thirdNote, secondNote));

        tempSet.add(new Chord(secondNote, firstNote, thirdNote));
        tempSet.add(new Chord(secondNote, thirdNote, firstNote));

        tempSet.add(new Chord(thirdNote, firstNote, secondNote));
        tempSet.add(new Chord(thirdNote, secondNote, firstNote));

        //removes all invalid chords form the set
        for (Chord chord : tempSet) {
            if (chord.isValidChord()) {
                returnSet.add(chord);
            }
        }
        return returnSet;
    }
}
