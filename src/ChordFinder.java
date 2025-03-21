// Group Members: Dustin M., Riley S., Khu Y.

import java.util.HashSet;
import java.util.Set;

public class ChordFinder{

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
