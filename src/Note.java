import exception.InvalidNoteException;
import utilities.NoteADT;


public class Note extends NoteADT {

    public Note(double frequency) throws InvalidNoteException {
        super(frequency);
        
    }

    public Note(int semitones) throws InvalidNoteException {
        super(semitones);
    }

    public Note(String strNote) throws InvalidNoteException {
        super(strNote);
        
    }

    @Override
    public double getFrequencyInHz() {
        
        int midiVal = this.getMIDIAbsoluteNumber();
        
        double xxx = midiVal - 69.0;
        double ccc = xxx / 12.0;
        double frequency = Math.pow(2.0, ccc) * 440.0;
        
        return frequency;
    }

    @Override
    public int getHalfSteps() {
        
        double frequency = this.getFrequencyInHz();
        
        Logarithm logarithm = new Logarithm();
        
        //n  =  12*log2(fn/440 Hz).
        
        double n = 12 * logarithm.log2(frequency/440);
        
        double rounded = Math.round(n);
        
        return (int)rounded;
    }

    @Override
    public int getMIDIAbsoluteNumber() {
        return this.midiNoteValue;
    }

    @Override
    public boolean formOctave(NoteADT note) {
        
        int semiToneVal = note.getHalfSteps();
        int thisSemiTone = this.getHalfSteps();
        
        int differenceInSemiTone = thisSemiTone - semiToneVal;
        
        if(differenceInSemiTone == -12 || differenceInSemiTone == 12)
        {
            return true;
        }else
        {
            return false;
        }
        
    }

    @Override
    public void modifyNoteBySemitones(int numberOfSemitones) {

        try {
            
            Note temp = new Note(numberOfSemitones);
            
            int midiVal = temp.getMIDIAbsoluteNumber();
            
            this.midiNoteValue = midiVal;
            
            
        } catch (InvalidNoteException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public int compareTo(NoteADT note)
    {
        if(this.getMIDIAbsoluteNumber() == note.getMIDIAbsoluteNumber())
        {
            return 0;
        }
        return -1;
    }
    
}